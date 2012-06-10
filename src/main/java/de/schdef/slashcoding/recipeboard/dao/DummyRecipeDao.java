package de.schdef.slashcoding.recipeboard.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import de.schdef.slashcoding.recipeboard.domain.Ingredient;
import de.schdef.slashcoding.recipeboard.domain.Recipe;

public class DummyRecipeDao implements RecipeDao<Recipe> {

	Recipe africanRecipe = new Recipe(
			"Afrikanische Erdnuss - Lauch - Suppe",
			"Zuerst den Knoblauch, die Zwiebeln und die M�hren sch�len. Den Knoblauch fein hacken und die Zwiebeln und M�hren in d�nne Scheiben schneiden. Alles zusammen in �l anschwitzen und den Wein dazugeben. Anschlie�end einkochen lassen.  Den geschnittenen Lauch sowie Honig, Zucker und Currypulver dazugeben und kurz aufkochen lassen. Dann die Br�he hinzugeben und alles ca. 6 Minuten leicht k�cheln lassen. Die Erdn�sse zwischenzeitig in einer Pfanne anr�sten und zusammen mit Sahne, Kokosmark und Erdnussbutter unter die Suppe r�hren. Abschmecken mit Salz und Pfeffer und anschlie�end die einzelnen Portionen ganz nach Wunsch mit Chili�l betr�ufeln.",
			"http://cdn.chefkoch.de/ck.de/rezepte/104/104540/316103-bigfix-afrikanische-erdnuss-lauch-suppe.jpg",
			new ArrayList<Ingredient>() {
				{
					add(new Ingredient("1", "Knoblauchzehe(n)"));
					add(new Ingredient("1", "Zwiebel(n)"));
					add(new Ingredient("2", "M�hre(n)"));
					add(new Ingredient("3 EL", "�l"));
					add(new Ingredient("75 ml", "Wein, wei�, trocken"));
					add(new Ingredient("1 Stange/n", "Lauch"));
					add(new Ingredient("1 EL", "Honig"));
					add(new Ingredient("1 EL", "Zucker"));
					add(new Ingredient("2 TL", "Currypulver"));
					add(new Ingredient("750 ml", "Gem�sebr�he"));
					add(new Ingredient("175 g", "Erdn�sse, ungesalzene"));
					add(new Ingredient("150 ml", "Sahne"));
					add(new Ingredient("250 ml", "Kokosmilch oder Kokosmark"));
					add(new Ingredient("2 EL", "Erdnussbutter"));
					add(new Ingredient(null, "Salz und Pfeffer"));
					add(new Ingredient(null, "Chili�l"));
				}
			});

	Recipe cakeRecipe = new Recipe(
			"Der beste K�sekuchen der Welt",
			"Die Zutaten f�r den Knetteig werden in eine Sch�ssel gegeben, rasch zusammengeknetet und zur Seite gestellt. F�r die F�llung Margarine, Zucker, Vanillezucker, Puddingpulver und 3 Eier in einer Sch�ssel verr�hren. Dann den Quark und die saure Sahne untermischen. Die s��e Sahne steif schlagen und unterheben. Den Knetteig in einer gefetteten Springform auslegen, etwa 2-3 cm am Rand hochziehen, nicht vergessen! Nun die F�llung in die Form geben, glatt streichen und ab in den vorgeheizten Backofen! Bei 180�C 1 Stunde backen.",
			"http://cdn.chefkoch.de/ck.de/rezepte/121/121839/216281-bigfix-der-beste-kaesekuchen-der-welt.jpg",
			new ArrayList<Ingredient>() {
				{
					add(new Ingredient(null, "F�r den Teig:"));
					add(new Ingredient("200 g","Mehl"));
					add(new Ingredient("75 g","Zucker"));
					add(new Ingredient("75 g","Margarine"));
					add(new Ingredient("1","Ei(er)"));
					add(new Ingredient("� Pck.","Backpulver"));
					add(new Ingredient(null, "F�r die F�llung:"));
					add(new Ingredient("125 g","Margarine"));
					add(new Ingredient("225 g","Zucker"));
					add(new Ingredient("1 Beutel","Vanillezucker"));
					add(new Ingredient("1 Beutel","Puddingpulver, Vanillegeschmack"));
					add(new Ingredient("3","Ei(er)"));
					add(new Ingredient("1 Becher","Quark"));
					add(new Ingredient("1 Becher","saure Sahne"));
					add(new Ingredient("1 Becher","s��e Sahne"));
				}
			});

	Recipe mexicanRecipe = new Recipe(
			"Chili con Carne",
			"Die Zwiebeln und den Knoblauch w�rfeln und in hei�em �l 5 Minuten anschwitzen, bis sie weich sind. Gehackte Chilischoten (mit Kernen), Kreuzk�mmel und Chilipulver hinzuf�gen und weitere 2 Minuten d�nsten. Das Rinderhack in den Topf geben und bei gro�er Hitze ringsherum kr�melig anbraten. Die Dosentomaten und die Zimtstange unterr�hren und mit Salz und Pfeffer kr�ftig w�rzen. Alles auf mittlerer Flamme 90 Minuten k�cheln lassen, dabei gelegentlich umr�hren. 30 Minuten vor Ende der Garzeit die Bohnen hinzuf�gen und eventuell mit Sambal Oelek abschmecken (wem es noch nicht scharf genug sein sollte). Mit Wei�brot und einem Klecks Naturjoghurt oder Guacamole servieren. Noch besser schmeckt es, wenn man das Chili con Carne schon am Vortag zubereitet.",
			"http://cdn.chefkoch.de/ck.de/rezepte/116/116707/219025-bigfix-chili-con-carne.jpg",
			null);

	List<Recipe> recipeList = new ArrayList<Recipe>();

	public DummyRecipeDao() {
		recipeList.add(africanRecipe);
		recipeList.add(cakeRecipe);
		recipeList.add(mexicanRecipe);
	}

	public List<Recipe> findAll() {
		return recipeList;
	}

	public Recipe getRandom() {
		return this.recipeList.get(new Random().nextInt(2));
	}

}
