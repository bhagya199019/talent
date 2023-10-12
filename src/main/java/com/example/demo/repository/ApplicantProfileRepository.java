package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modal.ApplicantProfile;

public interface ApplicantProfileRepository extends JpaRepository<ApplicantProfile,Integer>{

}
