package com.rajan.eta.Entities;
import java.sql.Timestamp;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "Name must not be blank!")
	@Size(min = 3, message = "Please enter a valid name!")
	private String name;
	@Column(unique = true)
	@Email(message = "Please enter a valid email!")
	private String email;
	@Size(min = 5, max = 64, message = "Password should be of minimum 5 characters!")
	@NotBlank
	private String password;
	@NotNull
	private Long age;
	@Column(nullable = false, updatable = false)
	@CreationTimestamp
	private Timestamp createdAt;
	@UpdateTimestamp
	private Timestamp updatedAt;
}
