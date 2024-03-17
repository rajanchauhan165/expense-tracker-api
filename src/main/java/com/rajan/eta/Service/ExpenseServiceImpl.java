package com.rajan.eta.Service;
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
		Expense existingExpense = expenseRepo.findById(expense_id).get();
		existingExpense.setName(expense.getName()!= null?expense.getName():existingExpense.getName());
		existingExpense.setAmount(expense.getAmount()!=null?expense.getAmount():existingExpense.getAmount());
		existingExpense.setCategory(expense.getCategory()!=null?expense.getCategory():existingExpense.getCategory());
		existingExpense.setDescription(expense.getDescription()!=null?expense.getDescription():existingExpense.getDescription());
		existingExpense.setDate(expense.getDate()!=null?expense.getDate():existingExpense.getDate());
		return expenseRepo.save(existingExpense);
	}
}
