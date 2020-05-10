package com.amdocs.media.Profileservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "profile")
public class Profile {

	@Id
	@Column(name = "username", nullable = false)
	public String username;

	@Column(name = "address")
	public String address;

	@Column(name = "phonenumber")
	public long phonenumber;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}

	@Override
	public String toString() {
		return "Profile [username=" + username + ", address=" + address + ", phonenumber=" + phonenumber + "]";
	}

}
