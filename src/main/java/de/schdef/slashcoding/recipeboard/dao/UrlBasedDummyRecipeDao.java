package de.schdef.slashcoding.recipeboard.dao;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import de.schdef.slashcoding.recipeboard.domain.Recipe;

public class UrlBasedDummyRecipeDao implements RecipeDao<Recipe> {

	private List<URL> urlRecipeList = new ArrayList<URL>();
	
	public UrlBasedDummyRecipeDao() throws MalformedURLException {
		urlRecipeList.add(new URL("http://www.chefkoch.de/rezepte/1045401209466865/Afrikanische-Erdnuss-Lauch-Suppe.html"));
		urlRecipeList.add(new URL("http://www.chefkoch.de/rezepte/1205621226313744/Amerikanische-Pancakes.html"));
		urlRecipeList.add(new URL("http://www.chefkoch.de/rezepte/1167071222777296/Chili-con-Carne.html"));	
	}
	
	public List<Recipe> findAll() {
		ChefkochGrabber2 grabber = new ChefkochGrabber2();
		List<Recipe> result = new ArrayList<Recipe>();
		for (URL url : urlRecipeList) {
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
		return result;
	}

	public Recipe getRandom() {
		
		URL url = this.urlRecipeList.get(new Random().nextInt(this.urlRecipeList.size()));
		ChefkochGrabber2 grabber = new ChefkochGrabber2();
		try {
			return grabber.grab(url);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
