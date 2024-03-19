package com.rajan.eta.Service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rajan.eta.Entities.User;
import com.rajan.eta.Entities.UserModel;
import com.rajan.eta.Exceptions.ItemAlreadyExistException;
import com.rajan.eta.Exceptions.UserException;
import com.rajan.eta.Repository.UserRepo;
@Service
public class UserServiceImpl implements UserService{
	
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
			return userRepo.save(newUser);
		}

	}

	@Override
	public User getUserById(Long userId) {
		return userRepo.findById(userId).orElseThrow(() -> new UserException("User not found with Id: "+userId));
	}

	@Override
	public User updateUser(Long userId, UserModel user) {
		User existingUser = getUserById(userId);
		existingUser.setName(user.getName()!=null?user.getName():existingUser.getName());
		existingUser.setEmail(user.getEmail()!=null?user.getEmail():existingUser.getEmail());
		existingUser.setPassword(user.getPassword()!=null?user.getPassword():existingUser.getPassword());
		existingUser.setAge(user.getAge()!=null?user.getAge():existingUser.getAge());
		return userRepo.save(existingUser);
	}

	@Override
	public String deleteUser(Long userId) {
		User existingUser = getUserById(userId);
		userRepo.delete(existingUser);
		return "User with Id: "+userId+" deleted successfully!";
	}

	@Override
	public List<User> getAllUser() {
		return userRepo.findAll();
	}

}
