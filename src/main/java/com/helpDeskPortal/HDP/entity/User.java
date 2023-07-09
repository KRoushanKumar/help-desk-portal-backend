package com.helpDeskPortal.HDP.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	
	@Column(name = "username" , unique=true)
	private String userName;

	@Column(name = "password")
	private String password;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade= {CascadeType.DETACH,
		 CascadeType.MERGE,
		 CascadeType.PERSIST,
		 CascadeType.REFRESH})
	@JoinTable(name = "users_roles", 
	joinColumns = @JoinColumn(name = "user_id"), 
	inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Collection<Role> roles;
	
	@Column(name = "admin_id")
	private int adminId;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "admin_id" , referencedColumnName = "id")
	private List<TicketCategories> ticketCategories;
	

	public User()
	{
		
	}
	public User(Integer id, String userName, String password, 
			String firstName, String lastName, String email,int adminId) 
	{
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.adminId = adminId;
		
	}
	
	
	
	public User(String userName, String password, String firstName, String lastName, String email,
			Collection<Role> roles, int adminId, List<TicketCategories> ticketCategories) {
		super();
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.roles = roles;
		this.adminId = adminId;
		this.ticketCategories = ticketCategories;
	}
	public User(String userName, String password, String firstName, String lastName, String email,
			Collection<Role> roles) {
		super();
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.roles = roles;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	
	public Collection<Role> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	
	
	
	public List<TicketCategories> getTicketCategories() {
		return ticketCategories;
	}
	public void setTicketCategories(List<TicketCategories> ticketCategories) {
		this.ticketCategories = ticketCategories;
	}
	
	public void addTickCtgry(TicketCategories tempticCtgry)
	{
		if(ticketCategories==null)
		{
			ticketCategories = new ArrayList<>();
		}
		else
			ticketCategories.add(tempticCtgry);
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + "]";
	}
	
	
	
	
}
