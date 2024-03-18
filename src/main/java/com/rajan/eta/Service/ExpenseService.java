package com.rajan.eta.Service;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.rajan.eta.Entities.Expense;
import com.rajan.eta.Exceptions.ExpenseException;

public interface ExpenseService {
	public Expense getExpenseById(Long id);
	public Page<Expense> getAllExpenses(Pageable page);
	public Expense addExpense(Expense expense);
	public Expense updateExpense(Long expense_id, Expense expense);
	public String deletExpense(Long id)throws ExpenseException;
	public List<Expense> findByCategory(String category, Pageable page);
	public List<Expense> findByNameContaining(String keyword, Pageable page);
	public List<Expense> findByDateBetween(LocalDate start, LocalDate end, Pageable page);
}
