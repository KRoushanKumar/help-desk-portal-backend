package com.helpDeskPortal.HDP.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.helpDeskPortal.HDP.Repository.EmpQueryRepo;
import com.helpDeskPortal.HDP.Service.EmpQueryService;
import com.helpDeskPortal.HDP.entity.EmployeeQuery;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")

@RestController()
public class EmpQueryController {
	
	@Autowired
	private EmpQueryService empQueryService;
	

	
	
	public EmpQueryController(EmpQueryService empQueryService) {
		super();
		this.empQueryService = empQueryService;
	}




	@GetMapping("/AllEmployeeQuery")
	public List<EmployeeQuery> AllEmployeeQuery()
	{
		return empQueryService.findAll();
	}
	

}
