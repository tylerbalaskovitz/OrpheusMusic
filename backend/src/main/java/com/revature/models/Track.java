package com.revature.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.revature.models.Playlist_OBSOLETE;

@Entity
public class Track {
	private String track_title;
	@Id
	private long trackId;

	public Track() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Track(String title, long id, Set<Artist> artist_id) {
		super();
		this.track_title = title;
		this.trackId = id;
		this.artist_id = artist_id;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })

	@JsonIgnore
	private Set<Playlist_OBSOLETE> playlists = new HashSet<>();
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })

	@JoinTable(name = "track_artists", joinColumns = @JoinColumn(name = "artist_id"), inverseJoinColumns = @JoinColumn(name = "track_id"))
	private Set<Artist> artist_id;

	public String getTrack_title() {
		return track_title;
	}

	public void setTrack_title(String track_title) {
		this.track_title = track_title;
	}

	public long getTrack_id() {
		return trackId;
	}

	public void setTrack_id(long track_id) {
		this.trackId = track_id;
	}

	public Set<Playlist_OBSOLETE> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(Set<Playlist_OBSOLETE> playlists) {
		this.playlists = playlists;
	}

	public String getTitle() {
		return track_title;
	}

	public void setTitle(String title) {
		this.track_title = title;
	}

	public long getId() {
		return trackId;
	}

	public void setId(long id) {
		this.trackId = id;
	}

	public Set<Artist> getArtist_id() {
		return artist_id;
	}

	public void setArtist_id(Set<Artist> artist_id) {
		this.artist_id = artist_id;
	}


}
