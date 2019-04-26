package com.nordea.asmnt.util;

import java.util.function.Supplier;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Description - This class is to return the commonly used objects
 * @author Sriphani
 *
 */
public class Utility {

	public static Logger log = LogManager.getLogger(Utility.class);
	
	public static Supplier<DocumentBuilder> GetDocumentBuilder = () -> {
		DocumentBuilder domBuilder = null;
		try {
			DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
			domBuilder = domFactory.newDocumentBuilder();
		}
		catch(ParserConfigurationException ex) {
			log.error("Exception while getting Document builder to parse xml "+ex.getMessage());
			throw new RuntimeException(ex.getMessage());
		}
		return domBuilder;		
	};
	
}
