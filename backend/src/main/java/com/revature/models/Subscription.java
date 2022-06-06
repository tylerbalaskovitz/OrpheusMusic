package com.revature.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Subscription {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long subscription_id;
@OneToMany	
@JoinTable(name="USER_SUBSCRIPTIONS",joinColumns = @JoinColumn(name="user_id"),
		inverseJoinColumns = @JoinColumn( name="subscription_id"))
List<orpheus_user> users;


public Subscription(long subscription_id, List<orpheus_user> users, String subscription_desc, double price) {
	super();
	this.subscription_id = subscription_id;
	this.users = users;
	this.subscription_desc = subscription_desc;
	this.price = price;
}
private String subscription_desc;
private double price;
public long getSubscription_id() {
	return subscription_id;
}
public void setSubscription_id(long subscription_id) {
	this.subscription_id = subscription_id;
}
public List<orpheus_user> getUsers() {
	return users;
}
public void setUsers(List<orpheus_user> users) {
	this.users = users;
}
public String getSubscription_desc() {
	return subscription_desc;
}
public void setSubscription_desc(String subscription_desc) {
	this.subscription_desc = subscription_desc;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public Subscription() {
	super();
	// TODO Auto-generated constructor stub
}
}
