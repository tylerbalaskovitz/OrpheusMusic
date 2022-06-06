package com.revature.models.dto;

import java.util.List;

import com.revature.models.Subscription;
import com.revature.models.orpheus_user;

public class SubscriptionDTO {
private long subscription_id;
private String subscription_desc;
private List<orpheus_user> users;
public long getSubscription_id() {
	return subscription_id;
}
public void setSubscription_id(long subscription_id) {
	this.subscription_id = subscription_id;
}
public String getSubscription_desc() {
	return subscription_desc;
}
public void setSubscription_desc(String subscriptiondesc) {
	this.subscription_desc = subscription_desc;
}
public List<orpheus_user> getUsers() {
	return users;
}
public void setUsers(List<orpheus_user> users) {
	this.users = users;
}
public SubscriptionDTO(long subscription_id, String subscription_desc, List<orpheus_user> users) {
	super();
	this.subscription_id = subscription_id;
	this.subscription_desc = subscription_desc;
	this.users = users;
}
public SubscriptionDTO() {
	super();
	// TODO Auto-generated constructor stub
}



public static SubscriptionDTO from(Subscription subscription) {
SubscriptionDTO SubDTO = new SubscriptionDTO();
SubDTO.setSubscription_desc(subscription.getSubscription_desc());
SubDTO.setSubscription_id(subscription.getSubscription_id());
SubDTO.setUsers(subscription.getUsers());
return SubDTO;
}
}

