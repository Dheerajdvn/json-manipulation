package com.dheeraj.assignment.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.dheeraj.assignment.entity.JsonData;
import com.dheeraj.assignment.repository.JsonDataRepository;
import com.dheeraj.assignment.service.JsonManipulationService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

/**
 * Implements JsonManipulationService interface methods.
 * 
 * @author Dheeraj Verma
 * @since v1.0.0
 */
@Service
@RequiredArgsConstructor
public class JsonManipulationServiceImpl implements JsonManipulationService {
	
	// Injected with constructor injection instead of Autowired.
	private final JsonDataRepository jsonDataRepository;
	// Predefined JSON Model
	public static final String SAMPLE_JSON_MODEL = "{\"menu\":{\"id\":\"file\",\"value\":\"File\",\"popup\":{\"menuitem\":[{\"value\":\"New\",\"onclick\":\"CreateDoc()\"},{\"value\":\"Open\",\"onclick\":\"OpenDoc()\"},{\"value\":\"Save\",\"onclick\":\"SaveDoc()\"}]}}}";

	/**
	 * Manipulates content of predefined JSON model based on given user input.<br>
	 * Input format - "SearchString1:::ReplacementString1","SearchString2:::ReplacementString2",.....,"SearchStringN:::ReplacementStringN"<br>
	 * Example input - "New:::NewDocument","Open:::OpenDocument"<br>
	 * Expected output - New should be replaced by NewDocument and Open should be replaced by OpenDocument in the predefined JSON.
	 * 
	 * @param input - Comma separated user input with search and replacement string.
	 * @return string - Manipulated JSON.
	 */
	@Override
	@Transactional
	public String manipulateJson(String input) {
		try {
			// Validate input before proceeding
			if (input == null || input.trim().length() == 0 || !input.contains(":::")) {
				return "Please provide correct user input.\r\nExample inputs:\r\n1. \"New:::NewDocument\"\r\n2. \"New:::NewDocument\",\"Open:::OpenDocument\"";
			}
			
			// Parse and get the search and replacement strings hash map.
			Map<String, String> searchReplaceStrMap = parseUserInputString(input);
			// Initialize the manipulatedJson with initial predefined JSON model.
			String manipulatedJson = SAMPLE_JSON_MODEL;
			
			// Replace the each key (Search string) with value (Replacement string) in the predefined JSON.
	        for (Map.Entry<String, String> entry : searchReplaceStrMap.entrySet()) {
	            manipulatedJson = manipulatedJson.replace(entry.getKey(), entry.getValue());
	        }
	        
	        // Save the manipulated JSON to database.
	        JsonData jsonData = new JsonData();
	        jsonData.setJsonmodel(manipulatedJson);
	        jsonDataRepository.save(jsonData);
	        
	        // Return the manipulated JSON.
	        return manipulatedJson;
		} catch (Exception exception) {
			exception.printStackTrace();
			return "An error occurred while manipulating JSON with given input. Error :: " + exception.getMessage();
		}
	}
	
	/**
	 * Parses the user input string into a HashMap where the key is search string and value is replacement string in parsed HashMap.
	 * 
	 * @param userInput - Comma separated user input with search and replacement string.
	 * @return Map - A hash map containing search and replacement strings.
	 */
	private Map<String, String> parseUserInputString(String userInput) {
		// Hash map to store the parsed key and values from input string.
		Map<String, String> parsedUserInputMap = new HashMap<>();
		// Splits the comma separated user input to String array.
		// Example: "New:::NewDocument","Open:::OpenDocument" is split into "New:::NewDocument" and "Open:::OpenDocument"
		String[] inputKeyValuePairs = userInput.split(",");

		// Iterate through each user input and split them into key and value pairs.
		for (String keyValuePair : inputKeyValuePairs) {
			// Remove the double inverted quotes from the input
			// Example: "New:::NewDocument" becomes New:::NewDocument
			keyValuePair = keyValuePair.replace("\"", "");
			// Now extract the key and value pair by splitting the string using :::
			// Example: New:::NewDocument is split into New and NewDocument
			String[] keyAndValue = keyValuePair.split(":::");
			
			// Key and value array length must be 2 containing only key and value
			if (keyAndValue.length == 2) {
				// Finally put the key and value into the map.
				parsedUserInputMap.put(keyAndValue[0], keyAndValue[1]);
			}
		}

		return parsedUserInputMap;
	}
}
