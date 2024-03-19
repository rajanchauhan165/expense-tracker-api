package com.rajan.eta.Repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rajan.eta.Entities.User;
@Repository
public interface UserRepo extends JpaRepository<User, Long>{
	public Optional<User> findByEmail(String email);
	public Boolean existsByEmail(String email);
}
