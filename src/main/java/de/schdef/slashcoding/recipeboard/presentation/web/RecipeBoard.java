package de.schdef.slashcoding.recipeboard.presentation.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import de.schdef.slashcoding.recipeboard.dao.DummyRecipeDao;
import de.schdef.slashcoding.recipeboard.domain.Recipe;

@Controller
@RequestMapping(value = "/rest")
public class RecipeBoard {

	@RequestMapping(value = "/")
	public @ResponseBody String test() {
		System.out.println("Hallo");
		DummyRecipeDao dao = new DummyRecipeDao();
		Recipe recipe = dao.findAll().get(0);
		
		Gson gson = new Gson();
		String jSon = gson.toJson(recipe);

		System.out.println(jSon);
		
		return jSon;
	}
	
	@RequestMapping(value = "/generate", method=RequestMethod.GET)
	public @ResponseBody String generate(@RequestParam String username, @RequestParam String password) {
		String msg = "Generate with " + username + " " + password;
		
		return msg;
	}
	
	@RequestMapping("/helloWorld")
    public @ResponseBody String helloWorld(Model model) {
        model.addAttribute("message", "Hello World!");
        System.out.println("Hallo Welt!");
        return "Hallo Welt!";
    }
}