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
			User check=userdao.findByEmail(email);
			if(!BCrypt.checkpw(user.getPassword(),check.getPassword()))
			{
				throw new AuthException("Invalid email/password");
			}
			userdao.updateTokenByEmail(user.getEmail(), generateJwtToken(user).getToken());
			check.setToken(userdao.getTokenByEmail(user.getEmail()));
			return new JwtToken(check.getToken());
		}
		catch(Exception e)
		{
			throw new AuthException("Invalid email/password="+e.getMessage());
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
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userdao.findAll();
	}

}
