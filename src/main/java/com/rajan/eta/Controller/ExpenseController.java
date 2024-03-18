package com.rajan.eta.Controller;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.rajan.eta.Entities.Expense;
import com.rajan.eta.Service.ExpenseService;

import jakarta.validation.Valid;

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
	public Expense addExpense(@Valid @RequestBody Expense expense) {
		return expenseService.addExpense(expense);
	}
	
	@PutMapping("/expenses/{expense_id}")
	public Expense updateExpense(@PathVariable Long expense_id, @RequestBody Expense expense) {
		return expenseService.updateExpense(expense_id, expense);
	}
	
	@DeleteMapping("/expenses/{expense_id}")
	public String deleteExpense(@PathVariable Long expense_id) {
		return expenseService.deletExpense(expense_id);
	}
	
	@GetMapping("/expenses/category")
	public List<Expense> findByCategory(@RequestParam String category, Pageable page){
		return expenseService.findByCategory(category, page);
	}
	
	@GetMapping("/expenses/name")
	public List<Expense> findByNameContaining(@RequestParam String keyword, Pageable page){
		return expenseService.findByNameContaining(keyword, page);
	}
	
	@GetMapping("/expenses/date")
	public List<Expense> findByDateBetween(@RequestParam LocalDate start,@RequestParam LocalDate end, Pageable page){
		return expenseService.findByDateBetween(start, end, page);
	}
}
