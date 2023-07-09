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
//import com.helpDeskPortal.HDP.exceptions.ResourceNotFoundExcepotion;


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
	public List<User> getUserByUserId(int userID) {
		// TODO Auto-generated method stub
		System.out.println("arrived service implementation class");
		System.out.println("user id"+userID);
		return userRepo.getUserByUserId(userID);
	}



	@Override
	public User updateEmployee(User user,int empId) {
		// TODO Auto-generated method stub
		System.out.println("In UpdateEmployee service");
		User user1 = this.userRepo.findEmployeeById(empId);
		System.out.println(user);
		System.out.println(empId);
		user1.setFirstName(user.getFirstName());
		user1.setLastName(user.getLastName());
		user1.setEmail(user.getEmail());
		//user1.setUserName(user.getUserName());
		return userRepo.save(user1);
	}



	@Override
	public boolean deleteEmployee(int empId) {
		
		System.out.println("Employee service");
		try {
			userRepo.deleteById(empId);
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}



	

}
