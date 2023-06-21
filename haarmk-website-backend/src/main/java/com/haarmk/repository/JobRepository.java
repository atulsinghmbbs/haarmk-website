package com.haarmk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haarmk.model.Job;

public interface JobRepository extends JpaRepository<Job, Integer> {

}
