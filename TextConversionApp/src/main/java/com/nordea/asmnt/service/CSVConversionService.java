package com.nordea.asmnt.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.IntStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.nordea.asmnt.beans.Conversion;
import com.nordea.asmnt.beans.Sentence;

/**
 * Description - This class converts the Text data into CSV data.
 * 
 * @author Sriphani
 *
 */

public class CSVConversionService implements Conversion {

	private static Logger log = LogManager.getLogger(CSVConversionService.class);

	/**
	 * Handles Text to XML data conversion
	 */
	public void convert(Map<Sentence, String> sentences) {
		log.info("Converting text to CSV");

		int maxLength = new ArrayList<>(sentences.keySet()).stream().map(s -> s.getSentence())
				.max(Comparator.comparing(String::length)).get().split(" ").length;

		StringBuilder CSVResult = new StringBuilder();
		CSVResult.append(MakeCsvHeader.apply(maxLength));
		CSVResult.append(ConvertBodytoCSV.apply(sentences));

		System.out.println(CSVResult);
		log.info("Text to CSV Conversion completed Successfully.");
	}

	/**
	 * Gets/Forms the body of the CSV output
	 */
	public Function<Map<Sentence, String>, StringBuilder> ConvertBodytoCSV = (sentences) -> {
		long rowNum = 1;
		StringBuilder csvBody = new StringBuilder();

		for (Sentence sentence : sentences.keySet()) {
			String words[] = sentences.get(sentence).split(" ");
			Arrays.sort(words, String.CASE_INSENSITIVE_ORDER);
			StringBuilder line = new StringBuilder();
			line.append("\n");
			line.append("Sentence ").append(rowNum);

			IntStream.range(0, words.length).forEach(row -> {
				String word = words[row].trim();
				if (!word.isEmpty())
					line.append(", ").append(word);
			});
			
			sentences.put(sentence, line.toString());
			csvBody.append(line);
			line.append("");
			rowNum++;
		}
		return csvBody;
	};

	/**
	 * Gets/Forms the Header of the CSV output
	 */
	public Function<Integer, StringBuilder> MakeCsvHeader = maxLength -> {
		StringBuilder header = new StringBuilder();
		IntStream.rangeClosed(1, maxLength).forEach(columnNo -> header.append(", Word " + columnNo));
		return header;
	};

}
