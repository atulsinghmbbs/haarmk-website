package com.haarmk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haarmk.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
