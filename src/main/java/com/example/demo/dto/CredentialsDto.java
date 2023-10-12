package com.example.demo.dto;


//@Builder
public class CredentialsDto {

    private String email;
    private char[] password;
    
    
	public CredentialsDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CredentialsDto(String email, char[] password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public char[] getPassword() {
		return password;
	}
	public void setPassword(char[] password) {
		this.password = password;
	}

    
}