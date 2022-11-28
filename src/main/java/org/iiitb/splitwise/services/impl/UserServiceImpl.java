package org.iiitb.splitwise.services.impl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.iiitb.splitwise.model.User;
import org.iiitb.splitwise.repositories.UserRepository;
import org.iiitb.splitwise.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository ur;

	@Override
	public User saveUser(User user) {
		User u = ur.findByUsername(user.getUsername());
		if(u != null) return null;
		if(!checkValidation(user)) return null;
		return ur.save(user);
	}

	@Override
	public void delUser(String username) {
		ur.deleteById(username);
	}

	@Override
	public User login(String email, String password) {
		return ur.findByEmailAndPassword(email, password);
	}

	@Override
	public String[] userGroups(String username) {
		return ur.findByUsername(username).getGroups().split(", ");
	}

	@Override
	public List<User> allUsers() {
		return ur.findAll();
	}

	private Boolean checkValidation(User user) {
		String regexEmail = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
		Pattern patternEmail = Pattern.compile(regexEmail);
		Matcher matcherEmail = patternEmail.matcher(user.getEmail());

		if (user.getPassword().length() < 3 || user.getPassword().length() > 8) return false;
		if (!matcherEmail.matches()) return false;
		return true;
	}
}
