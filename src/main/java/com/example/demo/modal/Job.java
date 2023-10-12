package com.example.demo.modal;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import jakarta.persistence.OneToMany;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String company;
    private String location;
    private String salary;
    private String experience;
    private String datePosted;
    
    public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	@ElementCollection
    @CollectionTable(name = "job_skills", joinColumns = @JoinColumn(name = "job_id"))
    @Column(name = "skill")
    private List<String> skills;
    
    
    @JsonIgnore
    @OneToMany(mappedBy = "job")
    private Set<AppliedJobs> appliedJobs = new HashSet<>();
    @JsonIgnore
    @OneToMany(mappedBy = "job")
    private Set<SavedJob> savedJobs = new HashSet<>();
    
    
    
	public Set<AppliedJobs> getAppliedJobs() {
		return appliedJobs;
	}
	public void setAppliedJobs(Set<AppliedJobs> appliedJobs) {
		this.appliedJobs = appliedJobs;
	}
	public Set<SavedJob> getSavedJobs() {
		return savedJobs;
	}
	public void setSavedJobs(Set<SavedJob> savedJobs) {
		this.savedJobs = savedJobs;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getDatePosted() {
		return datePosted;
	}
	public void setDatePosted(String datePosted) {
		this.datePosted = datePosted;
	}
	
	public Job(Long id, String title, String company, String location, String salary, String experience,
			String datePosted, Set<AppliedJobs> appliedJobs, Set<SavedJob> savedJobs,List<String> skills) {
		super();
		this.id = id;
		this.title = title;
		this.company = company;
		this.location = location;
		this.salary = salary;
		this.experience = experience;
		this.datePosted = datePosted;
		this.appliedJobs = appliedJobs;
		this.savedJobs = savedJobs;
		this.skills=skills;
	}
	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
    // getters and setters
    
    
}
