package org.iiitb.splitwise.services.impl;

import java.util.List;

import org.iiitb.splitwise.model.Expense;
import org.iiitb.splitwise.model.Group;
import org.iiitb.splitwise.model.User;
import org.iiitb.splitwise.repositories.ExpenseRepository;
import org.iiitb.splitwise.repositories.GroupRepository;
import org.iiitb.splitwise.repositories.UserRepository;
import org.iiitb.splitwise.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GroupServiceImpl implements GroupService {

	@Autowired
	private UserRepository ur;

	@Autowired
	private GroupRepository gr;

	@Autowired
	private ExpenseRepository er;

	@Override
	public Group groupDetails(Integer id) {
		return gr.findByGroupId(id);
	}

	@Override
	public Group createGroup(Group group) {
		Group g = gr.save(group);
		User u = ur.findByUsername(group.getMembers());
		u.setGroups(u.getGroups() + ", " + g.getGroupId());
		ur.save(u);
		return g;
	}

	@Override
	public List<Expense> groupExpenses(String id) {
		return er.findByForGroup(id);
	}

	@Override
	public Group addUserToGroup(String username, Integer grpId) {
		Group g = gr.findByGroupId(grpId);
		g.setMembers(g.getMembers() + ", " + username);
		return gr.save(g);
	}

}
