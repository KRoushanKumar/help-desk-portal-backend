package com.helpDeskPortal.HDP.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee_query")
public class EmployeeQuery {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column
	private String description;
	
	@Column
	private Date startDate;
	
	@Column
	private Date endDate;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "priority_id" , referencedColumnName = "id")
	private Priority priority;
	

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "progress_id" , referencedColumnName = "id")
	private Progress progress;
	
	@Column
	private String avaTimeDiscussion;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_id")
	private User user;
	
	@Column
	private Integer ticCatId;
	
	@Column
	private Integer ticSubId;
	
	@OneToMany(cascade = CascadeType.ALL )
	@JoinColumn(name = "emp_query_id")
	private List<EmployeeQuerySolution> empQuerySol;

	
	
	
	
	public List<EmployeeQuerySolution> getEmpQuerySol() {
		return empQuerySol;
	}

	public void setEmpQuerySol(List<EmployeeQuerySolution> empQuerySol) {
		this.empQuerySol = empQuerySol;
	}
	
	public void add(EmployeeQuerySolution tempEmpQuerySolution)
	{
		if(empQuerySol==null)
		{
			empQuerySol = new ArrayList<>();
		}
		else
			empQuerySol.add(tempEmpQuerySolution);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	

	public Progress getProgress() {
		return progress;
	}

	public void setProgress(Progress progress) {
		this.progress = progress;
	}

	public String getAvaTimeDiscussion() {
		return avaTimeDiscussion;
	}

	public void setAvaTimeDiscussion(String avaTimeDiscussion) {
		this.avaTimeDiscussion = avaTimeDiscussion;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getTicCatId() {
		return ticCatId;
	}

	public void setTicCatId(Integer ticCatId) {
		this.ticCatId = ticCatId;
	}

	public Integer getTicSubId() {
		return ticSubId;
	}

	public void setTicSubId(Integer ticSubId) {
		this.ticSubId = ticSubId;
	}
	
	
	
	
	
}
