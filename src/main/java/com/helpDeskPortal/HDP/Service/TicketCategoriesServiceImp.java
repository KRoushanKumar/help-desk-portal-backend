package com.helpDeskPortal.HDP.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helpDeskPortal.HDP.Repository.TicketCategoriesRepo;
import com.helpDeskPortal.HDP.entity.TicketCategories;

@Service
public class TicketCategoriesServiceImp implements TicketCategoriesService {

	
	@Autowired
	private TicketCategoriesRepo ticketCategoriesRepo;
	
	
	
	public TicketCategoriesServiceImp(TicketCategoriesRepo ticketCategoriesRepo) {
		super();
		this.ticketCategoriesRepo = ticketCategoriesRepo;
	}



	@Override
	public void save(TicketCategories ticketCategories) {
		
		ticketCategoriesRepo.save(ticketCategories);
	}



	@Override
	public TicketCategories getById(int i) {
		
		
			return ticketCategoriesRepo.getTicketCategoriesById(i);
	
		
	}



	@Override
	public List<TicketCategories> getAll() {
		return ticketCategoriesRepo.findAll();
	}

}
