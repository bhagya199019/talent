package com.example.demo.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int recuterid;
	private int companyid;
	private String companyname;
	private String typeofcompany;
	private String yourRole;
	private String employeeCount;
	private String email;
	private String password;
	private long mobilenumber;
	private String userType="employer";
	private String token;
	
	
	
	public String getUserType() {
		return userType;
	}



	public void setUserType(String userType) {
		this.userType = "employer";
	}



	public Employer() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Employer(int companyid, String companyname, String typeofcompany, String yourRole, String employeeCount,
			String email, String password, long mobilenumber,String token,String userType) {
		super();
		this.companyid = companyid;
		this.companyname = companyname;
		this.typeofcompany = typeofcompany;
		this.yourRole = yourRole;
		this.employeeCount = employeeCount;
		this.email = email;
		this.password = password;
		this.mobilenumber = mobilenumber;
		this.token=token;
		this.userType=userType;
	}



	public String getToken() {
		return token;
	}



	public void setToken(String token) {
		this.token = token;
	}



	public int getRecuterid() {
		return recuterid;
	}



	public void setRecuterid(int recuterid) {
		this.recuterid = recuterid;
	}



	public int getCompanyid() {
		return companyid;
	}



	public void setCompanyid(int companyid) {
		this.companyid = companyid;
	}



	public String getCompanyname() {
		return companyname;
	}



	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}



	public String getTypeofcompany() {
		return typeofcompany;
	}



	public void setTypeofcompany(String typeofcompany) {
		this.typeofcompany = typeofcompany;
	}



	public String getYourRole() {
		return yourRole;
	}



	public void setYourRole(String yourRole) {
		this.yourRole = yourRole;
	}



	public String getEmployeeCount() {
		return employeeCount;
	}



	public void setEmployeeCount(String employeeCount) {
		this.employeeCount = employeeCount;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public long getMobilenumber() {
		return mobilenumber;
	}



	public void setMobilenumber(long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	
	
}
