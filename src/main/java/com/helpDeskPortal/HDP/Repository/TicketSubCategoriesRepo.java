package com.helpDeskPortal.HDP.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.helpDeskPortal.HDP.entity.TicketSubCategories;

public interface TicketSubCategoriesRepo extends JpaRepository<TicketSubCategories,Integer> {

	String query1= "SELECT * FROM ticket_sub_categories where ticket_categories_id=:ticCCatId";
	@Query(value = query1,nativeQuery = true)
	public List<TicketSubCategories> findAllByTickCategryId(@Param("ticCCatId") int ticCCatId);

}
