package com.helpDeskPortal.HDP.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "priority")
public class Priority {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column
	private String prioriryName;

	public Priority()
	{
		
	}
	
	public String getPrioriryName() {
		return prioriryName;
	}

	public void setPrioriryName(String prioriryName) {
		this.prioriryName = prioriryName;
	}

	@Override
	public String toString() {
		return "Priority [id=" + id + ", prioriryName=" + prioriryName + "]";
	}
	
	
}
