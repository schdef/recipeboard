package de.schdef.slashcoding.recipeboard.presentation.web;

import static org.junit.Assert.*;

import org.junit.Test;

import com.google.gson.Gson;

import de.schdef.slashcoding.recipeboard.dao.DummyRecipeDao;
import de.schdef.slashcoding.recipeboard.domain.Recipe;

public class JsonTest {

	@Test
	public void test() {
		DummyRecipeDao dao = new DummyRecipeDao();
		Recipe recipe = dao.findAll().get(0);
		
		String jSon = convertToJSon(recipe);
		assertNotNull(jSon);
	}
	
	private String convertToJSon(Recipe recipe) {
		Gson gson = new Gson();
		return gson.toJson(recipe);		
	}
	
}
