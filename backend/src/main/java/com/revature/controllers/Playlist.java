package com.revature.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/*
@RestController
public class Playlist {
	@PostMapping
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')") 
	public ResponseEntity<PlaylistDTO> addNote(@RequestBody final PlaylistDTO noteDTO){
		Note note = NoteService.addNote(Note.from(noteDTO));
		return new ResponseEntity<>(NoteDTO.from(note),HttpStatus.OK);
		
	}
}
*/