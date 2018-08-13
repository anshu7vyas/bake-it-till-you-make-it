package com.anshulvyas.bakeittillyoumakeit.di;

import com.anshulvyas.bakeittillyoumakeit.data.model.Recipe;
import com.anshulvyas.bakeittillyoumakeit.data.remote.RecipeApiService;

import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RemoteModule {

    public static final String RECIPE_SERVICE_BASE_URL = "https://d17h27t6h515a5.cloudfront.net";

    @Provides
    @Singleton
    public Retrofit providesRetrofit() {
        return new Retrofit
                .Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(RECIPE_SERVICE_BASE_URL)
                .build();
    }

    @Provides
    Call<List<Recipe>> providesRecipeList (Retrofit retrofit) {
        return retrofit
                .create(RecipeApiService.class)
                .getRecipes();
    }

}
