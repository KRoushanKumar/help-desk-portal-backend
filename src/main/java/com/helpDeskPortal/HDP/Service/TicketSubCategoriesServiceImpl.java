package com.helpDeskPortal.HDP.Service;

import java.util.List;

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



	@Override
	public List<TicketSubCategories> findAllByTickCategryId(int ticCCatId) {
		
		
		return ticketSubCategoriesRepo.findAllByTickCategryId(ticCCatId);
	}



	@Override
	public List<TicketSubCategories> findAll() {
		
		return ticketSubCategoriesRepo.findAll();
	}



	@Override
	public TicketSubCategories getById(int ticSubId) {
		// TODO Auto-generated method stub
		return null;
	}

}
