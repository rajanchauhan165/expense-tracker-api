package com.rajan.eta.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	@GetMapping("/expenses")
	public List<Expense> getAllExpenses() {
		return expenseService.getAllExpenses();
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
