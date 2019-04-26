package com.nordea.test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.nordea.asmnt.beans.Conversion;
import com.nordea.asmnt.beans.Sentence;
import com.nordea.asmnt.service.CSVConversionService;
import com.nordea.test.util.Constants;

public class CSVConversionServiceTest implements Constants {
	
	private static Map<Sentence, String> sentences= null;
	
	@Before
	public void init() {
		sentences=new LinkedHashMap<>();
		sentences.put(new Sentence(TEST_SENTENCE), TEST_SENTENCE);
	}
	
	@Test
	public void testConversionCall() {
		Conversion conversion = Mockito.mock(CSVConversionService.class);
		conversion.convert(sentences);
		verify(conversion).convert(sentences);
		verify(conversion,Mockito.times(1)).convert(sentences);
	}
	
	@Test
	public void testMakeCsvHeader() {
		Conversion csvconversion = new CSVConversionService();
		StringBuilder result = ((CSVConversionService)csvconversion).MakeCsvHeader.apply(2);
		assertEquals(TEST_CSV_HEADER, result.toString());
		assertTrue(((CSVConversionService)csvconversion).MakeCsvHeader.apply(0).length()==0);
	}
	
	@Test
	public void testMakeCsvBody() {
		Conversion csvconversion = new CSVConversionService();
		StringBuilder result = ((CSVConversionService)csvconversion).ConvertBodytoCSV.apply(sentences);
		assertEquals(TEST_CSV_SENTENCE, result.toString());
		sentences.clear();
		assertTrue(((CSVConversionService)csvconversion).ConvertBodytoCSV.apply(sentences).length()==0); 
	}

}
