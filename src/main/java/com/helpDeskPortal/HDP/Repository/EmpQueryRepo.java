package com.helpDeskPortal.HDP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.helpDeskPortal.HDP.entity.EmployeeQuery;

public interface EmpQueryRepo extends JpaRepository<EmployeeQuery, Integer> {

}
