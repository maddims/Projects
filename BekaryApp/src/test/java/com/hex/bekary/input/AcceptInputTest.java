package com.hex.bekary.input;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.hex.bekary.exceptions.BekaryAppException;

class AcceptInputTest {

	@Test
	void testvalidateInput() {
		boolean isInputValid = AcceptInput.validateInput("VS5", "10");
		assertEquals(true, isInputValid);
	}
	
	@Test()
	void testvalidateInputWithInvalidQuantity() {
		assertThrows(BekaryAppException.class, () -> {
			AcceptInput.validateInput("VS5", "TEST");
		  });
	}
	
	@Test()
	void testvalidateInputWithNoQuantity() {
		assertThrows(BekaryAppException.class, () -> {
			AcceptInput.validateInput("VS5", " ");
		  });
	}
	
	@Test()
	void testvalidateInputWithInvalidProduct() {
		assertThrows(BekaryAppException.class, () -> {
			AcceptInput.validateInput("TEST", "10");
		  });
	}
	
	
}
