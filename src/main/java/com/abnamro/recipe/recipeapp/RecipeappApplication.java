package com.abnamro.recipe.recipeapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.abnamro.recipe.recipeapp.dao.Recipe;
import com.abnamro.recipe.recipeapp.dao.RecipeRepository;

@SpringBootApplication
public class RecipeappApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeappApplication.class, args);
	}

	@Bean
	CommandLineRunner addDefaultRecipies(RecipeRepository repository) {
		return args -> {
			System.out.println("Adding default recipes");
			repository.save(new Recipe(Long.valueOf("1"),"Mini Idli","05-05-1990 19:00","images/idli.jpg","veg",100,"Soak water grind to batter and cook","rice,urid daal,water, sale, chilli"));
			repository.save(new Recipe(Long.valueOf("2"),"Masala Dosa","05-05-1990 19:00","images/dosa.jpg","veg",100,"Soak water grind to batter and cook","rice,urid daal,water, sale, chilli, potato"));
		};
	}
}
