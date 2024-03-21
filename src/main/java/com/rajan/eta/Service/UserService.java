package com.rajan.eta.Service;

import java.util.List;

import com.rajan.eta.Entities.User;
import com.rajan.eta.Entities.UserModel;

public interface UserService {
	public User createUser(UserModel user);
	public User getUserById(Long userId);
	public User updateUser(Long userId, UserModel user);
	public String deleteUser(Long userId);
	public List<User> getAllUser();
	public User getLoggedInUser();
}
