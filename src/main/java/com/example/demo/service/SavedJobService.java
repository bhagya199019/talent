package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.modal.SavedJob;
import com.example.demo.repository.SavedJobsRepository;

@Service
public class SavedJobService {
	@Autowired
	private final SavedJobsRepository savedJobRepository;

	public SavedJobService(SavedJobsRepository savedJobRepository) {
		super();
		this.savedJobRepository = savedJobRepository;
	}
	
	
	
	
	public ResponseEntity<String> saveAJob(SavedJob savedjob) {
		SavedJob savedjob1= savedJobRepository.save(savedjob);
		if(savedjob != null) {
			return ResponseEntity.ok("applied successfully");
		}else {
			return (ResponseEntity<String>) ResponseEntity.badRequest();
		}
	}
	

}
