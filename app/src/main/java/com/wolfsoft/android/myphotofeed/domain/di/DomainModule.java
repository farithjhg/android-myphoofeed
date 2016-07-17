package com.wolfsoft.android.myphotofeed.domain.di;

import android.content.Context;
import android.location.Geocoder;

import com.firebase.client.Firebase;
import com.wolfsoft.android.myphotofeed.PhotoFeedApp;
import com.wolfsoft.android.myphotofeed.domain.FirebaseAPI;
import com.wolfsoft.android.myphotofeed.domain.Util;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by farithjhg on 28/06/2016.
 */
@Module
public class DomainModule {

    @Provides
    @Singleton
    FirebaseAPI providesFirebaseAPI(Firebase firebase) {
        return new FirebaseAPI(firebase);
    }

    @Provides
    @Singleton
    Firebase providesFirebase() {
        return new Firebase(PhotoFeedApp.FIREBASE_URL);
    }

    @Provides
    @Singleton
    Util providesUtil(Geocoder geocoder) {
        return new Util(geocoder);
    }

    @Provides
    @Singleton
    Geocoder providesGeocoder(Context context) {
        return new Geocoder(context);
    }
}
