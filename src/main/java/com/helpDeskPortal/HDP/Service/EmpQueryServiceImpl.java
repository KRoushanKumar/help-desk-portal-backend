package com.helpDeskPortal.HDP.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helpDeskPortal.HDP.Repository.EmpQueryRepo;
import com.helpDeskPortal.HDP.entity.EmployeeQuery;

@Service
public class EmpQueryServiceImpl implements EmpQueryService{

	
	@Autowired
	private EmpQueryRepo empQueryRepo;
	
	
	
	public EmpQueryServiceImpl(EmpQueryRepo empQueryRepo) {
		super();
		this.empQueryRepo = empQueryRepo;
	}



	@Override
	public List<EmployeeQuery> findAll() {
		
		return empQueryRepo.findAll();
	}



	@Override
	public void addEmployeeQuery(EmployeeQuery empQuery) {
		
		empQueryRepo.save(empQuery);
	}



	@Override
	public void save(EmployeeQuery empQuery) {
		empQueryRepo.save(empQuery);
		
	}



	@Override
	public List<EmployeeQuery> employeeQueryByCategoryAndSubCategory(int ticCatId, int ticSubId) {
		
		
		return empQueryRepo.employeeQueryByCategoryAndSubCategory(ticCatId,ticSubId);
	}



	@Override
	public EmployeeQuery getQueryByID(int id) {
		
		return empQueryRepo.getQueryById(id);
	}



	@Override
	public List<EmployeeQuery> getByUserId(int userID) {
		
		return empQueryRepo.findAllByUserID(userID);
	}



	

	
}
