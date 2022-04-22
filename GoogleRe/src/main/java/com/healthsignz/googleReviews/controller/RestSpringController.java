package com.healthsignz.googleReviews.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.healthsignz.googleReviews.service.GoogleReviewService;

@RestController
@RequestMapping(path = "/")
public class RestSpringController {

	@Autowired
	public GoogleReviewService googleReviewService;
//	private static final Logger logger = Logger.getLogger(RestSpringController.class);

//	@GetMapping(path = "/reviews", produces = "application/place_id", headers = "Accept=application/json")
	@GetMapping(path = "/reviews", headers = "Accept=application/json")
	public String getGoogleReviews(@RequestParam String placeId) {
		String response = "";
		try {
			response = googleReviewService.goolgeRatings(placeId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;

	}

}
