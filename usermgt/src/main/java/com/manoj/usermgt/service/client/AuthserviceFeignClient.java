package com.manoj.usermgt.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("authservice")
public interface AuthserviceFeignClient {
	@RequestMapping(method = RequestMethod.POST, value="/api/getusername/bytoken", consumes = MediaType.APPLICATION_JSON_VALUE)
	String getUsernameByToken(@RequestBody String token);
	
}
