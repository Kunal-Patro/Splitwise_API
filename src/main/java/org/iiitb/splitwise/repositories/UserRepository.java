package org.iiitb.splitwise.repositories;

import org.iiitb.splitwise.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
	User findByUsername(String username);

	User findByEmailAndPassword(String email, String password);
}
