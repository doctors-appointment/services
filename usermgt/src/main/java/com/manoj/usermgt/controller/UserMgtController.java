package com.manoj.usermgt.controller;

import com.manoj.usermgt.model.UserMgtHealth;
import com.manoj.usermgt.repository.UserMgtHealthRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class UserMgtController {
	private static final Logger logger = LoggerFactory.getLogger(UserMgtController.class);

	@Autowired
	UserMgtHealthRepository userMgtHealthRepository;

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
