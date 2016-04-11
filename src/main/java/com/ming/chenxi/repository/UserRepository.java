package com.ming.chenxi.repository;

import com.ming.chenxi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

	public User findByPhone(String username);
	
}
