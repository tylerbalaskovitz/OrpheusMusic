package com.revature.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cart {
@Id
private long cart_id;
private long user_id;
private String created_time;
}
