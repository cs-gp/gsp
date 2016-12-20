package com.himalayanGeeks.carRental.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	@NotEmpty
	@Size(min=2, max=50)
	public String firstName;
	@NotEmpty
	@Size(min=2, max=50)
	public String lastName;
	@NotEmpty
	@Email
	public String email;
	@NotEmpty
	@Lob 
	@Column(name="password", length=5000)
	public String password;
	public String userName;
	@OneToOne(mappedBy="user", cascade={CascadeType.ALL})
	private Role role;
	@Valid
	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "addressidFk")
    private Address address;
	
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "userIdFk")
    private List<Reservation> reservation;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}



	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public List<Reservation> getReservation() {
		return reservation;
	}


	public void setReservation(List<Reservation> reservation) {
		this.reservation = reservation;
	}


	
	
	
	
	
	
	
}
