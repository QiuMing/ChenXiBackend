package com.ming.chenxi.repository;

import com.ming.chenxi.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

	public List<User> findByUsername(String username);
	
}
