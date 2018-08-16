package com.anshulvyas.bakeittillyoumakeit.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.preference.PreferenceManager;

import com.anshulvyas.bakeittillyoumakeit.recipedetails.RecipeDetailsActivity;
import com.anshulvyas.bakeittillyoumakeit.recipedetails.RecipeStepDetailsActivity;
import com.anshulvyas.bakeittillyoumakeit.recipes.RecipesActivity;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class AndroidBindingModule {

    @ContributesAndroidInjector
    abstract RecipesActivity recipesActivity();

    @ContributesAndroidInjector
    abstract RecipeDetailsActivity recipeDetailsActivity();

    @ContributesAndroidInjector
    abstract RecipeStepDetailsActivity recipeStepDetailsActivity();
}
