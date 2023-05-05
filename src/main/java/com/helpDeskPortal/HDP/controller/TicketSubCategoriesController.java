package com.helpDeskPortal.HDP.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.helpDeskPortal.HDP.Service.TicketCategoriesService;
import com.helpDeskPortal.HDP.Service.TicketSubCategoriesService;
import com.helpDeskPortal.HDP.entity.TicketCategories;
import com.helpDeskPortal.HDP.entity.TicketSubCategories;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")

@RestController()
public class TicketSubCategoriesController {
	@Autowired
	private TicketCategoriesService  ticketCategoriesService;  
	private TicketSubCategoriesService ticketSubCategoriesService;
	public TicketSubCategoriesController()
	{
		
	}

	

	public TicketSubCategoriesController(TicketSubCategoriesService ticketSubCategoriesService,
			TicketCategoriesService ticketCategoriesService) {
		super();
		this.ticketSubCategoriesService = ticketSubCategoriesService;
		this.ticketCategoriesService = ticketCategoriesService;
	}


    // Add Ticket SubCategories 
	//@SuppressWarnings("unchecked")
	@PostMapping("/addTicketSubCategories/{tCateId}")
	public @ResponseBody TicketCategories addTicketSubCategories(@RequestBody TicketSubCategories tempTicketSubCategories,
				@PathVariable int tCateId )
	{
		TicketCategories ticCat = ticketCategoriesService.getById(tCateId);
		
		System.out.println(ticCat);
		ticCat.add(tempTicketSubCategories);
		//tempTicketSubCategories.setTicketCategories(ticCat);
		
		System.out.println(ticCat);
		
		return ticketCategoriesService.save(ticCat);
		
	}
}
