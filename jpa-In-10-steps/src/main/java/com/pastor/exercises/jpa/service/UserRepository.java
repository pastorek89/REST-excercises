package com.pastor.exercises.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pastor.exercises.jpa.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
