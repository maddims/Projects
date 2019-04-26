package com.nordea.asmnt.service;

import java.util.Arrays;
import java.util.Map;
import java.util.function.BiFunction;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.nordea.asmnt.beans.Conversion;
import com.nordea.asmnt.beans.Sentence;
import com.nordea.asmnt.util.Utility;

/**
 * Description - This class converts the Text data into XML data.
 * 
 * @author Sriphani
 *
 */

public class XMLConversionService implements Conversion {

	private static Logger log = LogManager.getLogger(XMLConversionService.class);

	/**
	 * Handles Text to XML data conversion
	 */
	public void convert(Map<Sentence, String> sentences) {

		log.info("Converting text to XML");
		try {
			Document doc = Utility.GetDocumentBuilder.get().newDocument();

			Element rootElement = doc.createElement("text");
			doc.appendChild(rootElement);

			sentences.keySet().forEach(
					sentence -> rootElement.appendChild(GetSentenceElements.apply(doc, sentence.getSentence())));

			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
			DOMSource source = new DOMSource(doc);
			StreamResult console = new StreamResult(System.out);
			transformer.transform(source, console);
			log.info("Text to XML Conversion completed Successfully.");
		} catch (TransformerException ex) {
			log.error("Exception occured while XML Transformation " + ex.getMessage());
		} catch (RuntimeException ex) {
			log.error("Exception occured while XML Transformation " + ex.getMessage());
		}

	}

	/**
	 * Gets/Forms the word Elements
	 */
	public BiFunction<Document, String, Node> GetWordElements = (Document doc, String word) -> {
		Element node = doc.createElement("word");
		node.appendChild(doc.createTextNode(word));
		return node;
	};

	/**
	 * Gets/Forms the sentence Elements
	 */
	public BiFunction<Document, String, Node> GetSentenceElements = (Document doc, String sentence) -> {
		Element sentenceElement = doc.createElement("sentence");
		String[] words = sentence.split(" ");
		Arrays.sort(words, String.CASE_INSENSITIVE_ORDER);
		Arrays.stream(words).map(word -> word.trim()).filter(word -> !word.isEmpty())
				.forEach(word -> sentenceElement.appendChild(GetWordElements.apply(doc, word)));
		return sentenceElement;
	};

}
