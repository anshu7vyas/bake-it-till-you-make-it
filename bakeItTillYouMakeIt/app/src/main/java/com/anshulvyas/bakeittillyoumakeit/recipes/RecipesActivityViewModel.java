package com.anshulvyas.bakeittillyoumakeit.recipes;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.anshulvyas.bakeittillyoumakeit.data.RecipesRepository;
import com.anshulvyas.bakeittillyoumakeit.data.model.Recipe;

import java.util.List;

import javax.inject.Inject;

public class RecipesActivityViewModel extends ViewModel {
    private LiveData<List<Recipe>> mRecipeList;

    @Inject
    public RecipesActivityViewModel (RecipesRepository recipesRepository) {
        this.mRecipeList = recipesRepository.getRecipesLiveData();
    }

    public LiveData<List<Recipe>> getRecipesListLiveData() {
        return mRecipeList;
    }
}
