package com.helpDeskPortal.HDP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.helpDeskPortal.HDP.entity.Progress;

public interface ProgressRepo extends JpaRepository<Progress, Integer> {

}
