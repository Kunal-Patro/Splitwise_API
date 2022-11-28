package org.iiitb.splitwise.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.iiitb.splitwise.model.Group;
import org.iiitb.splitwise.model.User;
import org.iiitb.splitwise.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin
@RestController
@Slf4j
public class AppController {

	@Autowired
	private UserService us;

	@Autowired
	private HttpSession httpSession;

	@PostMapping("register")
	public ResponseEntity<User> register(@RequestBody User user) {
		User u = us.saveUser(user);
		if (u != null) {
			log.info("[200] - [ " + u.getUsername() + " logged in]");
			return ResponseEntity.ok(u);
		}
		return ResponseEntity.ok(null);

	}

	@PostMapping("login")
	public ResponseEntity<User> login(@RequestBody User user) {
		User dbUsr = us.login(user.getEmail(), user.getPassword());
		if (dbUsr != null && dbUsr.getEmail().equals(user.getEmail())
				&& dbUsr.getPassword().equals(user.getPassword())) {
			httpSession.setAttribute("user", dbUsr.getUserId());
			return ResponseEntity.ok(dbUsr);
		}
		return ResponseEntity.ok(null);
	}

	@GetMapping("users")
	public ResponseEntity<List<User>> allUsers() {
		return ResponseEntity.ok(us.allUsers());
	}
}