package com.helpDeskPortal.HDP.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.helpDeskPortal.HDP.entity.TicketCategories;
import com.helpDeskPortal.HDP.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	
	
	String query4 = "select * from user where username=:username";
	@Query(value = query4,nativeQuery = true)
	public User getUserByUserName(@Param("username") String username);
}
