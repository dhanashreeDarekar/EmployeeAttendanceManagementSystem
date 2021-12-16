package com.miniproject.module.AttendanceManagementSystem.Entity;

import javax.persistence.CascadeType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;  

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.OneToOne;

@Entity
public class Login {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false , updatable = false)
	private int login_id ;
	private String username ;
	private String password;
	
	public Login(int login_id , String username , String password ) {
		this.username = username;
		this.password = password;
		this.login_id = login_id;
		
	}
	
	@Override  
	public void configure(HttpSecurity http) throws Exception {  
	    http  
	        .authorizeRequests()  
	        .anyRequest().authenticated()  
	        .and()  
	        .formLogin()  
	        .and()  
	        .httpBasic();  
	}

	public int getLogin_id() {
		return login_id;
	}

	public void setLogin_id(int login_id) {
		this.login_id = login_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
    @OneToOne(mappedBy = "Login", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Employee emp;

}
