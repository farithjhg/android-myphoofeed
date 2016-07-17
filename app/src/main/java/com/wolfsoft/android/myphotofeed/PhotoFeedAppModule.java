package com.wolfsoft.android.myphotofeed;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by farithjhg on 28/06/2016.
 */
@Module
public class PhotoFeedAppModule {
    PhotoFeedApp app;

    public PhotoFeedAppModule(PhotoFeedApp application) {
        this.app = application;
    }

    @Provides
    @Singleton
    SharedPreferences providesSharedPreferences(Application application) {
        return application.getSharedPreferences(app.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    Context providesContext() {
        return app.getApplicationContext();
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return app;
    }
}
