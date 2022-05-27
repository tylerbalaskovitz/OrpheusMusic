package com.revature.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.revature.models.orpheus_user;

@Repository
public interface orpheus_user_repository extends CrudRepository<orpheus_user,Long>{
	public orpheus_user findByUsername(String username);
}
