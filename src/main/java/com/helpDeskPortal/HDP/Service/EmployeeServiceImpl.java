package com.helpDeskPortal.HDP.Service;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.helpDeskPortal.HDP.Repository.UserRepo;
import com.helpDeskPortal.HDP.entity.User;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	
	@Autowired
	private UserRepo userRepo;
	private RoleService roleService;
	private BCryptPasswordEncoder passwordEncoder;
	private static final Logger logger = Logger.getLogger(EmployeeServiceImpl.class);
	
	//instance initializer block
	//{
	//	BasicConfigurator.configure();
	//}
	
	public EmployeeServiceImpl(UserRepo userRepo,RoleService roleService,BCryptPasswordEncoder passwordEncoder) {
		super();
		this.userRepo = userRepo;
		this.roleService = roleService;
		this.passwordEncoder = passwordEncoder; 
	}



	@Override
	public List<User> getAllEmployee(int adminId) {
		
		
		
		return userRepo.getAllEmployee(adminId);
	}
	
	

	@Override
	public User saveEmployee(User user, int adminId) {
		
		user.setAdminId(adminId);
		user.setRoles(Arrays.asList(roleService.getRoleByName("Employee")));
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		logger.debug("Save Employee...");
		try {
			return userRepo.save(user);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			logger.debug(e.getMessage());
		}
		
		//return userRepo.save(user);
		return user;
		
	}



	@Override
	public User getUserByUserId(int userID) {
		// TODO Auto-generated method stub
		System.out.println("arrived service implementation class");
		System.out.println("user id"+userID);
		return userRepo.getUserByUserId(userID);
	}



	

}
