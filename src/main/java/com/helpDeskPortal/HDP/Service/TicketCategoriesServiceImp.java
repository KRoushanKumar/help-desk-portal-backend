package com.helpDeskPortal.HDP.Service;


import java.util.List;
import java.util.Optional;

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
	public TicketCategories save(TicketCategories ticketCategories) {
		
		return ticketCategoriesRepo.save(ticketCategories);
	}



	@Override
	public TicketCategories getById(int i) {
		
		
			return ticketCategoriesRepo.getTicketCategoriesById(i);
	
		
	}



	@Override
	public List<TicketCategories> getAll() {
		return ticketCategoriesRepo.findAll();
	}



	@Override
	public Optional<TicketCategories> findById(int i) {
		
		return ticketCategoriesRepo.findById(i);
	}

}
