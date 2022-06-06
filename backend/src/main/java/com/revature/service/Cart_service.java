package com.revature.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.models.Cart;
import com.revature.models.Subscription;
import com.revature.models.exception.UserNotFoundException;
import com.revature.repositories.cart_repository;


public class Cart_service {
	private final Cart_service CartService;
	private final cart_repository cartRepository;
	private final Subscription_service subService;
	private final Orpheus_user_service userService;
	
	@Autowired
	public Cart_service(cart_repository cartRepository, Cart_service CartService,Subscription_service subService,Orpheus_user_service userService){
	this.cartRepository = cartRepository;
	this.CartService = CartService;
	this.subService = subService;
	this.userService = userService;
}
	
	public Cart addCart(Cart cart) {
		return cartRepository.save(cart);
	}
	
	public List<Cart> getCarts(){
		return StreamSupport
				.stream(cartRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}
	
	public Cart getCartbyID(long id) {
		return cartRepository.findById(id).orElseThrow(()-> new UserNotFoundException(id));
	}
	public Cart deleteCart(long id) {
		Cart cart = getCartbyID(id);
		cartRepository.delete(cart);
		return cart;
	}
//	@Transactional
//	public Cart addSubscriptionToCart(long cart_id,long sub_id) {
//		Cart cart = getCartbyID(cart_id);
//		Subscription sub = subService.getSubscriptionbyID(sub_id);
//		
//		
//		sub.setUse));
//		return cart;
//	}
//	@Transactional
//	public RevNoteUser deleteNote(long user_id, long note_id) {
//		RevNoteUser user = getUserbyID(user_id);
//		Note note = NoteService.getNotebyID(note_id);
//		user.removeNote(note);
//		return user;
//		
//		}
}



