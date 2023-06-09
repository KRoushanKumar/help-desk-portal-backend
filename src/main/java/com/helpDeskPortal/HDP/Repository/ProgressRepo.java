package com.helpDeskPortal.HDP.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.helpDeskPortal.HDP.entity.Progress;

public interface ProgressRepo extends JpaRepository<Progress, Integer> {

	String query1 = "SELECT * FROM progress where id=:progressId";
	@Query(value = query1,nativeQuery = true)
	Progress findProgressById(@Param("progressId") int progressId);

}
