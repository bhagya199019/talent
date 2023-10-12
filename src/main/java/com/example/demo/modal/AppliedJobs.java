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
public class AppliedJobs {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long application_id;

	    @ManyToOne
	    @JoinColumn(name = "user_id")
	    private User user;

	   
	    @ManyToOne
	    @JoinColumn(name = "job_id")
	    private Job job;

	    @CreationTimestamp
	    private Date application_date;

	    @Override
	    public String toString() {
	        return "AppliedJobs [application_id=" + application_id + ", user=" + user + ", application_date=" + application_date + "]";
	    }


		public Long getApplication_id() {
			return application_id;
		}

		public void setApplication_id(Long application_id) {
			this.application_id = application_id;
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

		public Date getApplication_date() {
			return application_date;
		}

		public void setApplication_date(Date application_date) {
			this.application_date = application_date;
		}

		public AppliedJobs(Long application_id, User user, Job job, Date application_date) {
			super();
			this.application_id = application_id;
			this.user = user;
			this.job = job;
			this.application_date = application_date;
		}

		public AppliedJobs() {
			super();
			// TODO Auto-generated constructor stub
		}

	    // Constructors, getters, setters
	    
	    
	    
}
