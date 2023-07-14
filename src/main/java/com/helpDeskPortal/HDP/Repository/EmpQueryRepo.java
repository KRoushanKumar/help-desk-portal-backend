package com.helpDeskPortal.HDP.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.helpDeskPortal.HDP.entity.EmployeeQuery;


public interface EmpQueryRepo extends JpaRepository<EmployeeQuery, Integer> {

	String query1 = "select * from employee_query where ticket_categories_id =:ticCatId and ticket_sub_categories_id =:ticSubId";
	@Query(value = query1,nativeQuery = true)
	List<EmployeeQuery> employeeQueryByCategoryAndSubCategory(@Param("ticCatId") int ticCatId,@Param("ticSubId") int ticSubId);
	
	String query2 = "select * from employee_query where id=:id";
	@Query(value = query2,nativeQuery = true)
	EmployeeQuery getQueryById(@Param("id") int id);
	
	String query3 = "select * from employee_query where user_id=:userID";
	@Query(value = query3,nativeQuery = true)
	List<EmployeeQuery> findAllByUserID(@Param("userID") int userID);

}
