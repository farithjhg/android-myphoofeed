package com.wolfsoft.android.myphotofeed.lib.di;

import com.wolfsoft.android.myphotofeed.PhotoFeedAppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by farithjhg on 28/06/2016..
 */
@Singleton
@Component(modules = {LibsModule.class, PhotoFeedAppModule.class})
public interface LibsComponent {
}
