package com.helpDeskPortal.HDP.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.helpDeskPortal.HDP.Repository.EmpQueryRepo;
import com.helpDeskPortal.HDP.Repository.PriorityRepo;
import com.helpDeskPortal.HDP.Repository.ProgressRepo;
import com.helpDeskPortal.HDP.Service.EmpQueryService;
import com.helpDeskPortal.HDP.Service.PriorityService;
import com.helpDeskPortal.HDP.Service.ProgressService;
import com.helpDeskPortal.HDP.Service.TicketCategoriesService;
import com.helpDeskPortal.HDP.Service.TicketSubCategoriesService;
import com.helpDeskPortal.HDP.Service.UserService;
import com.helpDeskPortal.HDP.entity.EmployeeQuery;
import com.helpDeskPortal.HDP.entity.EmployeeQuerySolution;
import com.helpDeskPortal.HDP.entity.Priority;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")

@RestController()
public class EmpQueryController {
	
	@Autowired
	private EmpQueryService empQueryService;
	
	private PriorityService priorityService;
	private ProgressService progressService;
	private TicketCategoriesService ticketCategoriesService;
	private TicketSubCategoriesService ticketSubCategoriesService;
	private UserService userService;
	
	
	


	public EmpQueryController(EmpQueryService empQueryService, PriorityService priorityService,
			ProgressService progressService, TicketCategoriesService ticketCategoriesService,
			TicketSubCategoriesService ticketSubCategoriesService, UserService userService) {
		super();
		this.empQueryService = empQueryService;
		this.priorityService = priorityService;
		this.progressService = progressService;
		this.ticketCategoriesService = ticketCategoriesService;
		this.ticketSubCategoriesService = ticketSubCategoriesService;
		this.userService = userService;
	}


	@GetMapping("/AllEmployeeQuery")
	public List<EmployeeQuery> AllEmployeeQuery()
	{
		return empQueryService.findAll();
	}
	
	@GetMapping("/AllEmployeeQuery/{UserID}")
	public List<EmployeeQuery> AllEmployeeQuery(@PathVariable int UserID )
	{
		
		System.out.println("UserID" + UserID);
		return empQueryService.getByUserId(UserID);
	}
	
	@GetMapping("/employeeQueryByCategoryAndSubCategory/{ticCatId}/{ticSubId}")
	public List<EmployeeQuery> employeeQueryByCategoryAndSubCategory(
			@PathVariable("ticCatId") int ticCatId,
			@PathVariable("ticSubId") int ticSubId)
	{
		return empQueryService.employeeQueryByCategoryAndSubCategory(ticCatId,ticSubId);
	}
	
	

	
	@PostMapping("/AddEmployeeQuery/{ticCatId}/{ticSubId}/{pritotyId}/{progressId}/{empId}")
	public void AddEmployeeQuery(@RequestBody EmployeeQuery empQuery,
			@PathVariable("ticCatId") int ticCatId,@PathVariable("ticSubId") int ticSubId,
			@PathVariable("pritotyId") int pritotyId,@PathVariable("progressId") int progressId,
			@PathVariable("empId") int empId)
	{
		//insert into employee_query  
		//values(5,'4 april 4 pm',' hardware issue',
		//'2023-4-12','2023-4-11',11,4,1,1,33);
		System.out.println("query "+empQuery.toString());
		
		empQuery.setPriority(priorityService.findById(pritotyId));
		empQuery.setProgress(progressService.findById(progressId));
		empQuery.setTicketCategories(ticketCategoriesService.getById(ticCatId));
		empQuery.setTicketSubCategories(ticketSubCategoriesService.getById(ticSubId));
		empQuery.setUser(userService.findEmpById(empId));
		
		System.out.println("query "+empQuery.toString());
		
		empQueryService.save(empQuery);
	}
	
	//Employee Query ID Is is ticket ID.
	@PostMapping("/addEmpQuerySolution/{empQueryId}")
	public void addEmpQuerySolution(@RequestBody EmployeeQuerySolution empQuerySol,@PathVariable int empQueryId)
	{
		System.out.println("empQuery " +empQuerySol);
		
		EmployeeQuery tempEmpQuery = new EmployeeQuery();
		tempEmpQuery = empQueryService.getQueryByID(empQueryId);
		tempEmpQuery.add(empQuerySol);
		
		System.out.println(" tempEmpQuery "+tempEmpQuery);
		
		empQueryService.addEmployeeQuery(tempEmpQuery);
		
	}
	
	@GetMapping("/queryById/{id}")
	public EmployeeQuery queryById(@PathVariable int id)
	{
		
		return empQueryService.getQueryByID(id);
	}

}
