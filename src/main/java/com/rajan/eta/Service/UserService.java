package com.rajan.eta.Service;
import com.rajan.eta.Entities.User;
import com.rajan.eta.Entities.UserModel;

public interface UserService {
	public User createUser(UserModel user);
	public User readUser();
	public User updateUser(UserModel user);
	public String deleteUser();
	public User getLoggedInUser();
}
