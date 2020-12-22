package com.workops.service;

import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.workops.Constants;
import com.workops.dao.UserDao;
import com.workops.exception.AuthException;
import com.workops.model.Logintype;
import com.workops.model.User;
import com.workops.pojo.JwtToken;
import com.workops.pojo.UserEmail;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userdao;
	
	@Override
	public JwtToken signin(User user) throws AuthException {

		try
		{
			String email=user.getEmail();
			System.out.println(user.getEmail()+" "+user.getPassword());
			User check=userdao.findByEmail(email);
			if(!BCrypt.checkpw(user.getPassword(),check.getPassword()))
			{
//				System.out.println("In 1");
				throw new AuthException("Invalid email/password");
			}
//			System.out.println("In 2");
			userdao.updateTokenByEmail(user.getEmail(), generateJwtToken(user).getToken());
			check.setToken(userdao.getTokenByEmail(user.getEmail()));
//			System.out.println("In 3 "+check.getToken());
			return new JwtToken(check.getToken());
		}
		catch(Exception e)
		{
			throw new AuthException("Invalid email/password");
		}
	}

	@Override
	public JwtToken signup(User user) throws AuthException {
		
		Pattern pattern=Pattern.compile("^(.+)@(.+)$");
		String email=user.getEmail();
		if(!pattern.matcher(email).matches())
		{
			throw new AuthException("Invalid Email");
		}
		User b=userdao.findByEmail(user.getEmail());
		if(b!=null) {throw new AuthException("User Already Exists");}
		else 
		{
		
			try
			{
				User u=new User();
				u.setEmail(user.getEmail());
				String hashedPassword=BCrypt.hashpw(user.getPassword(),BCrypt.gensalt(10));
				u.setPassword(hashedPassword);
				Logintype l1=new Logintype();
				l1.setType("normal");
				u.setLogintype(l1);
				u.setToken(generateJwtToken(u).getToken());
				userdao.save(u);
				return new JwtToken(u.getToken());
			}
			catch(Exception e)
			{
				throw new AuthException("InValidDetails.Failed To Create Account="+e.getMessage());
			}
		}
	}

	@Override
	public JwtToken generateJwtToken(User user) throws AuthException {
		long timestamp = System.currentTimeMillis();
        String token = Jwts.builder().signWith(SignatureAlgorithm.HS256, Constants.API_SECRET_KEY)
                .setIssuedAt(new Date(timestamp))
                .setExpiration(new Date(timestamp + Constants.TOKEN_VALIDITY))
                .claim("email",user.getEmail())
                .compact();
        JwtToken jwt=new JwtToken();
        jwt.setToken(token);
         return jwt;
	}

	@Override
	public UserEmail getUser(String token) {
		UserEmail ue=new UserEmail();
		System.out.println(token);
		ue.setEmail(userdao.getEmailByToken(token));
		System.out.println(ue.getEmail());
		return ue;
	}

	@Override
	public String changePassword(User user) throws AuthException {
		
		try {
			User b=userdao.findByEmail(user.getEmail());
			String hashedPassword=BCrypt.hashpw(user.getPassword(),BCrypt.gensalt(10));
//			System.out.println(hashedPassword+" "+b.getPassword());
//			if(hashedPassword.equals(b.getPassword())) {
////				System.out.println("same= "+hashedPassword);
//				return "New Password Can't be same as Old Password";				
//			}
//			System.out.println(user.getPassword()+" "+hashedPassword);
			b.setPassword(BCrypt.hashpw(user.getPassword(),BCrypt.gensalt(10)));
			userdao.save(b);
			return "Password Changed";	
		}
		catch(Exception e)
		{
			System.out.println("error= "+e);	
			throw new AuthException("InValidDetails.Failed To Create Account="+e.getMessage());
		}

	}

	@Override
	public boolean checkIfTokenExits(String token) {
		try
		{
			String check=userdao.getEmailByToken(token);
			if(check.length()>0)
			{
				return true;
			}
			return false;
		}
		catch(Exception e)
		{
			System.out.println("Exception in checktoken="+e.getMessage());
			return false;
		}
	}
}
