package com.helpDeskPortal.HDP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.helpDeskPortal.HDP.entity.Priority;

public interface PriorityRepo extends JpaRepository<Priority,Integer> {

	String query3 = "SELECT * FROM priority where id=:id";
	@Query(value = query3,nativeQuery = true)
	public Priority getPriorityById(@Param("id") int id);
    
}
