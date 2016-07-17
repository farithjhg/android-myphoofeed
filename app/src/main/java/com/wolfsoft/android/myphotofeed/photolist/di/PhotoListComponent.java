package com.wolfsoft.android.myphotofeed.photolist.di;

import com.wolfsoft.android.myphotofeed.PhotoFeedAppModule;
import com.wolfsoft.android.myphotofeed.domain.di.DomainModule;
import com.wolfsoft.android.myphotofeed.lib.di.LibsModule;
import com.wolfsoft.android.myphotofeed.photolist.ui.PhotoListFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by farithjhg on 01/07/2016.
 */
@Singleton
@Component(modules = {PhotoListModule.class, DomainModule.class, LibsModule.class, PhotoFeedAppModule.class})
public interface PhotoListComponent {
    void inject(PhotoListFragment fragment);
}
