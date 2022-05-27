package com.revature.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.orpheus_user;
import com.revature.repositories.orpheus_user_repository;


@Service
public class Orpheus_user_service {
private final orpheus_user_repository userRepository;
				
	@Autowired
	public Orpheus_user_service(orpheus_user_repository userRepository){
	this.userRepository = userRepository;
	
}
	
	public orpheus_user addUser(orpheus_user user) {
		return userRepository.save(user);
	}
	
	public List<orpheus_user> getUsers(){
		return StreamSupport
				.stream(userRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}
	
	// We will talk in the morning about this here custom exception that i'm pushing
	// but we got dem CRUD operations for users in a Playlist side sense
	
	 /*public orpheus_user getUserbyID(long id) {
		return userRepository.findById(id).orElseThrow(()-> new UserNotFoundException(id));
	}
	*/
	
	/*
	public orpheus_user deleteUser(long id) {
		orpheus_user user = getUserbyID(id);
		userRepository.delete(user);
		return user;
		*/
	}
	

