package com.revature.models.dto;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Playlist;
import com.revature.models.Track;
import com.revature.models.orpheus_user;

public class PlaylistDTO {
private long playlist_id;
private String title;
private orpheus_user user;
List<Track> playlistTracks = new ArrayList<>();
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
public List<Track> getPlaylistTracks() {
	return playlistTracks;
}
public void setPlaylistTracks(List<Track> playlistTracks) {
	this.playlistTracks = playlistTracks;
}
public PlaylistDTO(long playlist_id, String title, orpheus_user user, List<Track> playlistTracks) {
	super();
	this.playlist_id = playlist_id;
	this.title = title;
	this.user = user;
	this.playlistTracks = playlistTracks;
}
public PlaylistDTO() {
	super();
	// TODO Auto-generated constructor stub
}
public static PlaylistDTO from(Playlist playlist) {
	PlaylistDTO PlaylistDTO = new PlaylistDTO();
	PlaylistDTO.setPlaylist_id(playlist.getPlaylist_id());
	PlaylistDTO.setPlaylistTracks(playlist.getPlaylistTracks());
	PlaylistDTO.setTitle(playlist.getTitle());
	PlaylistDTO.setUser(playlist.getUser());
	
	return PlaylistDTO;
}
	
	
}
