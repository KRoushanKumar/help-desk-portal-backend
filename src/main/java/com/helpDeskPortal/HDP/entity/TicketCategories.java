package com.helpDeskPortal.HDP.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "TicketCategories")
public class TicketCategories {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;
	
	
	
	//One to many mapping
	//One ticket Categories have many sub categories
	@OneToMany(cascade= {CascadeType.ALL})
	@JoinColumn(name = "TicketCategories_id", referencedColumnName = "id")
	//@OnDelete(action = OnDeleteAction.CASCADE) 
	private List<TicketSubCategories> ticketSubCategeries;

	
	public  TicketCategories()
	{
		
	}
	
	public TicketCategories(String name) {
		super();
		this.name = name;
	}

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TicketSubCategories> getTicketSubCategeries() {
		return ticketSubCategeries;
	}

	public void setTicketSubCategeries(List<TicketSubCategories> ticketSubCategeries) {
		this.ticketSubCategeries = ticketSubCategeries;
	}
	
	//add convenience methods for bi-directional relationship
	
	public void add(TicketSubCategories tempTicketSubCategories)
	{
		if(ticketSubCategeries==null)
		{
			ticketSubCategeries=new ArrayList<>();
		}
		ticketSubCategeries.add(tempTicketSubCategories);
		
		
	}

	@Override
	public String toString() {
		return "TicketCategories [id=" + id + ", name=" + name + ", ticketSubCategeries=" + ticketSubCategeries + "]";
	}
	
	
}
