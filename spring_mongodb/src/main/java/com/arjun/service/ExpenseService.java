package com.arjun.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.arjun.model.Expense;
import com.arjun.model.ExpenseCategory;
import com.arjun.repository.ExpenseRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExpenseService {

	private final ExpenseRepository expenseRepository;


	public void addExpense(Expense expense) {
		expenseRepository.insert(expense);

	}

	
	public List<Expense> getAllExpense() {
		return	expenseRepository.findAll();
	}


	
	public void updateExpense( Expense expense) {

		Expense savedExpense = expenseRepository.findById(expense.getId())
				.orElseThrow(() -> new RuntimeException(
						String.format("Can't find expense by id %s", expense.getId())));

		savedExpense.setExpenseName(expense.getExpenseName());
		savedExpense.setExpenseCategory(expense.getExpenseCategory() );
		savedExpense.setExpenseAmount(expense.getExpenseAmount());

		expenseRepository.save(expense);

	}

	
	
	public Expense getExpenseByName( String name) {
		return	expenseRepository.findByName(name)
				.orElseThrow(() -> new RuntimeException(
						String.format("Can't find Expense by name %s", name)));
	}

	
	
	public void deleteExpense(String  id) {
		expenseRepository.deleteById(id);
	}



}
