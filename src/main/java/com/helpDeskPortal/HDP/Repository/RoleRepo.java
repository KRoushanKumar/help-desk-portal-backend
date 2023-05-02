package com.helpDeskPortal.HDP.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.helpDeskPortal.HDP.entity.Role;

public interface RoleRepo extends JpaRepository<Role,Integer>{
		
	String query3 = "SELECT * from role where name=:name";
	@Query(value = query3,nativeQuery = true)
	public Role getRoleByName(@Param("name") String name);
}
