package com.helpDeskPortal.HDP.controller;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	private static final Logger  logger = Logger.getLogger(TicketSubCategoriesController.class);
	
	
    public TicketSubCategoriesController(TicketCategoriesService ticketCategoriesService,
			TicketSubCategoriesService ticketSubCategoriesService) {
		super();
		this.ticketCategoriesService = ticketCategoriesService;
		this.ticketSubCategoriesService = ticketSubCategoriesService;
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
	
	// get all  ticket sub categories by ticket category Id 
	@GetMapping("/subTickCatgyByTicCatgyId/{TicCatId}")
	public List<TicketSubCategories> SubCatByCatId(@PathVariable int TicCatId)
	{
		logger.debug("subTickCatgyByTicCatgyId");
		return ticketSubCategoriesService.findAllByTickCategryId(TicCatId);
		//return ticketSubCategoriesService.findAll();
	}
	
	@GetMapping("/getSubCatById/{ticSubId}")
	public @ResponseBody TicketSubCategories getSubCatById(@PathVariable int ticSubId)
	{
		
		return this.ticketSubCategoriesService.getSubCatById(ticSubId);
		
	}
	
	@PutMapping("/updateSubCateTic/{ticSubId}")
	public void updateSubCateTic(@RequestBody TicketSubCategories tempTicketSubCategories,@PathVariable int ticSubId) {
		this.ticketSubCategoriesService.updateSubCategory(tempTicketSubCategories,ticSubId);
	}
	
	@DeleteMapping("/deleteSubCateTic/{ticSubId}")
	public void deleteSubCate(@PathVariable int ticSubId) {
		this.ticketSubCategoriesService.deleteSubCategory(ticSubId);
	}
	
}
