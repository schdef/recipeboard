package de.schdef.slashcoding.recipeboard.presentation.web;

public class ThirdPartyCredential {

	private final String username;
	private final String password;

	public ThirdPartyCredential(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}
