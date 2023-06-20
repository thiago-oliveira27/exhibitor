package com.poo.exhibitor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name="user_tb")
public class UserModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer user_id;
	@Size(min=3, max=20, message="Nome de usuário deve conter de 3 a 20 caracteres")
    private String username;
    @Email 
    private String email; 
    private String password;
    
    
    
    
	public UserModel() {
		
	}


	public UserModel(Integer user_id,
			@Size(min = 3, max = 20, message = "Nome de usuário deve conter de 3 a 20 caracteres") String username,
			@Email String email, String password) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.email = email;
		this.password = password;
	}


	public Integer getUser_id() {
		return user_id;
	}


	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
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

