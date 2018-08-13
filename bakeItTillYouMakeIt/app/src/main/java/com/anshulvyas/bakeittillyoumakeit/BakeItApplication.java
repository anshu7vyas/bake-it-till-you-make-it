package com.anshulvyas.bakeittillyoumakeit;

import android.app.Application;

import com.anshulvyas.bakeittillyoumakeit.di.AndroidModule;
import com.anshulvyas.bakeittillyoumakeit.di.AppComponent;
import com.anshulvyas.bakeittillyoumakeit.di.AppModule;
import com.anshulvyas.bakeittillyoumakeit.di.DaggerAppComponent;
import com.anshulvyas.bakeittillyoumakeit.di.RemoteModule;

public class BakeItApplication extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = createAppComponent();

    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    private AppComponent createAppComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .remoteModule(new RemoteModule())
                .build();
    }

}
