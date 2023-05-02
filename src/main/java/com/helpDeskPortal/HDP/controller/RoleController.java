package com.helpDeskPortal.HDP.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.helpDeskPortal.HDP.Service.RoleService;
import com.helpDeskPortal.HDP.entity.Role;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")

@RestController()
public class RoleController {
	
	
	@Autowired
	private RoleService roleService;
	
	
	
	public RoleController(RoleService roleService) {
		super();
		this.roleService = roleService;
	}



	@GetMapping("/getRoleByName")
	public Role getRoleByName()
	{
		System.out.println("getRoleByName");
		return roleService.getRoleByName("Admin"); 
	}
	
	@GetMapping("/getRoles")
	public List<Role> getRoles()
	{
		System.out.println("getRoles");
		return roleService.findAll(); 
	}
	
}
