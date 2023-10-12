package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modal.SavedJob;

public interface SavedJobsRepository extends JpaRepository<SavedJob,Long>{

}
