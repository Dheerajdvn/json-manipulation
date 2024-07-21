package com.dheeraj.assignment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dheeraj.assignment.service.JsonManipulationService;

import lombok.RequiredArgsConstructor;

/**
 * Contains API definitions for the application.
 * 
 * @author Dheeraj Verma
 * @since v1.0.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class JsonManipulationController {

	// Injected service using constructor injection.
	private final JsonManipulationService jsonManipulationService;

	/**
	 * API to manipulate JSON based on given user input.
	 * 
	 * @param userInputStr - User input string.
	 * @return String - Manipulated JSON string.
	 */
	@GetMapping("/manipulate")
	public String manipulate(@RequestParam("inputStr") String userInputStr) {
		return jsonManipulationService.manipulateJson(userInputStr);
	}
}