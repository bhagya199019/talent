package com.example.demo.service;

import java.nio.CharBuffer;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.emailservice.EmailSenderService;
import com.example.demo.modal.Employer;
import com.example.demo.modal.OtpAndEmail;
import com.example.demo.modal.User;
import com.example.demo.repository.EmployerRepository;
import com.example.demo.repository.OtpEmailRepository;

import jakarta.mail.MessagingException;

@Service
public class EmployerService {

	@Autowired
	private EmployerRepository employerRepository;
	@Autowired
	private EmailSenderService emailService;
	@Autowired
	private final OtpEmailRepository otpRepository = null;
	@Autowired
	private final PasswordEncoder passwordEncoder=null;
	
	public Employer getEmployerByEmail(String email) {
		
		return this.employerRepository.findByEmail(email);
		
	}


	 public Employer registerEmployer(Employer employer) throws MessagingException {
    	
    	
		emailService.sendEmail(employer.getEmail(), "Account Register",
                "<h3>ThankYou for Choosing us</h3>"
                        + "<b><i>Your registration is Completed</i></b><br/><br/>UserName is : <b>"
                        + employer.getEmail() + "</b><br/>Password : <b>" + employer.getPassword() + "</b>");
        employer.setPassword(passwordEncoder.encode(CharBuffer.wrap(employer.getPassword())));
		return employerRepository.save(employer);
    }
	 
	 public void sendOTP1(String email) throws MessagingException {
	    	String otp = generateOTP1();

	        OtpAndEmail userOtp=new OtpAndEmail();
	        userOtp.setEmail(email);
	        userOtp.setOtp(otp);

	        otpRepository.save(userOtp); // Save the new user entity to the database
	        String to=email;
	        String subject = "OTP for your verification";
	        String body = "Please enter this OTP to verify: " + otp;
	        emailService.sendEmail(to, subject, body); 
	    }

	    private String generateOTP1() {
	        // Generate a random 6-digit OTP
	        Random random = new Random();
	        int otpValue = 100000 + random.nextInt(900000);
	        return String.valueOf(otpValue);
	    }
	    
	    public String resetPassword1(Employer employer) {
	    	Employer employer1=employerRepository.save(employer);
	    	
	    	if(employer1!=null) {
	    		return "Password reset was done successfully";
	    	}
	    	return "Password reset was failed";
	    }
}
