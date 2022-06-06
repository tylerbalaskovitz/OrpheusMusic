package com.revature.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cart {
@Id
private long cart_id;
private long user_id;
private String created_time;

@ManyToOne()
@JoinColumn(name="subscription_id", referencedColumnName = "subscription_id", insertable = false, updatable = false)
private Subscription subscription;
public Subscription getSubscription() {
	return subscription;
}
public void setSubscription(Subscription subscription) {
	this.subscription = subscription;
}
public long getCart_id() {
	return cart_id;
}
public void setCart_id(long cart_id) {
	this.cart_id = cart_id;
}
public long getUser_id() {
	return user_id;
}
public void setUser_id(long user_id) {
	this.user_id = user_id;
}
public String getCreated_time() {
	return created_time;
}
public void setCreated_time(String created_time) {
	this.created_time = created_time;
}
public Cart() {
	super();
	// TODO Auto-generated constructor stub
}
public Cart(long cart_id, long user_id, String created_time) {
	super();
	this.cart_id = cart_id;
	this.user_id = user_id;
	this.created_time = created_time;
}


}
