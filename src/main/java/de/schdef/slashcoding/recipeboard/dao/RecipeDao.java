package de.schdef.slashcoding.recipeboard.dao;
import java.util.List;

import de.schdef.slashcoding.recipeboard.domain.Recipe;

public interface RecipeDao<T extends Recipe> {

	List<T> findAll();

	T getRandom();

}
