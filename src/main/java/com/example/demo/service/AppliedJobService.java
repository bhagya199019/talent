package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.modal.AppliedJobs;
import com.example.demo.modal.Job;
import com.example.demo.repository.AppliedJobsRepository;

@Service
public class AppliedJobService {

	@Autowired
	private final AppliedJobsRepository appliedJobRepository;

	public AppliedJobService(AppliedJobsRepository appliedJobRepository) {
		super();
		this.appliedJobRepository = appliedJobRepository;
	}
	
	public ResponseEntity<String> applyforJob(AppliedJobs appliedjobs) {
		AppliedJobs appliedjob= appliedJobRepository.save(appliedjobs);
		if(appliedjob != null) {
			return ResponseEntity.ok("applied successfully");
		}else {
			return (ResponseEntity<String>) ResponseEntity.badRequest();
		}
	}

public List<Job> findByUserId1(Long userId) {
		
        // Call the repository method to fetch applied jobs by user ID
		 List<AppliedJobs> appliedJobs= appliedJobRepository.findByUserId(userId);
        
     // Extract Job objects from the applied jobs
        List<Job> jobs = new ArrayList<>();
        for (AppliedJobs appliedJob : appliedJobs) {
            Job job = appliedJob.getJob();
            if (job != null) {
                jobs.add(job);
            }
        }
        return jobs;
    }
}
