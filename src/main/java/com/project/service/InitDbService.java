package com.project.service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.project.entity.User;
import com.project.repository.UserRepository;

@Transactional
@Service
public class InitDbService {
	
	@Resource
	private UserRepository  userRepository;
	
	@PostConstruct
	public void init() {
		User user = new User();
		user.setName("Ali");
		userRepository.save(user);
		
	}
}
