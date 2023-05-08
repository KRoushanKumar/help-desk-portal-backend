package com.helpDeskPortal.HDP.Repository;

import java.util.List;

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
	
	
	String query5 = "SELECT * FROM user where admin_id=:adminId";
	//@Transactional
	//@Modifying(clearAutomatically = true)
	@Query(value = query5,nativeQuery = true)
	//SELECT * FROM help_desk_portal.user where admin_id=0;
	public List<User> getAllEmployee(@Param("adminId") int adminId);
	
	
	String query6 = "SELECT * FROM user where id=:adminId and admin_id=0";
	@Query(value = query6,nativeQuery = true)
	public User findByAdminId(@Param("adminId") int adminId);
}
