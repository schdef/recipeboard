package de.schdef.slashcoding.recipeboard.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/recipe")
public class RecipeBoard {

	@RequestMapping(value = "/")
	public @ResponseBody String test() {
		System.out.println("Hallo");
		return "Hallo from recipe!";
	}
	
	@RequestMapping(value = "/generate", method=RequestMethod.GET)
	public @ResponseBody String generate() {
		System.out.println("Generate");
		return "Hallo from generate!";
	}
	
	@RequestMapping("/helloWorld")
    public @ResponseBody String helloWorld(Model model) {
        model.addAttribute("message", "Hello World!");
        System.out.println("Hallo Welt!");
        return "Hallo Welt!";
    }
}
