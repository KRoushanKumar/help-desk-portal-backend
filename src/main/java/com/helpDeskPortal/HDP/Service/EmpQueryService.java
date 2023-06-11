package com.helpDeskPortal.HDP.Service;

import java.util.List;

import com.helpDeskPortal.HDP.entity.EmployeeQuery;
import com.helpDeskPortal.HDP.entity.User;

public interface EmpQueryService {
	
	public List<EmployeeQuery> findAll();
	public void addEmployeeQuery(EmployeeQuery empQuery);

	public void save(EmployeeQuery empQuery);
	public List<EmployeeQuery> getEmployeeQuery(int empId);

	

}
