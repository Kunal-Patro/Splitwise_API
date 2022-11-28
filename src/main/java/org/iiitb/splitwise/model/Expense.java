package org.iiitb.splitwise.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
@Table(name = "expenses")
public class Expense {
	@Id
	@Column(name = "expenseId", unique = true, nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer expenseId;

	@Column(name = "name", length = 200, nullable = false)
	private String name;

	@Column(name = "amount")
	private Double amount;

	@Column(name = "forGroup", length = 50)
	private String forGroup;

	@Column(name = "splitBetween", length = 10000)
	private String splitBetween;
}