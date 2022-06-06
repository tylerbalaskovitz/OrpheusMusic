package com.revature.models.dto;

import java.util.Set;

import com.revature.models.Artist;
import com.revature.models.Track;

public class TrackDTO {
	private String title;
	private long track_id;
	private Set<Artist> artist_id;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public long getTrack_id() {
		return track_id;
	}
	public void setTrack_id(long track_id) {
		this.track_id = track_id;
	}
	public Set<Artist> getArtist_id() {
		return artist_id;
	}
	public void setArtist_id(Set<Artist> artist_id) {
		this.artist_id = artist_id;
	}
	public TrackDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TrackDTO(String title, long track_id, Set<Artist> artist_id) {
		super();
		this.title = title;
		this.track_id = track_id;
		this.artist_id = artist_id;
	}
public static TrackDTO from(Track track) {
	TrackDTO trackDTO = new TrackDTO();
	trackDTO.setTitle(track.getTitle());
	trackDTO.setArtist_id(track.getArtist_id());
	trackDTO.setTrack_id(track.getId());
	return trackDTO;
}

}
