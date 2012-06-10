package de.schdef.slashcoding.recipeboard.dao;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import de.schdef.slashcoding.recipeboard.domain.Ingredient;
import de.schdef.slashcoding.recipeboard.domain.Recipe;

public class ChefkochGrabber2 {

	public static void main(String[] args) throws Exception {
		URL url = new URL(
				"http://www.chefkoch.de/rezepte/1045401209466865/Afrikanische-Erdnuss-Lauch-Suppe.html");
		new ChefkochGrabber2().grab(url);
	}

	public Recipe grab(URL url) throws MalformedURLException, IOException {
		Document doc = (Document) Jsoup.parse(url, 3000);
		List<Ingredient> ingredients = grabIngredients(doc);

		String recipeName = grabRecipeName(doc);
		String recipeDescription = grabRecipeDescription(doc);
		String recipePictureUrl = grabRecipePictureUrl(doc);

		return new Recipe(recipeName, recipeDescription, recipePictureUrl,
				ingredients);
	}

	private String grabRecipePictureUrl(Document doc) {
		try {
			Element element = doc.select("form[id=ss_form]").first().select(
					"noscript").first().select("img").first();
			
			String result = element.attr("src");
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	private String grabRecipeDescription(Document doc) {
		Element element = doc.select("div[id=rezept-zubereitung]").first();
		return element.text();
	}

	private String grabRecipeName(Document doc) {
		Element recipeTitleArea = doc.select("span[class=hrecipe]").first();
		Element recipeTitle = recipeTitleArea.select("span[class=item]")
				.first();
		return recipeTitle.text();
	}

	private List<Ingredient> grabIngredients(Document doc) {

		List<Ingredient> ingredientsList = new ArrayList<Ingredient>();

		Element table = doc.select("table[class=zutaten]").first();
		Iterator<Element> ite = table.select("tr[class=ingredient]").iterator();
		while (ite.hasNext()) {
			Element ingredient = ite.next();
			String amount = ingredient.select("td[class=nobr amount]").first()
					.text();
			String name = ingredient.select("td[class=name]").first().text();
			ingredientsList.add(new Ingredient(amount, name));
		}

		return ingredientsList;
	}

}
