package com.revature.models.dto;

import com.revature.models.Cart;
import com.revature.models.Subscription;

public class CartDTO {
	private long cart_id;
	private long user_id;
	private String created_time;
	private Subscription subscription;
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
	public Subscription getSubscription() {
		return subscription;
	}
	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}
	public CartDTO(long cart_id, long user_id, String created_time, Subscription subscription) {
		super();
		this.cart_id = cart_id;
		this.user_id = user_id;
		this.created_time = created_time;
		this.subscription = subscription;
	}
	public CartDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static CartDTO from(Cart cart) {
		CartDTO cartDTO = new CartDTO();
		cartDTO.setCart_id(cart.getCart_id());
		cartDTO.setUser_id(cart.getUser_id());
		cartDTO.setCreated_time(cart.getCreated_time());
		cartDTO.setSubscription(cart.getSubscription());
		return cartDTO;
	}

}
