package com.helpDeskPortal.HDP.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helpDeskPortal.HDP.Repository.ProgressRepo;
import com.helpDeskPortal.HDP.entity.Progress;

@Service
public class ProgressServiceImpl implements ProgressService {

	@Autowired
	private ProgressRepo progressRepo;
	
	
	
	public ProgressServiceImpl(ProgressRepo progressRepo) {
		super();
		this.progressRepo = progressRepo;
	}



	@Override
	public Progress findById(int progressId) {
		
		return progressRepo.findProgressById(progressId);
	}

}
