package com.helpDeskPortal.HDP.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.helpDeskPortal.HDP.Service.EmployeeService;
import com.helpDeskPortal.HDP.entity.User;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")

@RestController()
public class AdminCcontroller {
	
	@Autowired
	private EmployeeService empService;

	public AdminCcontroller(EmployeeService empService) {
		super();
		this.empService = empService;
	}
	
	@PostMapping("/addEmployee/{adminId}")
	public @ResponseBody User addEmployee(@RequestBody User user,@PathVariable int adminId)
	{
		System.err.println(user.toString());
		System.out.println(adminId);
		
		 return empService.saveEmployee(user,adminId);
	}
	
	@PutMapping("/updateEmployee/{empId}")
	public @ResponseBody User updateEmployee(@RequestBody User user,@PathVariable int empId)
	{
		System.out.println("In UpdateEmployee controller");
		System.out.println(user +" "+ empId);
		 return empService.updateEmployee(user,empId);
	}
	
	@DeleteMapping("/deleteEmployee/{empId}")
	public void deleteEmployee(@PathVariable int empId) {
		System.out.println("delete contoller");
		empService.deleteEmployee(empId);
	}
	
	
	
}
