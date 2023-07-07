package com.helpDeskPortal.HDP.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.helpDeskPortal.HDP.Service.RoleService;
import com.helpDeskPortal.HDP.Service.UserService;
import com.helpDeskPortal.HDP.entity.User;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")

@RestController()
public class RegistrationController {
	
	@Autowired
	private UserService userService;
	private RoleService roleService;
	
	
	public RegistrationController(UserService userService,RoleService roleService) {
		super();
		this.userService = userService;
		this.roleService = roleService;
	}
	
	@PostMapping("/registration")
	public void registration(@RequestBody User user)
	{
		System.out.println(user.toString());
		user.setRoles(Arrays.asList(roleService.getRoleByName("Admin")));
		user.setAdminId(0);
		userService.save(user);
	}
	
	@GetMapping("/userName/{userName}")
	public User userName(@PathVariable String userName)
	{
		
		return userService.getUserByUserName(userName);
	}
	
	
	
	

}
