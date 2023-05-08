package com.helpDeskPortal.HDP.Service;

import java.util.Arrays;
import java.util.List;

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
		return userRepo.save(user);
		
	}



	

}
