package com.revature.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Playlist {
@Id
public long user_id;
private String name;


@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "user_id")

orpheus_user user;
}
