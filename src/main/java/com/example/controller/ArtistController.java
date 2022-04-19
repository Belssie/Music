package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;

public class ArtistController {

	Logger logger = LoggerFactory.getLogger(ArtistController.class);
	@GetMapping("getArtist")
	public String getArtist() {
		
		logger.error("Inside error");
		logger.warn("Inside warning");
		logger.info("Inside info");
		logger.debug("Inside debug");
		logger.trace("Inside trace");
		
		return "This is the kid of the user";
	}
}
