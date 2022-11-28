package org.iiitb.splitwise.repositories;

import java.util.List;

import org.iiitb.splitwise.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
	List<Expense> findByForGroup(String group);
}
