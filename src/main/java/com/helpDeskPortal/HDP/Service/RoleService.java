package com.helpDeskPortal.HDP.Service;

import java.util.List;

import com.helpDeskPortal.HDP.entity.Role;

public interface RoleService {
	
	public Role getRoleByName(String name);

	public List<Role> findAll();
}
