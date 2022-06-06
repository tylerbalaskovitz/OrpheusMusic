package com.revature.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.revature.models.Playlist;
import com.revature.repositories.playlist_repository;

@RestController
@RequestMapping("/musicapi")
@CrossOrigin(origins = "*", maxAge = 3600)
public class Playlist_Controller_OBSOLETE {
@Autowired
playlist_repository PlaylistRepository;
@GetMapping("/playlists")
public ResponseEntity<List<Playlist>> getPlaylists(@RequestParam(required = false) String title){
	List<Playlist> allPlaylists = new ArrayList<>();
	if(title == null) PlaylistRepository.findAll().forEach(allPlaylists::add);
	else {
		PlaylistRepository.findByTitleContaining(title).forEach(allPlaylists::add);
	}
	if(allPlaylists.isEmpty()) {
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	return new ResponseEntity<>(allPlaylists,HttpStatus.OK);
}
@PostMapping("/playlists")
public ResponseEntity<Playlist> createPlaylist(@RequestBody Playlist playlist){
	Playlist _playlist = PlaylistRepository.save(new Playlist(playlist.getPlaylist_id(),playlist.getTitle(), null, null));
return new ResponseEntity<>(_playlist,HttpStatus.CREATED);

}

}