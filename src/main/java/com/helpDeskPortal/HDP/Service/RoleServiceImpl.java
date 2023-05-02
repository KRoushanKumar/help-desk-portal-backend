package com.helpDeskPortal.HDP.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helpDeskPortal.HDP.Repository.RoleRepo;
import com.helpDeskPortal.HDP.entity.Role;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepo roleRepo;
	
	
	public RoleServiceImpl(RoleRepo roleRepo) {
		super();
		this.roleRepo = roleRepo;
	}


	@Override
	public Role getRoleByName(String name) {
		
		return roleRepo.getRoleByName(name);
	}


	@Override
	public List<Role> findAll() {
		
		return roleRepo.findAll();
	}

}
