package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modal.AppliedJobs;
import com.example.demo.modal.Job;
import com.example.demo.modal.SavedJob;
import com.example.demo.repository.JobRepository;
import com.example.demo.service.AppliedJobService;
import com.example.demo.service.JobService;
import com.example.demo.service.SavedJobService;

import java.util.List;

@RestController
public class JobController {
    @Autowired
    private final JobService jobService;
    
    @Autowired
    private final AppliedJobService appliedJobService;
    @Autowired
    private final SavedJobService savedJobService;
    

	public JobController(JobService jobService, AppliedJobService appliedJobService, SavedJobService savedJobService) {
		super();
		this.jobService = jobService;
		this.appliedJobService = appliedJobService;
		this.savedJobService = savedJobService;
	}

	@GetMapping("/getAllJobs/{id}")
    public List<Job> getAllJobs(@PathVariable Long id) {
        return jobService.getAll(id);
    }
	
	
	@PostMapping("/applyForJob")
	public ResponseEntity<String> applyJob(@RequestBody AppliedJobs appliedJob){
		System.out.println(appliedJob.getJob());
		return appliedJobService.applyforJob(appliedJob);
	}
	
	@PostMapping("/saveJob")
	public ResponseEntity<String> SaveJob(@RequestBody SavedJob savedJob){
		System.out.println(savedJob.getJob());
		return savedJobService.saveAJob(savedJob);
	}
    @GetMapping("/getJobId/{id}")
    public Job getJobById(@PathVariable Long id) {
        return jobService.getJobById(id);
    }
    
    @GetMapping("/getAppliedJobs/{userId}")
    public ResponseEntity<List<Job>> getAppliedJobs(@PathVariable Long userId) {
        List<Job> Jobs = appliedJobService.findByUserId1(userId);
        for(Job o: Jobs) {
        	 System.out.println(o);
        }
        return ResponseEntity.ok(Jobs);
    }
}

