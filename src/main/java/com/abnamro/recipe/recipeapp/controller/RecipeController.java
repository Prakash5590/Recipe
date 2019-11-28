package com.abnamro.recipe.recipeapp.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abnamro.recipe.recipeapp.dao.Recipe;
import com.abnamro.recipe.recipeapp.dao.RecipeRepository;

@RestController
public class RecipeController {
	@Autowired
	RecipeRepository repository;

	@GetMapping("/recipies")
	public List<Recipe> getAllRecipies() {
		System.out.println("Gettng all the recipies !");
		List<Recipe> response = repository.findAll();
		Collections.sort(response);
		return response;
	}
	
	@PostMapping("/addRecipe")
	public Recipe addNewRecipe(@RequestBody Recipe recipe) {
		System.out.println("Add the recipies ! value :: "+recipe);
		String url = "images/"+recipe.getImageUrl()+".jpg";
		recipe.setImageUrl(url);
		return repository.save(recipe);
	}
	
	@GetMapping("/recipieById/{recipeId}")
	public Recipe findRecipeById(@PathVariable Long recipeId) {
		System.out.println("recipieById the recipies and recipeId :: "+recipeId);
		return repository.findById(recipeId).get();
	}
	@GetMapping("/searchRecipe/{searchString}")
	public Recipe searchRecipeByName(@PathVariable String searchString) {
		System.out.println("recipieById the recipies and recipeId :: "+searchString);
		List<Recipe> response = repository.findAll();
		Recipe found = null;
		for(Recipe recipe : response) {
			if(recipe.getRecipeName().toLowerCase().contains(searchString.toLowerCase())) {
				found = recipe;
				break;
			}
		}
		System.out.println("Found recipie is :: "+found);
		return found;
	}	
	
	@PutMapping("/updateRecipe/{recipeId}")
	public Recipe updateRecipe(@RequestBody Recipe recipe, @PathVariable Long recipeId) {
		System.out.println("updateRecipe the recipies !"+recipe);
		return repository.findById(recipeId)
				.map(x -> {
					x.setCookingInstruction(recipe.getCookingInstruction());
					x.setDateOfCreation(recipe.getDateOfCreation());
					x.setImageUrl(recipe.getImageUrl());
					x.setIndicator(recipe.getIndicator());
					x.setIngredients(recipe.getIngredients());
					x.setLikeCount(recipe.getLikeCount());
					x.setRecipeName(recipe.getRecipeName());
					return repository.save(x);
				}).orElseGet(() -> {
					recipe.setRecipieId(recipeId);
					return repository.save(recipe);
				});
	}
	
	@DeleteMapping("deleteRecipe/{recipeId}")
	public void deleteRecipe(@PathVariable Long recipeId) {
		System.out.println("deleteRecipe the recipies ! id :: "+recipeId);
		repository.deleteById(recipeId);
	}
}
