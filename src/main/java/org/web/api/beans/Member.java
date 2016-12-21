package org.web.api.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
/**
 * This class represents the Member
 * @author Anurag Upadhyay 
 */
@Entity
@Table(name = "MEMBER")
public class Member implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long userId;
	private long accountType = 0;
	private String firstName;
	private String lastName;
	private String middleName;
	private String email;
	private String password;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getAccountType() {
		return accountType;
	}
	public void setAccountType(long accountType) {
		this.accountType = accountType;
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
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
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
	
	
	

}
