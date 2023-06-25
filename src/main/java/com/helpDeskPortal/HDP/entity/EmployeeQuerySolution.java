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
	private String solution;
	
	@Column
	private Date lastSolutionDate;

	
	public EmployeeQuerySolution()
	{
		
	}
	
	public EmployeeQuerySolution(String solution, Date lastSolutionDate) {
		super();
		this.solution = solution;
		this.lastSolutionDate = lastSolutionDate;
	}

	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public Date getLastSolutionDate() {
		return lastSolutionDate;
	}

	public void setLastSolutionDate(Date lastSolutionDate) {
		this.lastSolutionDate = lastSolutionDate;
	}


	@Override
	public String toString() {
		return "EmployeeQuerySolution [id=" + id + ", solution=" + solution + ", lastSolutionDate=" + lastSolutionDate
				+ "]";
	}
	
	
	
	
}
