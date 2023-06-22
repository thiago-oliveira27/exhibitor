package com.poo.exhibitor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="user_tb")
@Table(name="user_tb")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long user_id;
	
	@Column(name = "username", nullable = false)
    private String username;
	
	@Column(name = "phoneNumber", nullable = false)
    private String phoneNumber; 
	
	@Column(name = "password", nullable = false)
    private String password;

	public UserModel(Long user_id, String username, String phoneNumber, String password) {		
		this.user_id = user_id;
		this.username = username;
		this.phoneNumber = phoneNumber;
		this.password = password;
	}
	
	public UserModel() {
		
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}

