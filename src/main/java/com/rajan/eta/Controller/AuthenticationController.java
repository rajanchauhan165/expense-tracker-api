package com.rajan.eta.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.rajan.eta.Entities.User;
import com.rajan.eta.Entities.UserModel;
import com.rajan.eta.Service.UserService;

import jakarta.validation.Valid;

@RestController
public class AuthenticationController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public ResponseEntity<String> login(){
		return new ResponseEntity<String>("user logedin", HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/register")
	public ResponseEntity<User> addUser(@Valid @RequestBody UserModel user){
		return new ResponseEntity<>(userService.createUser(user),HttpStatus.CREATED);
	}
}
