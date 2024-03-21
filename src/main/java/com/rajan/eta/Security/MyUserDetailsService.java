package com.rajan.eta.Security;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.rajan.eta.Entities.User;
import com.rajan.eta.Exceptions.UserException;
import com.rajan.eta.Repository.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService{
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> optional = userRepo.findByEmail(username);
		if(optional.isEmpty()) {
			throw new UsernameNotFoundException("User not found with email: "+username);
		}else {
			User retUser= optional.get();
			return new org.springframework.security.core.userdetails.User(retUser.getEmail(), retUser.getPassword(), new ArrayList<>());
		}
	}

}
