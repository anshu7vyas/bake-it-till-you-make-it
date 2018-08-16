package com.anshulvyas.bakeittillyoumakeit.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.anshulvyas.bakeittillyoumakeit.recipedetails.RecipeDetailsActivityViewModel;
import com.anshulvyas.bakeittillyoumakeit.recipes.RecipesActivityViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
abstract class ViewModelsModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(DaggerViewModelFactory factory);

    @Binds
    @IntoMap
    @ViewModelKey(RecipesActivityViewModel.class)
    abstract ViewModel providesRecipesActivityViewModel(RecipesActivityViewModel recipesActivityViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(RecipeDetailsActivityViewModel.class)
    abstract ViewModel providesRecipeDetailActivityModel (RecipeDetailsActivityViewModel recipeDetailsActivityViewModel);
}

