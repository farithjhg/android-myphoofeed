package com.wolfsoft.android.myphotofeed;

import android.app.Application;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.firebase.client.Firebase;
import com.wolfsoft.android.myphotofeed.domain.di.DomainModule;
import com.wolfsoft.android.myphotofeed.lib.di.LibsModule;
import com.wolfsoft.android.myphotofeed.login.di.DaggerLoginComponent;
import com.wolfsoft.android.myphotofeed.login.di.LoginComponent;
import com.wolfsoft.android.myphotofeed.login.di.LoginModule;
import com.wolfsoft.android.myphotofeed.login.ui.LoginView;
import com.wolfsoft.android.myphotofeed.main.di.DaggerMainComponent;
import com.wolfsoft.android.myphotofeed.main.di.MainComponent;
import com.wolfsoft.android.myphotofeed.main.di.MainModule;
import com.wolfsoft.android.myphotofeed.main.ui.MainView;
import com.wolfsoft.android.myphotofeed.photolist.di.DaggerPhotoListComponent;
import com.wolfsoft.android.myphotofeed.photolist.di.PhotoListComponent;
import com.wolfsoft.android.myphotofeed.photolist.di.PhotoListModule;
import com.wolfsoft.android.myphotofeed.photolist.ui.PhotoListView;
import com.wolfsoft.android.myphotofeed.photolist.ui.adapters.OnItemClickListener;
import com.wolfsoft.android.myphotofeed.photomap.di.DaggerPhotoMapComponent;
import com.wolfsoft.android.myphotofeed.photomap.di.PhotoMapComponent;
import com.wolfsoft.android.myphotofeed.photomap.di.PhotoMapModule;
import com.wolfsoft.android.myphotofeed.photomap.ui.PhotoMapView;

/**
 * Created by farithjhg on 28/06/2016.
 */
public class PhotoFeedApp extends Application {
    public final static String EMAIL_KEY = "email";
    public final static String SHARED_PREFERENCES_NAME = "UserPrefs";
    public final static String FIREBASE_URL = "https://myphotofeed.firebaseio.com/";

    private DomainModule domainModule;
    private PhotoFeedAppModule photoFeedAppModule;
    private LibsModule libsModule;

    @Override
    public void onCreate() {
        super.onCreate();
        initFirebase();
        initModules();
    }

    private void initModules() {
      libsModule = new LibsModule();
      domainModule = new DomainModule();
      photoFeedAppModule = new PhotoFeedAppModule(this);
    }

    private void initFirebase() {
        Firebase.setAndroidContext(this);
    }

    public static String getEmailKey() {
        return EMAIL_KEY;
    }

    public LoginComponent getLoginComponent(LoginView view) {
        return DaggerLoginComponent
                .builder()
                .photoFeedAppModule(photoFeedAppModule)
                .domainModule(domainModule)
                .libsModule(libsModule)
                .loginModule(new LoginModule(view))
                .build();

    }

    public MainComponent getMainComponent(MainView view, FragmentManager manager, Fragment[]fragments, String[] titles) {
        return DaggerMainComponent
                .builder()
                .photoFeedAppModule(photoFeedAppModule)
                .domainModule(domainModule)
                .libsModule(libsModule)
                .mainModule(new MainModule(view, manager, fragments, titles))
                .build();
    }

    public PhotoListComponent getPhotoListComponent(Fragment fragment, PhotoListView view, OnItemClickListener onItemClickListener) {
        libsModule.setFragment(fragment);

        return DaggerPhotoListComponent
                .builder()
                .photoFeedAppModule(photoFeedAppModule)
                .domainModule(domainModule)
                .libsModule(libsModule)
                .photoListModule(new PhotoListModule(view, onItemClickListener))
                .build();

    }

    public PhotoMapComponent getPhotoMapComponent(Fragment fragment, PhotoMapView view) {
        libsModule.setFragment(fragment);

        return DaggerPhotoMapComponent
                .builder()
                .photoFeedAppModule(photoFeedAppModule)
                .domainModule(domainModule)
                .libsModule(libsModule)
                .photoMapModule(new PhotoMapModule(view))
                .build();

    }

}
