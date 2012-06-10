package de.schdef.slashcoding.recipeboard.dao;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.tidy.Tidy;

import de.schdef.slashcoding.recipeboard.domain.Ingredient;

public class ChefkochGrabber {

	public static void main(String[] args) throws Exception {
		Tidy tidy = new Tidy(); // obtain a new Tidy instance
		URL oracle = new URL(
				"http://www.chefkoch.de/rezepte/1045401209466865/Afrikanische-Erdnuss-Lauch-Suppe.html");
		URLConnection yc = oracle.openConnection();
		// tidy.parse(yc.getInputStream(), System.out); // run tidy, providing
		// an input and
		// output stream

		Document dom = tidy.parseDOM(yc.getInputStream(),
				new ByteArrayOutputStream());
		Element elementById = dom.getElementById("rezept-zutaten");

		if (elementById != null) {
			System.out
					.println("**********************************************");
			System.out.println("found 1!");
			System.out
					.println("**********************************************");
		}

		NodeList elementsByTagName = dom.getElementsByTagName("div");
		for (int i = 0; i < elementsByTagName.getLength(); i++) {
			Node item = elementsByTagName.item(i);
			if (hasAttribute(item, "rezept-zutaten")) {
				System.out
						.println("**********************************************");
				System.out.println("found 2!");
				NodeList childNodes = item.getChildNodes();

				StringWriter sw = new StringWriter();
				Transformer serializer = TransformerFactory.newInstance()
						.newTransformer();

				
				if (childNodes != null) {
					for (int p = 0; p < childNodes.getLength(); p++) {
						Node item3 = childNodes.item(p);
						if (hasAttribute(item3, "ingredient") == false) {
							for (int j = 0; j < item3.getChildNodes()
									.getLength(); j++) {
								Node item4 = item3.getChildNodes().item(j);
								if (hasAttribute(item4, "ingredient")) {
									serializer.transform(new DOMSource(item4),
											new StreamResult(sw));
								}
							}
						} else {
							serializer.transform(new DOMSource(item3),
									new StreamResult(sw));
						}

					}
				}

				
				String htmlTable = sw.toString();
				
				
//				String ingredientsWithoutHTML = sw.toString().replaceAll("\\<.*?>", "#");
				
//				System.out.println(ingredientsWithoutHTML);
				List<Ingredient> ingredientsList = new ArrayList<Ingredient>();
//
//				String[] split = ingredientsWithoutHTML.split("#");
//				String amountValue;
//				String nameValue;
//				for (String string : split) {
//					if(string != null && !string.trim().isEmpty()) {
//						
//						System.out.println(string);	
//						ingredientsList.add(new Ingredient(amount, name));
//					}
//					
//				}				
				
				
//				System.out.println(sw.toString());
				System.out
						.println("**********************************************");

			}
		}
	}

	private static boolean hasAttribute(Node node, String requiredAttribute) {
		boolean hasAttribute = false;
		if (node.hasAttributes()) {
			NamedNodeMap attributes = node.getAttributes();

			for (int k = 0; k < attributes.getLength() && hasAttribute == false; k++) {
				Node attribute = attributes.item(k);
				if (attribute.getNodeValue()
						.equalsIgnoreCase(requiredAttribute)) {
					hasAttribute = true;
				}
			}
		}
		return hasAttribute;
	}

	// public static void main(String[] args) throws IOException,
	// ParserConfigurationException, SAXException, BadLocationException {
	// URL oracle = new URL("http://www.oracle.com/");
	// URLConnection yc = oracle.openConnection();
	// BufferedReader in = new BufferedReader(new InputStreamReader(
	// yc.getInputStream()));
	// // String result = "";
	// // String inputLine;
	// // while ((inputLine = in.readLine()) != null) {
	// //
	// // result += inputLine;
	// // }
	//        
	//        
	// HTMLEditorKit kit = new HTMLEditorKit();
	// Document document = new HTMLDocument();
	// kit.read(in, document, 0);
	//        
	// in.close();
	// }
}
