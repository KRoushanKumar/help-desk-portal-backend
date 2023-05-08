package com.helpDeskPortal.HDP.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
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

import com.helpDeskPortal.HDP.Service.EmployeeServiceImpl;
import com.helpDeskPortal.HDP.Service.TicketCategoriesService;
import com.helpDeskPortal.HDP.entity.TicketCategories;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")

@RestController()
public class TicketCategoriesController {
	
	@Autowired
	private TicketCategoriesService ticketCategoriesService;
	private static final Logger logger = Logger.getLogger(EmployeeServiceImpl.class);
	
	public TicketCategoriesController(TicketCategoriesService ticketCategoriesService) {
		super();
		this.ticketCategoriesService = ticketCategoriesService;
	}
	
	@PostMapping("/addTicketCategories")
	public void addTicketCategories(@RequestBody TicketCategories ticketCategories )
	{
		ticketCategoriesService.save(ticketCategories);
	}
	
	@PostMapping("/addTicketCategories/{adminId}")
	public void addTicketCategoriesByAdminId(@RequestBody TicketCategories ticketCategories,@PathVariable int adminId )
	{
		
		ticketCategoriesService.saveByAdminId(ticketCategories,adminId);
	}
	
    @GetMapping("/allTicketCategories")
    public List<TicketCategories> allTicketCategories()
    {
    	List<TicketCategories> ticCat = new ArrayList<>();
    	ticCat =  ticketCategoriesService.getAll();
    	System.out.println("Ticket "+ticCat.toString());
    	return ticCat;
    	//return null;
    }
    
    @GetMapping("/allTicketCategories/{adminId}")
    public List<TicketCategories> allTicketCategoriesByAdminId(@PathVariable int adminId)
    {
    	
    	return ticketCategoriesService.getAllbyAbminId(adminId);
    	//return null;
    }
    
  
	@GetMapping("/ticketCategoryById/{id}")
    public  TicketCategories ticketCategoryById(@PathVariable int id)
    {
    	//System.out.println(ticketCategoriesService.getById(id));
    	//return null;
		try {
			logger.debug("getTicketCategoryById");
			return ticketCategoriesService.getById((Integer)id);
		}
		catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		
    	return null;
    }
	
	@GetMapping("/ticketCategoryByIdByAdminId/{adminId}/{id}")
    public  TicketCategories ticketCategoryByIdByAdminId(@PathVariable int adminId,@PathVariable int id)
    {
    	System.out.println(adminId+" "+id);
    	
    	
		
    	return null;
    }
    
	
}
