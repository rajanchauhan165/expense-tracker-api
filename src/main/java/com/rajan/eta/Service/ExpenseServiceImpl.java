package com.rajan.eta.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.rajan.eta.Entities.Expense;
import com.rajan.eta.Exceptions.ExpenseException;
import com.rajan.eta.Repository.ExpenseRepo;
@Service
public class ExpenseServiceImpl implements ExpenseService{
	
	@Autowired
	private ExpenseRepo expenseRepo;
	
	@Override
	public Expense getExpenseById(Long id) throws ExpenseException {
		Optional<Expense> expense = expenseRepo.findById(id);
		if(expense.isPresent()) {
			return expense.get();
		}
		else {
			throw new ExpenseException("Expense not found with Id: "+id);
		}
		
//		expense.orElseThrow()
	}

	@Override
	public Page<Expense> getAllExpenses(Pageable page) {
		return expenseRepo.findAll(page);
	}

	@Override
	public Expense addExpense(Expense expense) {
		return expenseRepo.save(expense);
	}

	@Override
	public Expense updateExpense(Long expense_id, Expense expense) {
		Optional<Expense> existing = expenseRepo.findById(expense_id);
		if(existing.isPresent()) {
			Expense existingExpense = existing.get();
			existingExpense.setName(expense.getName()!= null?expense.getName():existingExpense.getName());
			existingExpense.setAmount(expense.getAmount()!=null?expense.getAmount():existingExpense.getAmount());
			existingExpense.setCategory(expense.getCategory()!=null?expense.getCategory():existingExpense.getCategory());
			existingExpense.setDescription(expense.getDescription()!=null?expense.getDescription():existingExpense.getDescription());
			existingExpense.setDate(expense.getDate()!=null?expense.getDate():existingExpense.getDate());
			return expenseRepo.save(existingExpense);
		}
		else {
			throw new ExpenseException("Expense not found with Id: "+expense_id);
		}
		
	}

	@Override
	public String deletExpense(Long id) throws ExpenseException {
		Optional<Expense> expense = expenseRepo.findById(id);
		if(expense.isPresent()) {
			expenseRepo.delete(expense.get());
			return "Expense with Id: "+id+" deleted successfully";
		}
		else {
			throw new ExpenseException("Expense not found with Id: "+id);
		}
	}

	@Override
	public List<Expense> findByCategory(String category, Pageable page) {
//		return expenseRepo.findByCategory(category, page).toList();
		Page<Expense> responsePage = expenseRepo.findByCategory(category, page);
		if(responsePage.isEmpty()) {
			throw new ExpenseException("Category '"+category+"' not found!");
		}
		else {
			return responsePage.toList();
		}
	}

	@Override
	public List<Expense> findByNameContaining(String keyword, Pageable page) {
		Page<Expense> responsePage = expenseRepo.findByNameContaining(keyword, page);
		if(responsePage.isEmpty()) {
			throw new ExpenseException("Name containing '"+keyword+"' not found!");
		}
		else {
			return responsePage.toList();
		}
	}

	@Override
	public List<Expense> findByDateBetween(LocalDate start, LocalDate end, Pageable page) {
		if(start.isBefore(end)) {
			return expenseRepo.findByDateBetween(start, end, page).toList();
		}
		else if (start.isAfter(end)) {
			throw new ExpenseException("Start date cannot be after end date!");
		}
		else {
			throw new ExpenseException("Please enter both start and end date!");
		}
	}
}
