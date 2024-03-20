package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User,Integer>{	
	@Query("select user from User user where user.email=?1 and user.password=?2")
	public User getUserForLogin(String email,String pass);
}
