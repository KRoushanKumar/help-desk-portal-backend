package com.helpDeskPortal.HDP.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="TicketSubCategories")
public class TicketSubCategories {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;
	
	//many to one join TicketCategories and subTicketCategories
	//@ManyToOne(cascade= {CascadeType.ALL})
	//@JoinColumn(name="TicketCategories_id")	
	//private TicketCategories ticketCategories;
	
	public TicketSubCategories()
	{
		
	}

	
	
	public TicketSubCategories(String name) {
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

//	public TicketCategories getTicketCategories() {
//		return ticketCategories;
//	}
//
//	public void setTicketCategories(TicketCategories ticketCategories) {
//		this.ticketCategories = ticketCategories;
//	}



	@Override
	public String toString() {
		return "TicketSubCategories [id=" + id + ", name=" + name + "]";
	}


	
}
