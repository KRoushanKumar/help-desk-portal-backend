package com.helpDeskPortal.HDP.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helpDeskPortal.HDP.Repository.TicketCategoriesRepo;
import com.helpDeskPortal.HDP.Repository.UserRepo;
import com.helpDeskPortal.HDP.entity.TicketCategories;
import com.helpDeskPortal.HDP.entity.User;

@Service
public class TicketCategoriesServiceImp implements TicketCategoriesService {

	
	@Autowired
	private TicketCategoriesRepo ticketCategoriesRepo;
	private UserService userService;
	
	
	
	public TicketCategoriesServiceImp(TicketCategoriesRepo ticketCategoriesRepo,
			UserService userService) {
		super();
		
		this.ticketCategoriesRepo = ticketCategoriesRepo;
		this.userService = userService;
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



	@Override
	public void saveByAdminId(TicketCategories ticketCategories, int adminId) {
		
		User user = new User();
		try {
			user = userService.findById(adminId);
			if(user!=null) {
				user.addTickCtgry(ticketCategories);
				//userService.save(user);
				userService.update(user);
			}
			else
			{
				System.out.println("User null");
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
	}



	@Override
	public List<TicketCategories> getAllbyAbminId(int adminId) {
		
		return ticketCategoriesRepo.getAllByAdminId(adminId);
	}



	@Override
	public void updateTicketCatgory(TicketCategories ticketCategories, int ticketId) {
		// TODO Auto-generated method stub
		System.out.println("update ticket categoroy service called");
		TicketCategories ticket=this.ticketCategoriesRepo.getTicketCategoriesById(ticketId);
		System.out.println(ticket.getName());
		ticket.setName(ticketCategories.getName());
		this.ticketCategoriesRepo.save(ticket);
	}



	@Override
	public void deleteTicketCategory(int ticketId) {
		// TODO Auto-generated method stub
		TicketCategories ticket=this.ticketCategoriesRepo.getTicketCategoriesById(ticketId);
		System.out.println("delete service of ticket category ");
		System.out.println(ticket);
		this.ticketCategoriesRepo.delete(ticket);
	}

}
