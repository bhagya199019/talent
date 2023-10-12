package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modal.*;

public interface EmployerRepository extends JpaRepository<Employer, Integer>{

	Employer findByEmail(String email);
}
