package com.revature.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.revature.models.orpheus_user;
import com.revature.repositories.orpheus_user_repository;

@Service
public class UDS implements UserDetailsService {
	
	@Autowired
	private orpheus_user_repository UserDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		//calls UserRepository "findByUsername()" method
		orpheus_user user = UserDao.findByUsername(username);
		if(user != null) {
			return user;
		}else {
			throw new UsernameNotFoundException(username);
		}
		
		
	}
}
