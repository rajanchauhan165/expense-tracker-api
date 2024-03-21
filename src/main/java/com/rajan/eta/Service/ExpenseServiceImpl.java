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
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	private UserService userService;

	@Autowired
	private ExpenseRepo expenseRepo;

	@Override
	public Expense getExpenseById(Long id) throws ExpenseException {
		Optional<Expense> optional = expenseRepo.findByUserIdAndId(userService.getLoggedInUser().getId(), id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new ExpenseException("Expense not found with Id: " + id);
		}
	}

	@Override
	public Page<Expense> getAllExpenses(Pageable page) {
		return expenseRepo.findByUserId(userService.getLoggedInUser().getId(), page);
	}

	@Override
	public Expense addExpense(Expense expense) {
		expense.setUser(userService.getLoggedInUser());
		return expenseRepo.save(expense);
	}

	@Override
	public Expense updateExpense(Long expense_id, Expense expense) {
		Expense existingExpense = getExpenseById(expense_id);
		existingExpense.setName(expense.getName()!= null?expense.getName():existingExpense.getName());
		existingExpense.setAmount(expense.getAmount()!=null?expense.getAmount():existingExpense.getAmount());
		existingExpense.setCategory(expense.getCategory()!=null?expense.getCategory():existingExpense.getCategory());
		existingExpense.setDescription(expense.getDescription()!=null?expense.getDescription():existingExpense.getDescription());
		existingExpense.setDate(expense.getDate()!=null?expense.getDate():existingExpense.getDate());
		return expenseRepo.save(existingExpense);
	}

	@Override
	public String deletExpense(Long id) throws ExpenseException {
		Expense expense = getExpenseById(id);
		expenseRepo.delete(expense);
		return "Expense with Id: " + id + " deleted successfully";
	}

	@Override
	public List<Expense> findByCategory(String category, Pageable page) {

		Page<Expense> responsePage = expenseRepo.findByUserIdAndCategory(userService.getLoggedInUser().getId(),category, page);
		if (responsePage.isEmpty()) {
			throw new ExpenseException("Category '" + category + "' not found!");
		} else {
			return responsePage.toList();
		}
	}

	@Override
	public List<Expense> findByNameContaining(String keyword, Pageable page) {
		Page<Expense> responsePage = expenseRepo.findByUserIdAndNameContaining(userService.getLoggedInUser().getId(),keyword, page);
		if (responsePage.isEmpty()) {
			throw new ExpenseException("Name containing '" + keyword + "' not found!");
		} else {
			return responsePage.toList();
		}
	}

	@Override
	public List<Expense> findByDateBetween(LocalDate start, LocalDate end, Pageable page) {
		if (start.isBefore(end)) {
			return expenseRepo.findByUserIdAndDateBetween(userService.getLoggedInUser().getId(),start, end, page).toList();
		} else if (start.isAfter(end)) {
			throw new ExpenseException("Start date cannot be after end date!");
		} else {
			throw new ExpenseException("Please enter both start and end date!");
		}
	}
}
