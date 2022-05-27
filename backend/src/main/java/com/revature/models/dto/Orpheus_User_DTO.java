package com.revature.models.dto;

import java.util.stream.Collectors;

import com.revature.models.orpheus_user;

public class Orpheus_User_DTO {
public long user_id;
	
	
	// your standard demographic fields ready to be generated into an h2 instance
	
	private String first_name;
	private String last_name;
	private String email;
	private String username;
	private String password;
	private String phone;
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Orpheus_User_DTO(long user_id, String first_name, String last_name, String email, String username,
			String password, String phone) {
		super();
		this.user_id = user_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.username = username;
		this.password = password;
		this.phone = phone;
	}
	public Orpheus_User_DTO() {
		super();
	}
	
	public static Orpheus_User_DTO from(orpheus_user user) {
		Orpheus_User_DTO userDTO = new Orpheus_User_DTO();
		userDTO.setUser_id(user.getUser_id());
		userDTO.setUsername(user.getUsername());
		userDTO.setFirst_name(user.getFirst_name());
		userDTO.setLast_name(user.getLast_name());
		userDTO.setPassword(user.getPassword());
		userDTO.setEmail(user.getEmail());
		
		return userDTO;
	}

}
