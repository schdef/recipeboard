package de.schdef.slashcoding.recipeboard.dao;
import java.util.List;

import de.schdef.slashcoding.recipeboard.domain.Recipe;
import de.schdef.slashcoding.recipeboard.presentation.web.ThirdPartyCredential;

public interface RecipeDao<T extends Recipe> {

	List<T> findAll();

	T getRandom();

}
