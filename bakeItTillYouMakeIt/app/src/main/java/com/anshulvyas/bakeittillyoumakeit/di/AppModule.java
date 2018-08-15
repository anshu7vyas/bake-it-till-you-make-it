package com.anshulvyas.bakeittillyoumakeit.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.preference.PreferenceManager;

import com.anshulvyas.bakeittillyoumakeit.BakeItApplication;
import com.anshulvyas.bakeittillyoumakeit.data.RecipesRepository;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
abstract class AppModule {

    @Binds
    abstract Application application(BakeItApplication bakeItApplication);

    @Provides
    public static Resources providesResources (Application application) {
        return application.getResources();
    }

    @Provides
    public static SharedPreferences providesSharedPreferences (Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

}
