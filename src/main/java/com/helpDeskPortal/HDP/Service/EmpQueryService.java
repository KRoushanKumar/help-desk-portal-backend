package com.helpDeskPortal.HDP.Service;

import java.util.List;

import com.helpDeskPortal.HDP.entity.EmployeeQuery;

public interface EmpQueryService {
	
	public List<EmployeeQuery> findAll();
	
	public void addEmployeeQuery(EmployeeQuery empQuery);

	public void save(EmployeeQuery empQuery);
	
	public List<EmployeeQuery> employeeQueryByCategoryAndSubCategory(int ticCatId, int ticSubId);
	
	public EmployeeQuery getQueryByID(int id);

	public List<EmployeeQuery> getByUserId(int userID);
	
	public Boolean deleteQueryByUserID(int userID); 
	

}
