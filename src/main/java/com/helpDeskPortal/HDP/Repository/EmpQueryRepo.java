package com.helpDeskPortal.HDP.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.helpDeskPortal.HDP.entity.EmployeeQuery;


public interface EmpQueryRepo extends JpaRepository<EmployeeQuery, Integer> {

	
	String query3 = "SELECT * FROM employee_query where emp_id=:empId";
	@Query(value = query3,nativeQuery = true)
	public List<EmployeeQuery> getEmployeeQueryById(@Param("empId") int empId);
	
}
