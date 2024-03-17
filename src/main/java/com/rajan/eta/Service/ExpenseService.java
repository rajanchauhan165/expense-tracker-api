package com.rajan.eta.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.rajan.eta.Entities.Expense;
import com.rajan.eta.Exceptions.ExpenseException;

public interface ExpenseService {
	public Expense getExpenseById(Long id)throws ExpenseException;
	public Page<Expense> getAllExpenses(Pageable page);
	public Expense addExpense(Expense expense);
	public Expense updateExpense(Long expense_id, Expense expense);
}
