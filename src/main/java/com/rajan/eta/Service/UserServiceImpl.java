package com.rajan.eta.Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.rajan.eta.Entities.User;
import com.rajan.eta.Entities.UserModel;
import com.rajan.eta.Exceptions.ItemAlreadyExistException;
import com.rajan.eta.Exceptions.UserException;
import com.rajan.eta.Repository.UserRepo;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public User createUser(UserModel user) {
		if(userRepo.existsByEmail(user.getEmail())) {
			throw new ItemAlreadyExistException("Email Already Exists!");
		}
		else {
			User newUser = new User();
			BeanUtils.copyProperties(user, newUser);
			newUser.setPassword(passwordEncoder.encode(user.getPassword()));
			return userRepo.save(newUser);
		}
	}

	@Override
	public User readUser() {
		return userRepo.findById(getLoggedInUser().getId()).orElseThrow(() -> new UserException("User not found with Id: "+getLoggedInUser().getId()));
	}

	@Override
	public User updateUser(UserModel user) {
		User existingUser = readUser();
		existingUser.setName(user.getName()!=null?user.getName():existingUser.getName());
		existingUser.setEmail(user.getEmail()!=null?user.getEmail():existingUser.getEmail());
		existingUser.setPassword(user.getPassword()!=null?user.getPassword():existingUser.getPassword());
		existingUser.setAge(user.getAge()!=null?user.getAge():existingUser.getAge());
		return userRepo.save(existingUser);
	}

	@Override
	public String deleteUser() {
		User existingUser = readUser();
		userRepo.delete(existingUser);
		return "User with Id: "+existingUser.getId()+" deleted successfully!";
	}


	@Override
	public User getLoggedInUser() {
		Authentication authz = SecurityContextHolder.getContext().getAuthentication();
		String email = authz.getName();
		return userRepo.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("User not found with Id: "+email));
	}

}
