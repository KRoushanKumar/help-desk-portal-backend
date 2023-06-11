package com.helpDeskPortal.HDP.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helpDeskPortal.HDP.Repository.PriorityRepo;
import com.helpDeskPortal.HDP.entity.Priority;

@Service
public class PriorityServiceImpl implements PriorityService {

	
	@Autowired
	private PriorityRepo priorityRepo;
	
	
	
	public PriorityServiceImpl(PriorityRepo priorityRepo) {
		super();
		this.priorityRepo = priorityRepo;
	}

	@Override
	public void save(Priority priority) {
		
		priorityRepo.save(priority);
	}

	@Override
	public Priority findById(int id) {
		
		return priorityRepo.getPriorityById(id);
	}

}
