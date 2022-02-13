package com.manoj.userservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manoj.userservice.model.UserMgtHealth;
import com.manoj.userservice.repository.UserMgtHealthRepository;
import com.manoj.userservice.service.UserMgtService;

@RequestMapping("/api")
@RestController
public class UserMgtController {
	private static final Logger logger = LoggerFactory.getLogger(UserMgtController.class);

	@Autowired
	UserMgtHealthRepository userMgtHealthRepository;

	@Autowired
	UserMgtService userMgtService;

	@GetMapping("/health")
	public String getUserMgtHealth() {
		try {
			UserMgtHealth userMgtHealth = userMgtHealthRepository.findByHealthId(Long.valueOf(1));
			return userMgtHealth.getDescription();
		} catch (Exception e) {
			return "Server Error";
		}
	}

}
