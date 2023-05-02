package com.helpDeskPortal.HDP.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TicketCategories")
public class TicketCategories {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="ticketCategories",cascade= {CascadeType.ALL})
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
