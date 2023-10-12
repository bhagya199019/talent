package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modal.Job;

public interface JobRepository extends JpaRepository<Job, Long> {
}

