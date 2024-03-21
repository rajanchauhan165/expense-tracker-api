package com.rajan.eta.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rajan.eta.Entities.LoginModel;
import com.rajan.eta.Entities.User;
import com.rajan.eta.Entities.UserModel;
import com.rajan.eta.Service.UserService;

import jakarta.validation.Valid;

@RestController
public class AuthenticationController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/login")
	public ResponseEntity<HttpStatus> login(@RequestBody LoginModel loginModel){
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginModel.getEmail(), loginModel.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<User> addUser(@Valid @RequestBody UserModel user){
		return new ResponseEntity<>(userService.createUser(user),HttpStatus.CREATED);
	}
}
