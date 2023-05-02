package com.helpDeskPortal.HDP.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.helpDeskPortal.HDP.Service.UserService;
import com.helpDeskPortal.HDP.entity.User;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")

@RestController()
public class LoginController {
	
	@Autowired
	private UserService userService;
	private BCryptPasswordEncoder passwordEncoder;
	
	
	public LoginController(UserService userService,BCryptPasswordEncoder passwordEncoder) {
		super();
		this.userService = userService;
		this.passwordEncoder= passwordEncoder;
	}



	@PostMapping("/authorization")
	
	public @ResponseBody User authorization(@RequestBody User user)
	{
		
		System.out.println(user);
//		java.lang.Object
//		org.springframework.security.crypto.bcrypt.BCrypt
//		BCrypt implements OpenBSD-style Blowfish password hashing using the scheme described in "A Future-Adaptable Password Scheme" by Niels Provos and David Mazieres.
//		This password hashing system tries to thwart off-line password cracking using a computationally-intensive hashing algorithm, based on Bruce Schneier's Blowfish cipher. The work factor of the algorithm is parameterised, so it can be increased as computers get faster.
//
//		Usage is really simple. To hash a password for the first time, call the hashpw method with a random salt, like this:
//
//		String pw_hash = BCrypt.hashpw(plain_password, BCrypt.gensalt());
//
//		To check whether a plaintext password matches one that has been hashed previously, use the checkpw method:
//
//		if (BCrypt.checkpw(candidate_password, stored_hash))
//		    System.out.println("It matches");
//		else
//		    System.out.println("It does not match");
//
//		The gensalt() method takes an optional parameter (log_rounds) that determines the computational complexity of the hashing:

		if(!user.equals(null))
		{
			User tempUser = new User();
			tempUser = userService.getUserByUserName(user.getUserName());
			if(tempUser == null)
				return user;
			
			System.out.println(tempUser);
			//String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
	
	        if (BCrypt.checkpw( user.getPassword(),tempUser.getPassword())) {
	            System.out.println("It matches");
	            return tempUser;
	        }
	
	        else {
	            System.out.println("It does not match");
	        }
			
			return user;
		}
		else
			return user;
	}

}
