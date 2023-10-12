package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modal.OtpAndEmail;
import com.example.demo.modal.User;



public interface OtpEmailRepository extends JpaRepository<OtpAndEmail, Long> {

	List<OtpAndEmail> findByEmail(String email);
}
