package com.helpDeskPortal.HDP.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.helpDeskPortal.HDP.Service.UserService;
import com.helpDeskPortal.HDP.entity.User;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")

@RestController()
public class RegistrationController {
	
	@Autowired
	private UserService userService;
	
	
	
	public RegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping("/registration")
	public void registration(@RequestBody User user)
	{
		System.out.println(user.toString());
		userService.save(user);
	}
	
	@PostMapping("/show")
	public void show()
	{
		System.out.print("ragini");
	}
	
	
	

}
