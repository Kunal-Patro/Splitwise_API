package org.iiitb.splitwise.services.impl;

import org.iiitb.splitwise.model.Expense;
import org.iiitb.splitwise.model.Group;
import org.iiitb.splitwise.repositories.ExpenseRepository;
import org.iiitb.splitwise.repositories.GroupRepository;
import org.iiitb.splitwise.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	private GroupRepository gr;

	@Autowired
	private ExpenseRepository er;

	@Override
	public Expense add(Expense expense) {
		String paidBy = expense.getSplitBetween();
		Double amt = expense.getAmount();
		String f = paidBy + ": +" + amt.toString() + ", ";
		Integer grpId = Integer.parseInt(expense.getForGroup());
		Group g = gr.findByGroupId(grpId);
		String members = g.getMembers();
		String memL[] = members.split(", ");
		int count = memL.length;
		Double split = amt / count;

		for (int i = 0; i < memL.length; i++) {
			if (memL[i].equalsIgnoreCase(paidBy)) {
				continue;
			} else {
				f += memL[i] + ": -" + split.toString();
			}
			if (i != memL.length - 1) {
				f += ", ";
			}
		}
		expense.setSplitBetween(f);
		Expense e = er.save(expense);
		return e;
	}

}
