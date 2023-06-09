package com.helpDeskPortal.HDP.Service;

import java.util.List;

import com.helpDeskPortal.HDP.entity.User;

public interface EmployeeService {

	public List<User> getAllEmployee(int adminDd);

	public User saveEmployee(User user, int adminId);

	public List<User> getUserByUserId(int userID);
	
	
}
