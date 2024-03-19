package com.rajan.eta.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rajan.eta.Entities.User;
import com.rajan.eta.Entities.UserModel;
import com.rajan.eta.Service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable Long userId){
		return new ResponseEntity<User>(userService.getUserById(userId),HttpStatus.OK);
	}
	
	@PutMapping("/users/{userId}")
	public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody UserModel user){
		return new ResponseEntity<User>(userService.updateUser(userId, user),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/users/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable Long userId){
		return new ResponseEntity<String>(userService.deleteUser(userId),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers(){
		return new ResponseEntity<List<User>>(userService.getAllUser(),HttpStatus.OK);
	}
}
