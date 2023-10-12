package com.example.demo.service;

import java.nio.CharBuffer;
import java.util.List;
import java.util.Random;

import com.example.demo.exception.AppException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.example.demo.modal.*;
import com.example.demo.dto.CredentialsDto;
import com.example.demo.dto.SignUpDto;
import com.example.demo.dto.UserDto;
import com.example.demo.emailservice.EmailSenderService;
import com.example.demo.mapper.UserMapper;
import com.example.demo.modal.OtpAndEmail;
import com.example.demo.modal.User;
import com.example.demo.repository.ApplicantProfileRepository;
import com.example.demo.repository.OtpEmailRepository;
import com.example.demo.repository.UserRepository;
import org.apache.pdfbox.text.PDFTextStripper;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;



@Service
public class UserService {

    private final UserRepository userRepository;
    private final OtpEmailRepository otpRepository;
    private final EmailSenderService emailService;
    private final ApplicantProfileRepository applicantProfileRepo;
    private final PasswordEncoder passwordEncoder;

    private final UserMapper userMapper;

    
    @Autowired
    public UserService(UserRepository userRepository, OtpEmailRepository otpRepository, EmailSenderService emailService,
			ApplicantProfileRepository applicantProfileRepo, PasswordEncoder passwordEncoder, UserMapper userMapper) {
		super();
		this.userRepository = userRepository;
		this.otpRepository = otpRepository;
		this.emailService = emailService;
		this.applicantProfileRepo = applicantProfileRepo;
		this.passwordEncoder = passwordEncoder;
		this.userMapper = userMapper;
	}

	public ApplicantProfile UpdateApplicantProfile(ApplicantProfile profileUpdate) {
    	return applicantProfileRepo.save(profileUpdate);
    }
    
    public String resetPassword(User user) {
    	User user1=userRepository.save(user);
    	
    	if(user1!=null) {
    		return "Password reset was done successfully";
    	}
    	return "Password reset was failed";
    }
    public UserDto login(CredentialsDto credentialsDto) {
		
		System.out.println(credentialsDto.getEmail());
        User user = userRepository.findByEmail(credentialsDto.getEmail());
        
              //  .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));

        
        if (passwordEncoder.matches(CharBuffer.wrap(credentialsDto.getPassword()), user.getPassword())) {
            return userMapper.toUserDto(user);
        }
        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
    }
    
    public UserDto registerUser(SignUpDto userDto) throws MessagingException {
    	
    	emailService.sendEmail(userDto.getEmail(), "Account Register",
                "<h3>ThankYou for Choosing us</h3>"
                        + "<b><i>Your registration is Completed</i></b><br/><br/>UserName is : <b>"
                        + userDto.getEmail() + "</b><br/>Password : <b>" + userDto.getPassword() + "</b>");
    	
    	
    	User user = userMapper.signUpToUser(userDto);
    	
    	user.setPassword(passwordEncoder.encode(CharBuffer.wrap(userDto.getPassword())));
    	User savedUser = userRepository.save(user);
    	
    	return userMapper.toUserDto(savedUser);
    }
    public User upadateUser(User user) {
    	return userRepository.save(user);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public UserDto findByEmail1(String email) {
        //User user = userRepository.findByEmail(email);
                //.orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
        //return userMapper.toUserDto(user);
    	User user = userRepository.findByEmail(email);

        if (user!=null) {
            
            return userMapper.toUserDto(user);
        } else {
            // Handle the case where no user with the given email was found.
            // You can return null or an appropriate response.
        	throw new AppException("Unknown user", HttpStatus.NOT_FOUND);
            //return null;
        }
        
    }

   
    public boolean adminLogin(User user) {
        // Your admin login logic here
        return true;
    }

    public boolean verifyOTP(String email, String enteredOTP) {
    	List<OtpAndEmail> users = otpRepository.findByEmail(email);

        if (users.isEmpty()) {
            return false; // No OTP entries for this email
        }

        for (OtpAndEmail user : users) {
            if (user.getOtp() != null && user.getOtp().equals(enteredOTP)) {
                return true; // Found a matching OTP entry
            }
        }

        return false; // No matching OTP entry found
    }
    public void sendOTP(String email) throws MessagingException {
    	String otp = generateOTP();

        OtpAndEmail userOtp=new OtpAndEmail();
        userOtp.setEmail(email);
        userOtp.setOtp(otp);

        otpRepository.save(userOtp); // Save the new user entity to the database
        String to=email;
        String subject = "OTP for your verification";
        String body = "Please enter this OTP to verify: " + otp;
        emailService.sendEmail(to, subject, body); 
    }

    private String generateOTP() {
        // Generate a random 6-digit OTP
        Random random = new Random();
        int otpValue = 100000 + random.nextInt(900000);
        return String.valueOf(otpValue);
    }

   

    public String convertPdfToJson(MultipartFile pdfFile) {
        try {
            // Use Apache PDFBox to extract text content and convert to JSON
            PDDocument document = PDDocument.load(pdfFile.getInputStream());
            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(document);
            document.close();

            // Convert the text content to JSON format as needed

            return text;
        } catch (Exception e) {
            throw new RuntimeException("Error converting PDF to JSON.");
        }
    }

   
}


