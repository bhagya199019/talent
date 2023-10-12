package com.example.demo.dto;

import com.example.demo.modal.ApplicantProfile;

//@Builder
public class UserDto {

    private Long id;
    private String name;
    private String email;
    private String mobilenumber;
    private String token;
    private String userType;
    private ApplicantProfile applicantProfile;
    
    
	public ApplicantProfile getApplicantProfile() {
		return applicantProfile;
	}
	public void setApplicantProfile(ApplicantProfile applicantProfile) {
		this.applicantProfile = applicantProfile;
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
		this.email = email;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public UserDto(Long id, String name, String email, String mobilenumber, String token,String userType,ApplicantProfile applicantProfile) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobilenumber = mobilenumber;
		this.token = token;
		this.userType=userType;
		this.applicantProfile=applicantProfile;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
    
  
}
