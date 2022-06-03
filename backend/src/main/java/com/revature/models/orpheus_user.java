package com.revature.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.revature.models.dto.Orpheus_User_DTO;



// This model class is for the PLAYLISTS and TRACKS side of being a user, and our registration and login
// functions can also post to it. i named the fields for ORM in SQL convention 
// when I did it with my last REST controller more loosely it was a pain



// generates a table and object for spring API called: orpheus_user
@Entity
public class orpheus_user implements UserDetails {
	
	//it is generally RESTFUL convention to use long for the pk. we won't need it, but it's just good
	// practice to do the right thing. The below lines set it as serial in h2 DB
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long user_id;
	
	
	// your standard demographic fields ready to be generated into an h2 instance
	
	private String first_name;
	private String last_name;
	private String email;
	private String username;
	private String password;
	private String phone;
	
	@ManyToOne()
	@JoinColumn(name="subscription_id", referencedColumnName = "subscription_id")	
	Subscription subscription;
	
	
	@OneToMany	
	@JoinTable(name="USER_PLAYLISTS",joinColumns = @JoinColumn(name="playlist_id"),
			inverseJoinColumns = @JoinColumn( name="user_id"))
	private List<Playlist> userPlaylists  = new ArrayList<>();
	
	
	
	
	
	
	
	public orpheus_user() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "orpheus_user [user_id=" + user_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", email=" + email + ", username=" + username + ", password=" + password + ", phone=" + phone + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(email, first_name, last_name, password, phone, user_id, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		orpheus_user other = (orpheus_user) obj;
		return Objects.equals(email, other.email) && Objects.equals(first_name, other.first_name)
				&& Objects.equals(last_name, other.last_name) && Objects.equals(password, other.password)
				&& Objects.equals(phone, other.phone) && user_id == other.user_id
				&& Objects.equals(username, other.username);
	}
	public orpheus_user(long user_id, String first_name, String last_name, String email, String username,
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
		
	public static orpheus_user from(Orpheus_User_DTO userDTO) {
			
			orpheus_user user = new orpheus_user();
			user.setUser_id(userDTO.getUser_id());
			user.setFirst_name(userDTO.getFirst_name());
			user.setLast_name(userDTO.getLast_name());
			user.setUsername(userDTO.getUsername());
			user.setPassword(new BCryptPasswordEncoder().encode(userDTO.getPassword()));
			user.setEmail(userDTO.getEmail());
			return user;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
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
