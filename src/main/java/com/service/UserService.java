package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.User;
import com.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository repository;
	public User getUserForLogin(String email,String password)
	{
		return repository.getUserForLogin(email,password);
	}
	public User getUserById(int id)
	{
		return repository.getById(id);
	}
	public void addNewUser(User user)
	{
		repository.save(user);
	}
}
