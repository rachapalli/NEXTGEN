package com.nextgen.dto;

public class RegisterDTO {

	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private long country;
	private long state;
	private long city;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getCountry() {
		return country;
	}
	public void setCountry(long country) {
		this.country = country;
	}
	public long getState() {
		return state;
	}
	public void setState(long state) {
		this.state = state;
	}
	public long getCity() {
		return city;
	}
	public void setCity(long city) {
		this.city = city;
	}
	
	
	
}
