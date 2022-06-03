package com.revature.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Playlist {
@Id
public long playlist_id;
private String title;


public long getPlaylist_id() {
	return playlist_id;
}

public void setPlaylist_id(long playlist_id) {
	this.playlist_id = playlist_id;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public orpheus_user getUser() {
	return user;
}

public void setUser(orpheus_user user) {
	this.user = user;
}

@ManyToMany
List<Track> playlistTracks = new ArrayList<>();



@JoinTable(
  name = "playlist_tracks", 
  joinColumns = @JoinColumn(name = "playlist_id"), 
  inverseJoinColumns = @JoinColumn(name = "track_id"))



@ManyToOne()
@JoinColumn(name="user_id", referencedColumnName = "user_id", insertable = false, updatable = false)    
private orpheus_user user;
