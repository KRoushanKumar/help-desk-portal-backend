package com.helpDeskPortal.HDP.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.helpDeskPortal.HDP.Service.TicketCategoriesService;
import com.helpDeskPortal.HDP.entity.TicketCategories;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")

@RestController()
public class TicketCategoriesController {
	
	@Autowired
	private TicketCategoriesService ticketCategoriesService;

	public TicketCategoriesController(TicketCategoriesService ticketCategoriesService) {
		super();
		this.ticketCategoriesService = ticketCategoriesService;
	}
	
	@PostMapping("/addTicketCategories")
	public void addTicketCategories(@RequestBody TicketCategories ticketCategories )
	{
		ticketCategoriesService.save(ticketCategories);
	}
	
    @GetMapping("/allTicketCategories")
    public void allTicketCategories()
    {
    	List<TicketCategories> ticCat = new ArrayList<>();
    	ticCat =  ticketCategoriesService.getAll();
    	System.out.println("Ticket "+ticCat.toString());
    }
    
	
}
