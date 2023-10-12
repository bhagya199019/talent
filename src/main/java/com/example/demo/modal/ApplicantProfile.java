package com.example.demo.modal;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class ApplicantProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int applicantid;

    @Embedded
    private BasicDetails basicDetails;

    @Embedded
    private XClassDetails xClassDetails;

    @Embedded
    private IntermediateDetails intermediateDetails;

    @Embedded
    private GraduationDetails graduationDetails;

    @ElementCollection
    private List<String> skills;

    @ElementCollection
    private List<ExperienceDetails> experienceDetails;
    
    @OneToOne
    private User user;
    
    
    

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getApplicantid() {
		return applicantid;
	}

	public void setApplicantid(int applicantid) {
		this.applicantid = applicantid;
	}

	public BasicDetails getBasicDetails() {
		return basicDetails;
	}

	public void setBasicDetails(BasicDetails basicDetails) {
		this.basicDetails = basicDetails;
	}

	public XClassDetails getxClassDetails() {
		return xClassDetails;
	}

	public void setxClassDetails(XClassDetails xClassDetails) {
		this.xClassDetails = xClassDetails;
	}

	public IntermediateDetails getIntermediateDetails() {
		return intermediateDetails;
	}

	public void setIntermediateDetails(IntermediateDetails intermediateDetails) {
		this.intermediateDetails = intermediateDetails;
	}

	public GraduationDetails getGraduationDetails() {
		return graduationDetails;
	}

	public void setGraduationDetails(GraduationDetails graduationDetails) {
		this.graduationDetails = graduationDetails;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public List<ExperienceDetails> getExperienceDetails() {
		return experienceDetails;
	}

	public void setExperienceDetails(List<ExperienceDetails> experienceDetails) {
		this.experienceDetails = experienceDetails;
	}

    ///private byte[] resume;
    
    
}
