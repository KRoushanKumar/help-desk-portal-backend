package com.helpDeskPortal.HDP.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	private TicketSubCategoriesService ticketSubCategoriesService;
	private TicketCategoriesService  ticketCategoriesService;  

	public TicketSubCategoriesController()
	{
		
	}

	

	public TicketSubCategoriesController(TicketSubCategoriesService ticketSubCategoriesService,
			TicketCategoriesService ticketCategoriesService) {
		super();
		this.ticketSubCategoriesService = ticketSubCategoriesService;
		this.ticketCategoriesService = ticketCategoriesService;
	}



	//@SuppressWarnings("unchecked")
	@PostMapping("/addTicketSubCategories")
	public void addTicketSubCategories(@RequestBody TicketSubCategories ticketSubCategories )
	{
		//List<TicketCategories> ticCat = new ArrayList<>();
		//ticCat =  ticketCategoriesService.getAll();
		//System.out.println("Ticket "+ticCat.toString());
		//if(ticCat!=null) {
		//ticCat.setTicketSubCategeries((List<TicketSubCategories>) ticketSubCategories);
		//ticketSubCategoriesService.save(ticketSubCategories);
		//}
		
	}
}
