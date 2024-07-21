package com.dheeraj.assignment;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * This class bootstraps the application on a web server such as tomcat.
 * 
 * @author Dheeraj Verma
 * @since v1.0.0
 */
public class ServletInitializer extends SpringBootServletInitializer {

	/**
	 * Configures the spring boot application to run on a web server.
	 * 
	 * @param springApplicationBuilder - Spring Application Builder object.
	 * @return {@code SpringApplicationBuilder} - Configured Spring Application Builder object.
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder springApplicationBuilder) {
		return springApplicationBuilder.sources(JsonManipulationApplication.class);
	}

}