package com.revature.controllers;

import java.net.URI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.SpotifyHttpManager;
import se.michaelthelin.spotify.requests.authorization.authorization_code.AuthorizationCodeUriRequest;

@RestController
@RequestMapping("/spotifyapi")
public class SpotifyAuthController {
	private static final URI redirectURI = SpotifyHttpManager.makeUri(null);
	private String code;
	
	private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
			.setClientId(SpotifyKeys.CLIENT_ID)
			.setClientSecret(SpotifyKeys.CLIENT_SECRET)
			.setRedirectUri(redirectURI)
			.build();
	
	
			
@GetMapping("login")
public String SpotifyAuthLogin() {
	AuthorizationCodeUriRequest authorizationCodeUriRequest = spotifyApi.authorizationCodeUri()
			.scope("user-read-private, user-read-email, user-top-read")
			.show_dialog(true)
			
			.build();
	return null;
}

}

