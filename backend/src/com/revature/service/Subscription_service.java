package com.revature.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Subscription;
import com.revature.models.exception.SubNotFoundException;
import com.revature.repositories.subscription_repository;

@Service
public class Subscription_service {
private final subscription_repository subRepository;

@Autowired
	public Subscription_service(subscription_repository subRepository) {
		this.subRepository = subRepository;

	}
	public Subscription addSubscription (Subscription subscription) {
		return subRepository.save(subscription);
	}
	public List<Subscription> getSubs(){
		return StreamSupport
				.stream(subRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		
	}
	public Subscription getSubscriptionbyID(long id) {
		return subRepository.findById(id).orElseThrow(() -> new SubNotFoundException(id));
	}
	
	@Transactional
	public Subscription editSub(long id, Subscription subscription) {
		Subscription subToEdit = getSubscriptionbyID(id);
		
		return subToEdit;
		
	}
	public Subscription deleteSub(long Subid) {
		Subscription SubToRem = getSubscriptionbyID(Subid);
		subRepository.delete(SubToRem);
		return SubToRem;
	}

	}

