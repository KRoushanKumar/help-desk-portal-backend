package com.helpDeskPortal.HDP.Service;

import com.helpDeskPortal.HDP.entity.User;

public interface EmployeeService {

	public User getAllEmployee(int adminDd);

	public User saveEmployee(User user, int adminId);
}
