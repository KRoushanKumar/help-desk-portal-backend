package com.helpDeskPortal.HDP.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table()
public class EmployeeQuerySolution {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column
	private String Solution;
	
	@Column
	private Date lastSolutionDate;

	public String getSolution() {
		return Solution;
	}

	public void setSolution(String solution) {
		Solution = solution;
	}

	public Date getLastSolutionDate() {
		return lastSolutionDate;
	}

	public void setLastSolutionDate(Date lastSolutionDate) {
		this.lastSolutionDate = lastSolutionDate;
	}
	
	
	
}
