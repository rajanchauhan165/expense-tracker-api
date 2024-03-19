package com.rajan.eta.Entities;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserModel {
	@NotBlank(message = "Name must not be blank!")
	@Size(min = 3, message = "Please enter a valid name!")
	private String name;
	@NotNull(message = "Email must not be blank!")
	@Email(message = "Please enter a valid email!")
	private String email;
	@Size(min = 5, max = 64, message = "Password should be of minimum 5 characters!")
	@NotBlank(message = "Password must not be blank!")
	private String password;
	@NotNull(message = "Password must not be blank!")
	private Long age;
	
	//getterSetter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getAge() {
		return age;
	}
	public void setAge(Long age) {
		this.age = age;
	}
}
