package com.helpDeskPortal.HDP.Service;

import java.util.List;

import com.helpDeskPortal.HDP.Exception.UserAllreadyFoundException;
import com.helpDeskPortal.HDP.entity.User;

public interface UserService {
	public void save(User user) throws UserAllreadyFoundException;

	public User getUserByUserName(String userName);

	public List<User> findAll();

	public User findById(int adminId);

	public void update(User user);

	public User findEmpById(int empId);
}
