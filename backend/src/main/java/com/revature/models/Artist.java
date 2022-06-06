package com.revature.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Artist {

@ManyToMany(mappedBy = "artist_id")
Set<Track> track_id;

public Set<Track> getTrack_id() {
	return track_id;
}

public void setTrack_id(Set<Track> track_id) {
	this.track_id = track_id;
}

public long getArtist_id() {
	return artist_id;
}

public void setArtist_id(long artist_id) {
	this.artist_id = artist_id;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

@Id
@GeneratedValue
private long artist_id;

private String title;

}
