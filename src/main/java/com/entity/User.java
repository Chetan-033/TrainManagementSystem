package com.entity;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String email;
	private String password;
	private long contact;
	private String gender;
	private String dob;
	private String role;
	private String date;
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String name, String email, String password, long contact, String gender, String dob) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.contact = contact;
		this.gender = gender;
		this.dob = dob;
		this.role = "User";
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy/mm/dd hh:mm:ss");
		LocalDateTime now=LocalDateTime.now();
		this.date = dtf.format(now);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", emial=" + email + ", contact=" + contact + ", gender=" + gender
				+ ", dob=" + dob + "]";
	}
}
