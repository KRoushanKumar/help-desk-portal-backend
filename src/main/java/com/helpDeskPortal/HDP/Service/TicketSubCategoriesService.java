package com.helpDeskPortal.HDP.Service;

import java.util.List;

import com.helpDeskPortal.HDP.entity.TicketSubCategories;

public interface TicketSubCategoriesService {
	public void save(TicketSubCategories ticketSubCategories);

	public List<TicketSubCategories> findAllByTickCategryId(int ticCatId);

	public List<TicketSubCategories> findAll();

	public TicketSubCategories getById(int ticSubId);
}
