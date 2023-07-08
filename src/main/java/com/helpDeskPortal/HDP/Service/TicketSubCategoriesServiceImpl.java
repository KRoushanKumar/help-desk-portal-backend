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
		return ticketSubCategoriesRepo.getTicSubCatByID(ticSubId);
	}



	@Override
	public void updateSubCategory(TicketSubCategories tempTicketSubCategories, int ticSubId) {
		// TODO Auto-generated method stub
		TicketSubCategories subCategory=this.ticketSubCategoriesRepo.getTicSubCatByID(ticSubId);
		subCategory.setName(tempTicketSubCategories.getName());
		this.ticketSubCategoriesRepo.save(subCategory);
	}

	@Override
	public void deleteSubCategory(int ticSubId) {
		// TODO Auto-generated method stub
		TicketSubCategories subCategory=this.ticketSubCategoriesRepo.getTicSubCatByID(ticSubId);
		this.ticketSubCategoriesRepo.delete(subCategory);
	}

}
