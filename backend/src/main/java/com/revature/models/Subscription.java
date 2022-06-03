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

private String subscription_desc;
private double price;
}
