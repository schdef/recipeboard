package de.schdef.slashcoding.recipeboard.presentation;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import de.schdef.slashcoding.recipeboard.dao.DummyRecipeDao;
import de.schdef.slashcoding.recipeboard.dao.RecipeDao;
import de.schdef.slashcoding.recipeboard.domain.Ingredient;
import de.schdef.slashcoding.recipeboard.domain.Recipe;

public class PdfGenerator {

	/**
	 * @param args
	 * @throws DocumentException
	 * @throws IOException
	 * @throws MalformedURLException
	 */
	public static void main(String[] args) throws DocumentException,
			MalformedURLException, IOException {

		 RecipeDao<Recipe> dao = new DummyRecipeDao();
//		 RecipeDao<Recipe> dao = new UrlBasedDummyRecipeDao();
//		RecipeDao<Recipe> dao = new ChefkochDao();

		// TODO Auto-generated method stub
		// Document document = new Document(PageSize.A4, 50, 50, 50, 50);
		Document document = new Document();

		PdfWriter writer = PdfWriter.getInstance(document,
				new FileOutputStream("E:\\ITextTest.pdf"));
		// document.setPageSize(PageSize.A4.rotate());

		document.open();

		// document.add(new Paragraph("First page of the document."));
		// document
		// .add(new Paragraph(
		// "Some more text on the first page with different color and font type.",
		//
		// FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD,
		// new Color(255, 150, 200))));
		//
		// Paragraph title11 = new Paragraph("This is Section 1 in Chapter 1",
		//
		// FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD, new Color(
		// 255, 0, 0)));
		//

		Font coverFont = FontFactory.getFont(FontFactory.TIMES_ITALIC, 38,
				Font.BOLD, new BaseColor(0, 0, 0));

		Font titleFont = FontFactory.getFont(FontFactory.HELVETICA, 28,
				Font.BOLD, new BaseColor(0, 0, 0));

		Font standardFont = FontFactory.getFont(FontFactory.HELVETICA, 14,
				Font.NORMAL, new BaseColor(0, 0, 0));

		Paragraph coverParagraph = new Paragraph("Meine Rezeptsammlung",
				coverFont);
		coverParagraph.setAlignment(Paragraph.ALIGN_CENTER);

		Paragraph coverSubParagraph = new Paragraph("Sylvia \"Kochheld\"",
				titleFont);
		coverSubParagraph.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(new Paragraph(" "));
		document.add(new Paragraph(" "));
		document.add(new Paragraph(" "));
		document.add(new Paragraph(" "));
		document.add(new Paragraph(" "));
		document.add(new Paragraph(" "));
		document.add(new Paragraph(" "));
		document.add(new Paragraph(" "));
		document.add(new Paragraph(" "));
		document.add(new Paragraph(" "));
		document.add(new Paragraph(" "));
		document.add(new Paragraph(" "));
		document.add(new Paragraph(" "));
		document.add(new Paragraph(" "));
		document.add(new Paragraph(" "));
		document.add(coverParagraph);
		document.add(coverSubParagraph);
		document.newPage();

		List<Recipe> allRecipes = dao.findAll();

		int pageNumber = document.getPageNumber();
		for (Recipe recipe : allRecipes) {

			document.setPageCount(++pageNumber);
			System.out.println("Generating page: " + document.getPageNumber());

			document.add(new Paragraph(recipe.getTitle(), titleFont));

			if (recipe.getPictureUrl() != null) {
				Image image = Image.getInstance(recipe.getPictureUrl());
				image.scalePercent(85.0f);
				if (recipe.getIngredientsList() != null
						&& !recipe.getIngredientsList().isEmpty()) {
					image.setAlignment(Image.LEFT | Image.TEXTWRAP);
				}
				document.add(image);
			}

			if (recipe.getIngredientsList() != null
					&& !recipe.getIngredientsList().isEmpty()) {
				List<Ingredient> ingredientsList = recipe.getIngredientsList();
				for (Ingredient ingredient : ingredientsList) {
					document.add(new Paragraph("  - " + ingredient,
							standardFont));
				}
			}

			document.add(new Paragraph(recipe.getDescription(), standardFont));
			document.newPage();

		}

		// document.add

		// Header header = new Header("uu", africanRecipe.getTitle());
		// document.addHeader("uu", africanRecipe.getTitle());

		// Paragraph title1 = new Paragraph(africanRecipe.getTitle(),
		//
		// FontFactory.getFont(FontFactory.HELVETICA,
		//
		// 28, Font.BOLD, new Color(0, 0, 0)));
		//
		// Chapter chapter1 = new Chapter(title1, 1);
		//
		// chapter1.setNumberDepth(0);
		// Section section1 = chapter1.addSection(title1);
		//
		// Paragraph someSectionText = new Paragraph(
		// "This text comes as part of section 1 of chapter 1.");
		//
		// section1.add(someSectionText);
		//
		// someSectionText = new Paragraph("Following is a 3 X 2 table.");
		//
		// section1.add(someSectionText);
		//
		// document.add(section1);

		document.close();

	}
}
