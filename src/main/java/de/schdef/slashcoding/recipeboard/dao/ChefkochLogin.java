package de.schdef.slashcoding.recipeboard.dao;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.jaxen.JaxenException;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import com.gargoylesoftware.htmlunit.html.HtmlTableDataCell;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

public class ChefkochLogin {

	public static void main(String[] args) throws IOException, JaxenException {
//		new ChefkochLogin().getMyCookbook();
	}
	
	public Set<URL> getMyCookbook(String username, String password) throws IOException, JaxenException {
		URL url = new URL("http://www.chefkoch.de/login.php");
		WebClient webClient = new WebClient();
		webClient.setJavaScriptEnabled(false);
		HtmlPage page = (HtmlPage) webClient.getPage(url);
		
		HtmlForm loginForm = (HtmlForm) page.getHtmlElementById("login");
		final HtmlSubmitInput button = (HtmlSubmitInput) page.getByXPath("//*[@id=\"login\"]/table/tbody/tr[4]/td[2]/input").get(0);
//		final HtmlSubmitInput button = (HtmlSubmitInput) page.getHtmlElementsByName("Einloggen!");
        final HtmlTextInput loginName = (HtmlTextInput) loginForm.getInputByName("username");
        final HtmlPasswordInput loginPs = (HtmlPasswordInput) loginForm.getInputByName("password");

        // Change the value of the text field
        loginName.setValueAttribute(username);
        loginPs.setValueAttribute(password);
        
//        System.out.println(page.asText());
        
     // Now submit the form by clicking the button and get back the second page.
        final HtmlPage page2 = (HtmlPage) button.click();
        final String pageAsXml = page2.asText();
//        System.out.println(pageAsXml);
        HtmlPage page3 = (HtmlPage) webClient.getPage("http://www.chefkoch.de/mychefkoch/kochbuch/");
//        System.out.println(page3.asXml());
        
        
        
        Set<URL> urlList = new HashSet<URL>();
        
        HtmlTable table = (HtmlTable) page3.getHtmlElementById("recipe_list");
        Iterator<DomNode> childIterator = table.getAllHtmlChildElements();
        for (Iterator<DomNode> iterator = childIterator; iterator.hasNext();) {
        	DomNode object = (DomNode) iterator.next();
        	if(object instanceof HtmlTableDataCell) {
        		HtmlTableDataCell cell = (HtmlTableDataCell) object;
        		if(cell.getOnClickAttribute() != null && !cell.getOnClickAttribute().isEmpty()) {
        			
        			String onClickAttribtueUrl = cell.getOnClickAttribute();
        			String[] split = onClickAttribtueUrl.split("'");
        			
        			urlList.add(new URL("http://www.chefkoch.de" + split[1]));
        		}
        	}
		}
        
//        webClient.closeAllWindows();
        
        for (URL theResultUrl : urlList) {
			System.out.println(theResultUrl);
		}
        
        return urlList;
	}
}