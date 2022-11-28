package org.iiitb.splitwise.repositories;

import org.iiitb.splitwise.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Integer>{
	Group findByGroupId(Integer id);
}
