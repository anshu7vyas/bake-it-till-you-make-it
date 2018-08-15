package com.anshulvyas.bakeittillyoumakeit.di;

import com.anshulvyas.bakeittillyoumakeit.BakeItApplication;
import dagger.android.support.AndroidSupportInjectionModule;


import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;

@Singleton
@Component(modules = {AppModule.class,
        RemoteModule.class,
        AndroidBindingModule.class,
        ViewModelsModule.class,
        AndroidSupportInjectionModule.class})
public interface AppComponent extends AndroidInjector<BakeItApplication> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<BakeItApplication> {

    }

}
