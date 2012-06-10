package de.schdef.slashcoding.recipeboard.dao;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.jaxen.JaxenException;

import de.schdef.slashcoding.recipeboard.domain.Recipe;
import de.schdef.slashcoding.recipeboard.util.UserUtil;

public class ChefkochDao implements RecipeDao<Recipe> {

	@Override
	public List<Recipe> findAll() {
		ChefkochLogin login = new ChefkochLogin();
		List<Recipe> result = new ArrayList<Recipe>();
		try {
			String username = UserUtil.getProperties().getProperty("username");
			String password = UserUtil.getProperties().getProperty("password");
			Set<URL> myCookbook = login.getMyCookbook(username, password);
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
			
		} catch (JaxenException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
