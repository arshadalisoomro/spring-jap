package com.project.db.service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.db.entity.User;
import com.project.db.repository.UserRepository;

@Transactional
@Service
public class InitDbService {
	
	@Autowired
	private UserRepository  userRepository;
	
	@PostConstruct
	public void init() {
		User user = new User();
		user.setName("Ali");
		userRepository.save(user);
		
	}
}
