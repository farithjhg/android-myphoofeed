package com.wolfsoft.android.myphotofeed.main.di;

import com.wolfsoft.android.myphotofeed.PhotoFeedAppModule;
import com.wolfsoft.android.myphotofeed.domain.di.DomainModule;
import com.wolfsoft.android.myphotofeed.lib.di.LibsModule;
import com.wolfsoft.android.myphotofeed.main.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by farithjhg on 30/06/2016.
 */
@Singleton
@Component(modules = {MainModule.class, DomainModule.class, LibsModule.class, PhotoFeedAppModule.class})
public interface MainComponent {
    void inject(MainActivity activity);
}
