package com.rajan.eta.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rajan.eta.Entities.Expense;
import java.time.LocalDate;

@Repository
public interface ExpenseRepo extends JpaRepository<Expense, Long>{
	//select * from expense where category=?
	public Page<Expense> findByCategory(String category, Pageable page);
	public Page<Expense> findByNameContaining(String keyword, Pageable page);
	public Page<Expense> findByDateBetween(LocalDate startDate, LocalDate endDate, Pageable page);
}
