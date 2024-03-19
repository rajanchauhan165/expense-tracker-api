package com.rajan.eta.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rajan.eta.Entities.User;
@Repository
public interface UserRepo extends JpaRepository<User, Long>{
	Boolean existsByEmail(String email);
}
