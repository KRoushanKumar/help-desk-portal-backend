package com.helpDeskPortal.HDP.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.helpDeskPortal.HDP.Repository.UserRepo;
import com.helpDeskPortal.HDP.entity.TicketCategories;
import com.helpDeskPortal.HDP.entity.User;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public UserServiceImpl(UserRepo userRepo) {
		super();
		this.userRepo = userRepo;
	}

	@Override
	public void save(User user) {
		
		final String encodedPassword  = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		userRepo.save(user);
	}

	@Override
	public User getUserByUserName(String userName) {
		
		return userRepo.getUserByUserName(userName);
	}

	@Override
	public List<User> findAll() {
		
		return userRepo.findAll();
	}

	@Override
	public User findById(int adminId) {
		
		
		return userRepo.findByAdminId(adminId);
	}

	@Override
	public void update(User user) {
		userRepo.save(user);
	}

	

}
