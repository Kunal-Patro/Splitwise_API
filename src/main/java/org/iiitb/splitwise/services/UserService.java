package org.iiitb.splitwise.services;

import java.util.List;

import org.iiitb.splitwise.model.Group;
import org.iiitb.splitwise.model.User;

public interface UserService {
	User saveUser(User user);

	void delUser(String username);

	User login(String email, String password);

	String[] userGroups(String username);

	List<User> allUsers();
}
