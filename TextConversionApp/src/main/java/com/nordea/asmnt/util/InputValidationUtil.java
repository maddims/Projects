package com.nordea.asmnt.util;

import java.io.File;

/**
 * Description - This class validates the User Input
 * @author Sriphani
 *
 */

public class InputValidationUtil implements Constants {
	
	public static void isFileValid(String file) {
		if(!new File(file).exists()) {
			throw new RuntimeException("the file provided doesn't exists, please start again with valid file as input");
		}
	}
	
	public static void isUserChoiceValid(String choice) {
		if(!(choice.equalsIgnoreCase(XML_CONVERSION) || choice.equalsIgnoreCase(CSV_CONVERSION) || choice.equalsIgnoreCase(EXIT_CODE_0))) {
			throw new RuntimeException("invalid Choice provided, please start again with choice[XML,CSV,0]");
		}
	}

}
