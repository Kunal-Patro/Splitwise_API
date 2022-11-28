package org.iiitb.splitwise.services;

import java.util.List;

import org.iiitb.splitwise.model.Expense;
import org.iiitb.splitwise.model.Group;

public interface GroupService {
	Group groupDetails(Integer id);

	Group createGroup(Group group);

	List<Expense> groupExpenses(String id);

	Group addUserToGroup(String username, Integer grpId);
}
