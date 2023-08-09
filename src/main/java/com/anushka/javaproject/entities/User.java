package com.anushka.javaproject.entities;

import java.security.KeyStore.PrivateKeyEntry;

import javax.management.loading.PrivateClassLoader;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length=100)
	private int uId;
	@Column(length=500)
	private String uName;
	private String uEmail;
	private String uPassword;
	private int uPhone;
	@Column(length=1000)
	private String uAddress;
	private String uType;
	
	public User() {
		super();
	}
	
	public User(int uId, String uName, String uEmail, String uPassword, int uPhone, String uAddress, String uType) {
		super();
		this.uId = uId;
		this.uName = uName;
		this.uEmail = uEmail;
		this.uPassword = uPassword;
		this.uPhone = uPhone;
		this.uAddress = uAddress;
		this.uType = uType;
	}

	public User(String uName, String uEmail, String uPassword, int uPhone, String uAddress, String uType) {
		super();
		this.uName = uName;
		this.uEmail = uEmail;
		this.uPassword = uPassword;
		this.uPhone = uPhone;
		this.uAddress = uAddress;
		this.uType = uType;
	}

	public int getuId() {
		return uId;
	}
	
	public void setuId(int uId) {
		this.uId = uId;
	}
	
	public String getuName() {
		return uName;
	}
	
	public void setuName(String uName) {
		this.uName = uName;
	}
	
	public String getuEmail() {
		return uEmail;
	}
	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}
	
	public String getuPassword() {
		return uPassword;
	}
	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}
	
	public String getuAddress() {
		return uAddress;
	}
	
	public void setuAddress(String uAddress) {
		this.uAddress = uAddress;
	}

	public int getuPhone() {
		return uPhone;
	}

	public void setuPhone(int uPhone) {
		this.uPhone = uPhone;
	}
	

	public String getuType() {
		return uType;
	}

	public void setuType(String uType) {
		this.uType = uType;
	}

	@Override
	public String toString() {
		return "User [uId=" + uId + ", uName=" + uName + ", uEmail=" + uEmail + ", uPassword=" + uPassword + ", uPhone="
				+ uPhone + ", uAddress=" + uAddress + ", uType=" + uType + "]";
	}

	
	
}
