package com.example.demo.modal;
import jakarta.persistence.CascadeType;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String userType="jobseeker";
    
    @Column(unique = true)
    private String email;
    private String mobilenumber;
    
    @OneToOne(mappedBy="user")
    @JsonIgnore
    @JoinColumn
    private ApplicantProfile applicantProfile;
    
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<AppliedJobs> appliedJobs = new HashSet<>();

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<SavedJob> savedJobs = new HashSet<>();
    
    
    
	public ApplicantProfile getApplicantProfile() {
		return applicantProfile;
	}

	public void setApplicantProfile(ApplicantProfile applicantProfile) {
		this.applicantProfile = applicantProfile;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = "jobseeker";
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	private String password;
	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public User(Long id, String name, String userType, String email, String mobilenumber,
			ApplicantProfile applicantProfile, Set<AppliedJobs> appliedJobs, Set<SavedJob> savedJobs, String password) {
		super();
		this.id = id;
		this.name = name;
		this.userType = userType;
		this.email = email;
		this.mobilenumber = mobilenumber;
		this.applicantProfile = applicantProfile;
		this.appliedJobs = appliedJobs;
		this.savedJobs = savedJobs;
		this.password = password;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		//BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", userType=" + userType + ", email=" + email + ", mobilenumber="
				+ mobilenumber + ", applicantProfile=" + applicantProfile + ", password=" + password + "]";
	}
	
}

