package com.nordea.asmnt.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.nordea.asmnt.beans.Sentence;
import com.nordea.asmnt.util.ConversionFactory;
import com.nordea.asmnt.util.InputValidationUtil;

/**
 * Description - TextConversionApplication Main class
 * 
 * @author Sriphani
 *
 */
public class TextConversionApplication {

	public static Logger log = LogManager.getLogger();

	public static void main(String[] args) {

		String file = "";

		try (Scanner fileNameScanner = new Scanner(System.in); Scanner inputChoiceScanner = new Scanner(System.in)) {
			
			log.info("Please enter valid file to convert \n Example: C:\\App\\home\\sample_data\\filename.extention");
			file = fileNameScanner.next();
			InputValidationUtil.isFileValid(file);

			log.info("Please choose option XML for XML conversion, CSV for CSV conversion or 0 to exit");
			String choice = inputChoiceScanner.next();
			InputValidationUtil.isUserChoiceValid(choice);
			
			BufferedReader br = Files.newBufferedReader(Paths.get(file));
			Map<Sentence, String> sentences = new LinkedHashMap<>();

			br.lines().filter(line -> !line.trim().isEmpty()).map(line -> line.replaceAll("[-+.^)’:(,/]", ""))
					.forEach(line -> sentences.put(new Sentence(line), line));

			ConversionFactory.getConversionService(choice.toUpperCase()).convert(sentences);

		} catch (IOException ex) {
			log.error("Exception occured in Main class " + ex.getMessage());
		} catch (RuntimeException ex) {
			log.error("Exception occured in Main class " + ex.getMessage());
		}

	}

}
