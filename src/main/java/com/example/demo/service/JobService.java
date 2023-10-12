package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modal.ApplicantProfile;
import com.example.demo.modal.AppliedJobs;
import com.example.demo.modal.Job;
import com.example.demo.modal.User;
import com.example.demo.repository.AppliedJobsRepository;
import com.example.demo.repository.JobRepository;
import com.example.demo.repository.UserRepository;

@Service
public class JobService {
	
	@Autowired
	private JobRepository jobRepository;
	@Autowired
	private AppliedJobsRepository appliedJobsRepository;
	@Autowired
	private UserRepository userRepository;

	public List<Job> getAll(Long id) {
		// TODO Auto-generated method stub
		List<Job> allJobs=jobRepository.findAll();
		User user=userRepository.getById(id);
		ApplicantProfile applicantProfile = user.getApplicantProfile();
		List<String> userSkills = applicantProfile.getSkills();
		List<Job> matchingJobs = new ArrayList<>();

        // Iterate through all jobs
        for (Job job : allJobs) {
            // Compare the skills required for the job with the user's skills
            // Assuming the skills are stored as a list of strings in the Job entity
            List<String> jobSkills = job.getSkills(); // Replace with the actual field name for skills
            if (userSkills.containsAll(jobSkills)) {
                matchingJobs.add(job);
            }
        }

        return matchingJobs;
	}

	private List<String> getUserSkills(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Job getJobById(Long id) {
		// TODO Auto-generated method stub
		return jobRepository.findById(id).orElse(null);
	}
	
	

}
