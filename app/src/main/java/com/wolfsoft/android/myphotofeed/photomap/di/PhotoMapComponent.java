package com.wolfsoft.android.myphotofeed.photomap.di;

import com.wolfsoft.android.myphotofeed.PhotoFeedAppModule;
import com.wolfsoft.android.myphotofeed.domain.di.DomainModule;
import com.wolfsoft.android.myphotofeed.lib.di.LibsModule;
import com.wolfsoft.android.myphotofeed.photomap.ui.PhotoMapFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by farithjhg on 01/07/2016.
 */
@Singleton
@Component(modules = {PhotoMapModule.class, DomainModule.class, LibsModule.class, PhotoFeedAppModule.class})
public interface PhotoMapComponent {
    void inject(PhotoMapFragment fragment);
}
