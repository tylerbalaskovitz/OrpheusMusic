package com.revature.models;



import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Track {
	private String title;
	@Id
	private String id;
	
	
	@ManyToMany
	@JoinTable(
	  name = "track_artists", 
	  joinColumns = @JoinColumn(name = "artist_id"), 
	  inverseJoinColumns = @JoinColumn(name = "track_id"))

	private Set<Artist> artist_id;


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Set<Artist> getArtist_id() {
		return artist_id;
	}


	public void setArtist_id(Set<Artist> artist_id) {
		this.artist_id = artist_id;
	}


}
