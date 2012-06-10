package de.schdef.slashcoding.recipeboard.domain;
import java.util.List;


public class Recipe {

	private final String title;
	private final String description;
	private final String pictureUrl;
	private final List<Ingredient> ingredientsList;
	
	public Recipe(String title, String description) {
		this(title, description, null, null);
	}

	public Recipe(String title, String description, String pictureUrl, List<Ingredient> ingredientsList) {
		this.title = title;
		this.description = description;
		this.pictureUrl = pictureUrl;
		this.ingredientsList = ingredientsList;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return this.description;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public List<Ingredient> getIngredientsList() {
		return ingredientsList;
	}

	
	
}
