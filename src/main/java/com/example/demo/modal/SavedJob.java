package com.example.demo.modal;





import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class SavedJob {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long saved_job_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

   
    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    @CreationTimestamp
    private Date save_date;

	@Override
	public String toString() {
		return "SavedJob [saved_job_id=" + saved_job_id + ", user=" + user + ", job=" + job + ", save_date=" + save_date
				+ "]";
	}

	public Long getSaved_job_id() {
		return saved_job_id;
	}

	public void setSaved_job_id(Long saved_job_id) {
		this.saved_job_id = saved_job_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Date getSave_date() {
		return save_date;
	}

	public void setSave_date(Date save_date) {
		this.save_date = save_date;
	}

	public SavedJob(Long saved_job_id, User user, Job job, Date save_date) {
		super();
		this.saved_job_id = saved_job_id;
		this.user = user;
		this.job = job;
		this.save_date = save_date;
	}

	public SavedJob() {
		super();
		// TODO Auto-generated constructor stub
	}

    // Constructors, getters, setters
    
    
    
    
}
