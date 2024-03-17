package com.rajan.eta.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.rajan.eta.Entities.Expense;
import com.rajan.eta.Service.ExpenseService;

@RestController
public class ExpenseController {
	@Autowired
	private ExpenseService expenseService;
	
	@GetMapping("/expenses/{expense_id}")
	public Expense getExpenseById(@PathVariable Long expense_id) {
		return expenseService.getExpenseById(expense_id);
	}
	
	@GetMapping("/expenses")
	public List<Expense> getAllExpenses(Pageable page) {
		return expenseService.getAllExpenses(page).toList();
	}
	
	@PostMapping("/expenses")
	public Expense addExpense(@RequestBody Expense expense) {
		return expenseService.addExpense(expense);
	}
	
	@PutMapping("/expenses/{expense_id}")
	public Expense updateExpense(@PathVariable Long expense_id, @RequestBody Expense expense) {
		return expenseService.updateExpense(expense_id, expense);
	}
}
