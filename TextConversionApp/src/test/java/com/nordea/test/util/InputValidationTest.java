package com.nordea.test.util;

import org.junit.Test;

import com.nordea.asmnt.util.InputValidationUtil;

public class InputValidationTest implements Constants {
	
	@Test(expected=RuntimeException.class)
	public void inputFileNotExistsTest() {
		InputValidationUtil.isFileValid(TEST_FILE_NAME);
	}
	
	@Test(expected=RuntimeException.class)
	public void isUserChoiceValidTest() {
		InputValidationUtil.isUserChoiceValid(TEST_CHOICE);
	}
	
	

}
