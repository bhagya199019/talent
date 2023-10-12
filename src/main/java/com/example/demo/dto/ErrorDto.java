package com.example.demo.dto;





//@Builder
public class ErrorDto {

	private String message;
    public ErrorDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ErrorDto(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
