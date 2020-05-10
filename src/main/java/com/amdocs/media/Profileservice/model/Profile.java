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
	public String userName;

	@Column(name = "address")
	public String address;

	@Column(name = "phonenumber")
	public long phonenumber;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
		return "Profile [userName=" + userName + ", address=" + address + ", phonenumber=" + phonenumber + "]";
	}

}
