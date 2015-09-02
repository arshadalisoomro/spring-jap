package com.project.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.db.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
