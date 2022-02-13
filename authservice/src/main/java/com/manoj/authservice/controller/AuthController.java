package com.manoj.authservice.controller;

import com.manoj.authservice.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api")
public class AuthController {
	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

	@Autowired
	private JwtUtil jwtUtil;

	@Value("${jwt.secret}")
	private String jwtSecret;

	@PostMapping("/token")
	public ResponseEntity<String> getToken(@RequestBody String username) {
		try {
			if (!username.equals("")) {
				String token = jwtUtil.generateToken(username);
				return new ResponseEntity<String>(token, HttpStatus.OK);

			} else {
				return new ResponseEntity<String>("", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception ex) {
			logger.error("AuthController getToken() -> Error {}" + ex.getMessage());
			return new ResponseEntity<String>("", HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/getusername/bytoken")
	public ResponseEntity<String> getUsernameByToken(@RequestBody String token) {
		try {
			String username = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();

			return new ResponseEntity<String>(username, HttpStatus.OK);

		} catch (Exception ex) {
			logger.error("AuthController getUsernameByToken() -> Error {}" + ex.getMessage());
			return new ResponseEntity<String>("", HttpStatus.OK);
		}
	}
}
