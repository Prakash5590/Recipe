package com.abnamro.recipe.recipeapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long>{
	
}
