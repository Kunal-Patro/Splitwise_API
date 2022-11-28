package org.iiitb.splitwise.startup;

import org.iiitb.splitwise.model.Expense;
import org.iiitb.splitwise.model.Group;
import org.iiitb.splitwise.model.User;
import org.iiitb.splitwise.repositories.ExpenseRepository;
import org.iiitb.splitwise.repositories.GroupRepository;
import org.iiitb.splitwise.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Start {

	@Autowired
	private UserRepository ur;

	@Autowired
	private GroupRepository gr;

	@Autowired
	private ExpenseRepository er;

	@EventListener(ContextRefreshedEvent.class)
	public void bootUp() {
		System.out.println("Startup Starts");

		User u0 = new User();
		u0.setEmail("aman.gupta@iiitb.ac.in");
		u0.setUserId(1);
		u0.setUsername("bolleyboll");
		u0.setPassword("password");
		u0.setName("Aman Gupta");
		u0.setGroups("1, 2, 3");
		ur.save(u0);

		User u1 = new User();
		u1.setEmail("aman.iv0012@gmail.com");
		u1.setUserId(2);
		u1.setUsername("amang");
		u1.setPassword("password");
		u1.setName("Aman G");
		u1.setGroups("2, 3");
		ur.save(u1);

		User u2 = new User();
		u2.setEmail("aman@gmail.com");
		u2.setUserId(3);
		u2.setUsername("red");
		u2.setPassword("password");
		u2.setName("Smokes");
		u2.setGroups("1, 3");
		ur.save(u2);

		User u3 = new User();
		u3.setEmail("amn@gmail.com");
		u3.setUserId(4);
		u3.setUsername("chief");
		u3.setPassword("password");
		u3.setName("Master Chief");
		u3.setGroups("1, 2, 3");
		ur.save(u3);

		Group g0 = new Group();
		g0.setGroupId(1);
		g0.setName("Roommates-Bangalore");
		g0.setMembers("bolleyboll, red, chief");
		gr.save(g0);

		Group g1 = new Group();
		g1.setGroupId(2);
		g1.setName("Google-IO");
		g1.setMembers("bolleyboll, amang, chief");
		gr.save(g1);

		Group g2 = new Group();
		g2.setGroupId(3);
		g2.setName("Wonderla");
		g2.setMembers("bolleyboll, amang, red, chief");
		gr.save(g2);

		Expense e0 = new Expense();
		e0.setExpenseId(1);
		e0.setName("Samosa");
		e0.setAmount(50.0);
		e0.setForGroup("2");
		e0.setSplitBetween("bolleyboll: +50, amang: -20, chief: -20");
		er.save(e0);

		Expense e1 = new Expense();
		e1.setExpenseId(2);
		e1.setName("Bus");
		e1.setAmount(150.0);
		e1.setForGroup("2");
		e1.setSplitBetween("bolleyboll: +150, amang: -50, chief: -50");
		er.save(e1);

		Expense e2 = new Expense();
		e2.setExpenseId(3);
		e2.setName("Lunch");
		e2.setAmount(2500.0);
		e2.setForGroup("2");
		e2.setSplitBetween("bolleyboll: +2500, amang: -1250");
		er.save(e2);

		Expense e3 = new Expense();
		e3.setExpenseId(4);
		e3.setName("Cab");
		e3.setAmount(150.0);
		e3.setForGroup("2");
		e3.setSplitBetween("amang: +150, chief: -100");
		er.save(e3);

		Expense e4 = new Expense();
		e4.setExpenseId(5);
		e4.setName("Sandwich");
		e4.setAmount(150.0);
		e4.setForGroup("2");
		e4.setSplitBetween("red: -75, chief: +150");
		er.save(e4);

		System.out.println("Startup End");

	}
}
