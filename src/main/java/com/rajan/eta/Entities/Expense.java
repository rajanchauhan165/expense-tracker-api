package com.rajan.eta.Entities;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Expense {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long expense_id;
	private String expense_name;
	private String description;
	private BigDecimal amount;
	private String category;
	private LocalDate date;
	@Column(nullable = false, updatable = false)
	@CreationTimestamp
	private Timestamp created_at;
	@UpdateTimestamp
	private Timestamp updated_at;
	
	
	//getterSetters
	public Long getExpense_id() {
		return expense_id;
	}
	public void setExpense_id(Long expense_id) {
		this.expense_id = expense_id;
	}
	public String getExpense_name() {
		return expense_name;
	}
	public void setExpense_name(String expense_name) {
		this.expense_name = expense_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Timestamp getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	public Timestamp getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}
}
