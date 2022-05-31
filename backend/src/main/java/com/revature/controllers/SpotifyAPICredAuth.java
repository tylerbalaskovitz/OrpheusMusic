package com.revature.controllers;
import java.net.URI;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.SpotifyHttpManager;
import se.michaelthelin.spotify.model_objects.credentials.ClientCredentials;
import se.michaelthelin.spotify.requests.authorization.authorization_code.AuthorizationCodeUriRequest;
import se.michaelthelin.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;

@RestController
@RequestMapping("/spotifyAPI")
public class SpotifyAPICredAuth{
private static final URI redirectURI = SpotifyHttpManager.makeUri("http://localhost:8080/spotifyAPI/getcode");
	private String code = "";
	
	private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
			.setClientId("765e83cf5c3b469887372c61a7b63769")
			.setClientSecret("1b6eb7e7077d4c32996a4e1ef500150e")
			.setRedirectUri(redirectURI)
			.build();

	private static final ClientCredentialsRequest clientCredentialsRequest = spotifyApi.clientCredentials()
			.build();
	

	
@GetMapping("/token")
ResponseEntity<String> getCredentialToken(){
	 
		    try {
		      final CompletableFuture<ClientCredentials> clientCredentialsFuture = clientCredentialsRequest.executeAsync();

		      // Thread free to do other tasks...

		      // Example Only. Never block in production code.
		      final ClientCredentials clientCredentials = clientCredentialsFuture.join();

		      // Set access token for further "spotifyApi" object usage
		      spotifyApi.setAccessToken(clientCredentials.getAccessToken());
		      
		      System.out.println("Expires in: " + clientCredentials.getExpiresIn());
		      
		    } catch (CompletionException e) {
		      System.out.println("Error: " + e.getCause().getMessage());
		    } catch (CancellationException e) {
		      System.out.println("Async operation cancelled.");
		    }
		  
		    return new ResponseEntity<>(spotifyApi.getAccessToken(),HttpStatus.OK);
	
	

}
}