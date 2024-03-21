package com.rajan.eta.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.rajan.eta.Entities.User;
import com.rajan.eta.Entities.UserModel;
import com.rajan.eta.Service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/user")
	public ResponseEntity<User> getUserById(){
		return new ResponseEntity<User>(userService.readUser(),HttpStatus.OK);
	}
	
	@PutMapping("/user")
	public ResponseEntity<User> updateUser(@RequestBody UserModel user){
		return new ResponseEntity<User>(userService.updateUser(user),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/user")
	public ResponseEntity<String> deleteUser(){
		return new ResponseEntity<String>(userService.deleteUser(),HttpStatus.ACCEPTED);
	}
}
