package com.rajan.eta.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rajan.eta.Entities.Expense;
import com.rajan.eta.Repository.ExpenseRepo;
@Service
public class ExpenseServiceImpl implements ExpenseService{
	
	@Autowired
	private ExpenseRepo expenseRepo;

	@Override
	public List<Expense> getAllExpenses() {
		return expenseRepo.findAll();
	}

	@Override
	public Expense addExpense(Expense expense) {
		return expenseRepo.save(expense);
	}

	@Override
	public Expense updateExpense(Long expense_id, Expense expense) {
		Expense existingExpense = expenseRepo.findById(expense_id).get();
		existingExpense.setExpense_name(expense.getExpense_name()!= null?expense.getExpense_name():existingExpense.getExpense_name());
		existingExpense.setAmount(expense.getAmount()!=null?expense.getAmount():existingExpense.getAmount());
		existingExpense.setCategory(expense.getCategory()!=null?expense.getCategory():existingExpense.getCategory());
		existingExpense.setDescription(expense.getDescription()!=null?expense.getDescription():existingExpense.getDescription());
		existingExpense.setDate(expense.getDate()!=null?expense.getDate():existingExpense.getDate());
		return expenseRepo.save(existingExpense);
	}

}
