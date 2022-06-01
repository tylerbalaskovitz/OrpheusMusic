package com.revature.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.revature.models.orpheus_user;
import com.revature.models.dto.Orpheus_User_DTO;
import com.revature.service.Orpheus_user_service;



// this controller will NOT be called by dbms ORM -- i have used traditional Java Convention for them
// this serves as the gateway to perform API Operations on users on the Playlist side of the API
// our login function can either open another, or .then an additional request to these handlers

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users/")
public class Orpheus_User {

	
		private final Orpheus_user_service userService;
		
	@Autowired
	Orpheus_User(Orpheus_user_service userService){
		this.userService = userService;
		
	}
	@PostMapping
	//this is for spring security 
	//@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')") 
public ResponseEntity<Orpheus_User_DTO> addUser(@RequestBody final Orpheus_User_DTO userDTO){
		orpheus_user user = userService.addUser(orpheus_user.from(userDTO));
		return new ResponseEntity<>(Orpheus_User_DTO.from(user),HttpStatus.OK);


	}

@GetMapping
public ResponseEntity<List<Orpheus_User_DTO>> getUsers(){
	List<orpheus_user> returnedList = userService.getUsers();
	List<Orpheus_User_DTO> RespList = returnedList.stream().map(Orpheus_User_DTO::from).collect(Collectors.toList());
	return new ResponseEntity<List<Orpheus_User_DTO>>(RespList,HttpStatus.OK);

}
@GetMapping(value= "{id}")
//@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')") 

public ResponseEntity<Orpheus_User_DTO> getUser(@PathVariable final Long id) {
orpheus_user user = userService.getUserbyID(id);
return new ResponseEntity<>(Orpheus_User_DTO.from(user),HttpStatus.OK);
}



	}
	

