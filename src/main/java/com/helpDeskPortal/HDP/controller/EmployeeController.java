package com.helpDeskPortal.HDP.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.helpDeskPortal.HDP.Service.EmployeeService;
import com.helpDeskPortal.HDP.entity.User;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")

@RestController()
public class EmployeeController {
	
	
	@Autowired
	private EmployeeService empService;
	
	
	
	public EmployeeController(EmployeeService empService) {
		super();
		this.empService = empService;
	}
	
	@GetMapping("/getUserByUserId/{UserID}")
	public @ResponseBody List<User> getUserByUserId(@PathVariable("UserID") int userId) {
		System.out.println("arrived controller");
		System.out.println("user id"+userId);
		return empService.getUserByUserId(userId);
		
	}
	
	@GetMapping("/getAllEmployees/{adminId}")
	public @ResponseBody List<User> getAllEmployees(@PathVariable int adminId)
	{
		return empService.getAllEmployee(adminId) ;
	}

	
}
