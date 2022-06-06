package com.revature.models.dto;

import java.util.Set;

import com.revature.models.Artist;
import com.revature.models.Track;

public class ArtistDTO {
private long artist_id;
private long title;
private Set<Track> track_id;
public ArtistDTO(long artist_id, long title, Set<Track> track_id) {
	super();
	this.artist_id = artist_id;
	this.title = title;
	this.track_id = track_id;
}
public long getArtist_id() {
	return artist_id;
}
public void setArtist_id(long artist_id) {
	this.artist_id = artist_id;
}
public long getTitle() {
	return title;
}
public void setTitle(long title) {
	this.title = title;
}
public Set<Track> getTrack_id() {
	return track_id;
}
public void setTrack_id(Set<Track> track_id) {
	this.track_id = track_id;
}
public ArtistDTO() {
	super();
	// TODO Auto-generated constructor stub
}
public static ArtistDTO from(Artist artist) {
	ArtistDTO artistDTO = new ArtistDTO();
	
	return artistDTO;
}

}
