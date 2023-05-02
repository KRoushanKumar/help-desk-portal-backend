package com.helpDeskPortal.HDP.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helpDeskPortal.HDP.Repository.TicketSubCategoriesRepo;
import com.helpDeskPortal.HDP.entity.TicketSubCategories;

@Service
public class TicketSubCategoriesServiceImpl implements TicketSubCategoriesService {

	@Autowired
	private TicketSubCategoriesRepo ticketSubCategoriesRepo; 
	
	
	public TicketSubCategoriesServiceImpl(TicketSubCategoriesRepo ticketSubCategoriesRepo) {
		super();
		this.ticketSubCategoriesRepo = ticketSubCategoriesRepo;
	}



	@Override
	public void save(TicketSubCategories ticketSubCategories) {
		
		 ticketSubCategoriesRepo.save(ticketSubCategories);
			
	}

}
