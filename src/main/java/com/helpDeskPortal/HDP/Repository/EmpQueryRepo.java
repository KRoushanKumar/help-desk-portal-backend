package com.helpDeskPortal.HDP.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.helpDeskPortal.HDP.entity.EmployeeQuery;

public interface EmpQueryRepo extends JpaRepository<EmployeeQuery, Integer> {

	String query1 = "select * from employee_query where tic_cat_id =:ticCatId and tic_sub_id =:ticSubId";
	@Query(value = query1,nativeQuery = true)
	List<EmployeeQuery> employeeQueryByCategoryAndSubCategory(@Param("ticCatId") int ticCatId,@Param("ticSubId") int ticSubId);

}
