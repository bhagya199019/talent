package com.example.demo.dto;

import com.example.demo.modal.ApplicantProfile;

import jakarta.validation.constraints.NotEmpty;



//@Builder
public class SignUpDto {

    @NotEmpty
    private String name;

    @NotEmpty
    private String email;

    @NotEmpty
    private String mobilenumber;

    @NotEmpty
    private char[] password;
    
    private ApplicantProfile applicantProfile;
    
    

	public ApplicantProfile getApplicantProfile() {
		return applicantProfile;
	}

	public void setApplicantProfile(ApplicantProfile applicantProfile) {
		this.applicantProfile = applicantProfile;
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

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

	public SignUpDto(@NotEmpty String name, @NotEmpty String email, @NotEmpty String mobilenumber,
			@NotEmpty char[] password,ApplicantProfile applicantProfile) {
		super();
		this.name = name;
		this.email = email;
		this.mobilenumber = mobilenumber;
		this.password = password;
		this.applicantProfile=applicantProfile;
	}

	public SignUpDto() {
		super();
		// TODO Auto-generated constructor stub
	}


}
