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

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "employee_query")
public class EmployeeQuery {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column
	private String description;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date startDate;
	
	@Column
	@JsonFormat(pattern="yyyy-MM-dd")
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
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tic_cat_id" , referencedColumnName = "id")
	private TicketCategories ticketCategories;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tic_sub_id" , referencedColumnName = "id")
	private TicketSubCategories ticketSubCategories ;
	
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

	public TicketCategories getTicketCategories() {
		return ticketCategories;
	}

	public void setTicketCategories(TicketCategories ticketCategories) {
		this.ticketCategories = ticketCategories;
	}

	public TicketSubCategories getTicketSubCategories() {
		return ticketSubCategories;
	}

	public void setTicketSubCategories(TicketSubCategories ticketSubCategories) {
		this.ticketSubCategories = ticketSubCategories;
	}

	@Override
	public String toString() {
		return "EmployeeQuery [id=" + id + ", description=" + description + ", startDate=" + startDate + ", endDate="
				+ endDate + ", priority=" + priority + ", progress=" + progress + ", avaTimeDiscussion="
				+ avaTimeDiscussion + ", user=" + user + ", ticketCategories=" + ticketCategories
				+ ", ticketSubCategories=" + ticketSubCategories + ", empQuerySol=" + empQuerySol + "]";
	}

	

	
	
	
	
	
	
}
