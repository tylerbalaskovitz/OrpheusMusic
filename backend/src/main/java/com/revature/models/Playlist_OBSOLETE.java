package com.revature.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Playlist_OBSOLETE {
@Id
@GeneratedValue
public long playlistId;
private String title;



public Playlist_OBSOLETE() {
	super();
	// TODO Auto-generated constructor stub
}

public Playlist_OBSOLETE(long playlistId, String title, List<Track> playlistTracks, orpheus_user user) {
	super();
	this.playlistId = playlistId;
	this.title = title;
	this.playlistTracks = playlistTracks;
	this.user = user;
}

public long getPlaylist_id() {
	return playlistId;
}

public void setPlaylist_id(long playlist_id) {
	this.playlistId = playlist_id;
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



public List<Track> getPlaylistTracks() {
	return playlistTracks;
}

public void setPlaylistTracks(List<Track> playlistTracks) {
	this.playlistTracks = playlistTracks;
}

public void addPlaylistTracks(Track track) {
	this.playlistTracks.add(track);
	track.getPlaylists().add(this);
	
}
public void removePlayListTrack(long track_id) {
	Track track = this.playlistTracks.stream().filter(t -> t.getId() == track_id).findFirst().orElse(null);
	if (track != null) {
		this.playlistTracks.remove(track);
		track.getPlaylists().remove(this);
	}
}


@ManyToMany(fetch = FetchType.LAZY,
cascade = {
    CascadeType.PERSIST,
    CascadeType.MERGE
})
@JoinTable(
  name = "playlist_tracks", 
  joinColumns = @JoinColumn(name = "playlist_id"), 
  inverseJoinColumns = @JoinColumn(name = "track_id"))



@ManyToOne()
@JoinColumn(name="user_id", referencedColumnName = "user_id", insertable = false, updatable = false)    
private orpheus_user user;
}
