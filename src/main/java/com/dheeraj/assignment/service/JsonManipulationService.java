package com.dheeraj.assignment.service;

/**
 * Provides service methods for JSON manipulation.
 * 
 * @author Dheeraj Verma
 * @since v1.0.0
 */
public interface JsonManipulationService {

	/**
	 * Manipulates content of predefined JSON based on given user input.<br>
	 * Input format - "SearchString1:::ReplacementString1","SearchString2:::ReplacementString2",.....,"SearchStringN:::ReplacementStringN"<br>
	 * Example input - "New:::NewDocument","Open:::OpenDocument"<br>
	 * Expected output - New should be replaced by NewDocument and Open should be replaced by OpenDocument in the predefined JSON.
	 * 
	 * @param input - Comma separated user input with search and replacement string.
	 * @return string - Manipulated JSON.
	 */
	public String manipulateJson(String input);
}