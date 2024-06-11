package com.cts.project.flightReservation.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="passenger")
@SequenceGenerator(name="id" , sequenceName = "id" , initialValue = 6)
public class PassengerDetails implements UserDetails{
	
	@Id
	@GeneratedValue(generator = "id")
	private int id;
	
	@Column(unique = true)
	private String email;
	
	@Column(name="user_name")
	private String userName;
	
	@JsonProperty(access=JsonProperty.Access.WRITE_ONLY)  //This line is to Write the Password only, but not to Show it on Front End.
	private String password;
	
	private String address;
	
	@Past
	private LocalDate birthDate;
	
	private int age;
	
	private String gender;
	
	@Column(name="mobile_no")
	private long mobileNo;
	
	@JsonIgnore
	@OneToMany(mappedBy = "passenger", cascade = CascadeType.ALL)
	private List<Booking> booking = new ArrayList<>();
	
	
	private String role;
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public PassengerDetails() {
		
	}
	
	public PassengerDetails(int id,String email, String userName, String password, String address, int age,
			String gender,long mobileNo) {
		super();
		this.id=id;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.address = address;
		this.age = age;
		this.mobileNo=mobileNo;
		this.gender = gender;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id=id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public List<Booking> getBooking() {
		return booking;
	}

	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}

	@Override
	public String toString() {
		return "PassengerDetails [id=" + id +", email=" + email + ", userName=" + userName
				+ ", password=" + password + ", address=" + address +", mobileNo="+ mobileNo +", age=" + age + ", gender=" + gender + "]";
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return List.of(new SimpleGrantedAuthority("USER"));
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
