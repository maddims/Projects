package com.nordea.asmnt.util;

import com.nordea.asmnt.beans.Conversion;
import com.nordea.asmnt.service.CSVConversionService;
import com.nordea.asmnt.service.XMLConversionService;

/**
 * Description - Factory to return Corresponding conversion approach based on user's choice.
 * @author Sriphani
 *
 */
public class ConversionFactory implements Constants{
	
	public static Conversion getConversionService(String choice) {
				
		switch(choice) {
		case XML_CONVERSION: return new XMLConversionService();
		case CSV_CONVERSION: return new CSVConversionService();
		case EXIT_CODE_0: System.exit(0);		
		}
		
	return null;
	}
}
