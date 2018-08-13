package com.anshulvyas.bakeittillyoumakeit.di;

import com.anshulvyas.bakeittillyoumakeit.data.RecipesRepository;
import com.anshulvyas.bakeittillyoumakeit.recipes.RecipesActivity;
import com.anshulvyas.bakeittillyoumakeit.BakeItApplication;
import com.anshulvyas.bakeittillyoumakeit.recipes.RecipesActivityViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, RemoteModule.class, AndroidModule.class})
public interface AppComponent {

    void inject (BakeItApplication target);
    void inject (RecipesActivity target);
    void inject (RecipesRepository target);

}
