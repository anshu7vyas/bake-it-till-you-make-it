package com.anshulvyas.bakeittillyoumakeit.di;

import android.app.Application;
import android.content.Context;

import com.anshulvyas.bakeittillyoumakeit.data.RecipesRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private Application mApplication;
    private RecipesRepository mRecipeRepository;

    public AppModule(Application application) {
        this.mApplication = application;
    }

    @Provides @Singleton
    public Context provideApplicationContext() {
        return mApplication;
    }

    @Provides @Singleton
    public RecipesRepository providesRecipeRepository() {
        return mRecipeRepository;
    }

}
