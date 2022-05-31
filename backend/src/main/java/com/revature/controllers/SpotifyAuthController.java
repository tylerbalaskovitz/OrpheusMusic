package com.revature.controllers;

import java.net.URI;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.SpotifyHttpManager;

@RestController
@RequestMapping("/spotifyAPI")
public class SpotifyAuthController {
	private static final URI redirectURI = SpotifyHttpManager.makeUri(null);
	private String code;
	
	private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
			.setClientId(SpotifyKeys.CLIENT_ID)
			.setClientSecret(SpotifyKeys.CLIENT_SECRET)
			.setRedirectUri(redirectURI)
			.build();
	
	
			

}
