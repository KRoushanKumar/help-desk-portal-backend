package com.helpDeskPortal.HDP.Service;

import com.helpDeskPortal.HDP.entity.Priority;

public interface PriorityService {

	public void save(Priority priority);
	public Priority findById(int id);
}
