package com.helpDeskPortal.HDP.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helpDeskPortal.HDP.Repository.UserRepo;
import com.helpDeskPortal.HDP.entity.User;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	
	@Autowired
	private UserRepo userRepo;
	
	
	
	public EmployeeServiceImpl(UserRepo userRepo) {
		super();
		this.userRepo = userRepo;
	}



	@Override
	public User getAllEmployee(int adminId) {
		
		
		
		return userRepo.getAllEmployee(adminId);
	}

}
