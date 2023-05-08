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

	
}
