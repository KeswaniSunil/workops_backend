package com.workops.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.workops.dao.UserOtpDao;
import com.workops.exception.ErrorDetails;
import com.workops.model.UserOtp;
import com.workops.pojo.Otp;


@Service
@Transactional
public class UserOtpServiceImpl implements UserOtpService{

	@Autowired
	UserOtpDao userOtpDao;
	
	@Autowired
	private JavaMailSender emailSender;
	
	@Autowired
    private Environment env;
	
	@Override
	public Otp generate(UserOtp userOtp) throws Exception{
		try {
			LocalDateTime now = LocalDateTime.now();  
			Random rnd = new Random();
			int otp = 100000 + rnd.nextInt(900000);
			userOtp.setOtp(otp);
			userOtp.setOtpTime(now.plusHours(6));
			userOtpDao.save(userOtp);
			Otp myotp=new Otp();
			myotp.setOtp(otp);
//			System.out.println("Sending Mail to "+userOtp.getEmail());
			SimpleMailMessage message = new SimpleMailMessage(); 
	        message.setFrom(env.getProperty("spring.mail.username"));
	        message.setTo(userOtp.getEmail()); 
	        message.setSubject("OTP for Changing Password"); 
	        message.setText("Hello User, your otp is "+otp);
//			System.out.println("Called");
	        emailSender.send(message);
//			System.out.println("Called 2");
			return myotp;
		}
		catch(Exception e)
		{			
//			System.out.println("Called 3 "+e);
			throw new ErrorDetails(e.getMessage());
		}
	}

	@Override
	public String checkOtp(String email) throws Exception{
		try {
			UserOtp p=userOtpDao.findByEmail(email).orElse(null);
			if(p==null)
			{
				throw  new ErrorDetails("Not Found User OTP With Given Email");
			}
			if(p.getOtpTime().isBefore(LocalDateTime.now())) {
				throw  new ErrorDetails("OTP Invalid Or expired");
			}
			return new String("Correct OTP");
		}
		catch(Exception e)
		{
			throw new ErrorDetails(e.getMessage());
		}
	}
	
}
