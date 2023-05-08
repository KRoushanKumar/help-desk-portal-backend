package com.helpDeskPortal.HDP.Service;

import java.util.List;
import java.util.Optional;

import com.helpDeskPortal.HDP.entity.TicketCategories;

public interface TicketCategoriesService {
	public TicketCategories save(TicketCategories ticketCategories);

	public TicketCategories getById(int i);
	
	public List<TicketCategories> getAll();
	
	public Optional<TicketCategories> findById(int i);

	public void saveByAdminId(TicketCategories ticketCategories, int adminId);

	public List<TicketCategories> getAllbyAbminId(int adminId);
}
