package com.helpDeskPortal.HDP.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.helpDeskPortal.HDP.entity.TicketCategories;

public interface TicketCategoriesRepo extends JpaRepository<TicketCategories, Integer> {


	String query3 = "SELECT * FROM ticket_categories where id=:id";
	//@Transactional
	//@Modifying(clearAutomatically = true)
	@Query(value = query3,nativeQuery = true)
	public TicketCategories getTicketCategoriesById(@Param("id") Integer id);
	
	String query4 = "SELECT * FROM ticket_categories where admin_id=:adminId";
	@Query(value = query4,nativeQuery = true)
	public List<TicketCategories> getAllByAdminId(@Param("adminId") int adminId);
	

}
