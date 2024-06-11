package com.cts.project.flightReservation.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@SequenceGenerator(name="admin_id" , sequenceName="admin_id" , initialValue= 10001)
@Table(name="admin")
public class Admin {
	@Id
	@GeneratedValue(generator = "admin_id")
	private int id;
	
	@Size(min = 2,message="UserName must have atleast of 2 letters")
	@Column(name="username" ,unique = true)
	private String userName;
	
	@Email(message = "Email is not valid")
	private String email;
	

	private String password;
	
	protected Admin() {
		
	}

	public Admin(String userName, String email, String password) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", userName=" + userName + ", email=" + email + ", password=" + password + "]";
	}
	
}
