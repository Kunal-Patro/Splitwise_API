package org.iiitb.splitwise.controller;

import org.iiitb.splitwise.model.Expense;
import org.iiitb.splitwise.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin
@RestController
@RequestMapping("expense")
@Slf4j
public class ExpenseController {
	
	@Autowired
	private ExpenseService es;

	@PostMapping("add")
	public ResponseEntity<Expense> add(@RequestBody Expense expense) {
		return ResponseEntity.ok(es.add(expense));
	}
	
}
