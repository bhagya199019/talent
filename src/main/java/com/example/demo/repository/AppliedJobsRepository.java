package com.example.demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modal.AppliedJobs;

public interface AppliedJobsRepository extends JpaRepository<AppliedJobs,Long>{

	List<AppliedJobs> findByUserId(Long userId);
}
