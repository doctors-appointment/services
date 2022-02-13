package com.manoj.userservice.controller;

import com.manoj.userservice.config.UsermgtServiceConfig;
import com.manoj.userservice.model.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RequestMapping("/api")
@RestController
public class ConfigController {
	private static final Logger logger = LoggerFactory.getLogger(ConfigController.class);
	
	@Autowired
	UsermgtServiceConfig usermgtServiceConfig; 
	
	@GetMapping("/userservice/properties")
	public String getPropertyDetails() throws JsonProcessingException {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		Properties properties = new Properties(usermgtServiceConfig.getMsg(), usermgtServiceConfig.getBuildVersion(),
				usermgtServiceConfig.getMailDetails(), usermgtServiceConfig.getActiveBranches());
		String jsonStr = ow.writeValueAsString(properties);
		return jsonStr;
	}
}
