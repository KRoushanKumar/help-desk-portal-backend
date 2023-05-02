package com.helpDeskPortal.HDP.Service;

import java.util.List;

import com.helpDeskPortal.HDP.entity.TicketCategories;

public interface TicketCategoriesService {
	public void save(TicketCategories ticketCategories);

	public TicketCategories getById(int i);
	
	public List<TicketCategories> getAll();
}
