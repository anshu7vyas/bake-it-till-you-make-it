package com.anshulvyas.bakeittillyoumakeit.recipedetails;

import android.arch.lifecycle.ViewModel;

import com.anshulvyas.bakeittillyoumakeit.data.RecipesRepository;

import javax.inject.Inject;

public class RecipeDetailsActivityViewModel extends ViewModel {

    private RecipesRepository mRecipeRepository;

    @Inject
    public RecipeDetailsActivityViewModel (RecipesRepository recipesRepository) {
        this.mRecipeRepository = recipesRepository;
    }

}
