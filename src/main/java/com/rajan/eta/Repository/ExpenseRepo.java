package com.rajan.eta.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rajan.eta.Entities.Expense;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Repository
public interface ExpenseRepo extends JpaRepository<Expense, Long>{
	//select * from expense where category=?
	public Page<Expense> findByUserIdAndCategory(Long userId, String category, Pageable page);
	public Page<Expense> findByUserIdAndNameContaining(Long userId, String keyword, Pageable page);
	public Page<Expense> findByUserIdAndDateBetween(Long userId, LocalDate startDate, LocalDate endDate, Pageable page);
	public Page<Expense> findByUserId(Long id, Pageable page);
	public Optional<Expense> findByUserIdAndId(Long userId, Long expenseId); 
}
