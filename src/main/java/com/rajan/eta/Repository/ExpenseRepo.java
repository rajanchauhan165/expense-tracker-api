package com.rajan.eta.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rajan.eta.Entities.Expense;

@Repository
public interface ExpenseRepo extends JpaRepository<Expense, Long>{

}
