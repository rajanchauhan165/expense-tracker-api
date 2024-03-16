package com.rajan.eta.Service;
import java.util.List;
import com.rajan.eta.Entities.Expense;

public interface ExpenseService {
	public List<Expense> getAllExpenses();
	public Expense addExpense(Expense expense);
	public Expense updateExpense(Long expense_id, Expense expense);
}
