package com.nordea.test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.verify;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.nordea.asmnt.beans.Conversion;
import com.nordea.asmnt.beans.Sentence;
import com.nordea.asmnt.service.XMLConversionService;
import com.nordea.asmnt.util.Utility;
import com.nordea.test.util.Constants;

public class XMLConversionServiceTest implements Constants{
	
	private static Map<Sentence,String> sentences=null;
	private static Document doc = null;
	private Sentence sentence=null;
	@Before
	public void init() {
		doc=Utility.GetDocumentBuilder.get().newDocument();
		sentences=new LinkedHashMap<>();
		sentence = new Sentence(TEST_SENTENCE);
		sentences.put(sentence, TEST_SENTENCE);
	}
	
	@Test
	public void testConversionCall() {
		Conversion conversion = Mockito.mock(XMLConversionService.class);
		conversion.convert(sentences);
		verify(conversion).convert(sentences);
		verify(conversion,Mockito.times(1)).convert(sentences);
	}
	
	@Test
	public void testGetSentence() {
		Conversion xmlConversion = new XMLConversionService();
		Node result= ((XMLConversionService)xmlConversion).GetSentenceElements.apply(doc, sentences.get(sentence));
		assertNotNull(result);
		assertEquals(TEST_SENTENCE_NODE, result.getNodeName());
	}
	
	@Test
	public void testGetWord() {
		Conversion xmlConversion = new XMLConversionService();
		Node result= ((XMLConversionService)xmlConversion).GetWordElements.apply(doc, TEST_WORD);
		assertNotNull(result);
		assertSame(TEST_WORD_NODE, result.getNodeName());
		assertSame(TEST_WORD, result.getFirstChild().getNodeValue());
	}

}
