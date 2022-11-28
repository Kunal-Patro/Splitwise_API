package org.iiitb.splitwise.controller;

import org.iiitb.splitwise.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin
@RestController
@RequestMapping("user")
@Slf4j
public class UserController {
	
	@Autowired
	private UserService us;

	@GetMapping("group/{username}")
	public ResponseEntity<String[]> userGroups(@PathVariable String username) {
		return ResponseEntity.ok(us.userGroups(username));
	}
}
