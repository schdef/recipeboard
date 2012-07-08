package de.schdef.slashcoding.recipeboard.dao;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import de.schdef.slashcoding.recipeboard.domain.Recipe;
import de.schdef.slashcoding.recipeboard.presentation.web.ThirdPartyCredential;

public class ChefkochDao implements RecipeDao<Recipe> {

	private final ThirdPartyCredential thirdPartyCredential;

	public ChefkochDao(ThirdPartyCredential thirdPartyCredential) {
		this.thirdPartyCredential = thirdPartyCredential;
	}

	@Override
	public List<Recipe> findAll() {
		ChefkochLogin login = new ChefkochLogin();
		List<Recipe> result = new ArrayList<Recipe>();
		try {
			Set<URL> myCookbook = login.getMyCookbook(thirdPartyCredential.getUsername(), thirdPartyCredential.getPassword());
			ChefkochGrabber2 grabber = new ChefkochGrabber2();
			for (URL url : myCookbook) {
				Recipe recipe;
				try {
					recipe = grabber.grab(url);
					result.add(recipe);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result; 
	}

	@Override
	public Recipe getRandom() {
		// TODO Auto-generated method stub
		return null;
	}

}
