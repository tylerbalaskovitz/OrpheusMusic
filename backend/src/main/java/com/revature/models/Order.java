package com.revature.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Order {
@Id
@GeneratedValue
private long order_id;
@ManyToOne()
@JoinColumn(name="order_subscription", referencedColumnName = "subscription_id")    
private Subscription subscription;
}
