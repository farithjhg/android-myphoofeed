package com.wolfsoft.android.myphotofeed.lib.di;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.wolfsoft.android.myphotofeed.lib.CloudinaryImageStorage;
import com.wolfsoft.android.myphotofeed.lib.GlideImageLoader;
import com.wolfsoft.android.myphotofeed.lib.GreenRobotEventBus;
import com.wolfsoft.android.myphotofeed.lib.base.EventBus;
import com.wolfsoft.android.myphotofeed.lib.base.ImageLoader;
import com.wolfsoft.android.myphotofeed.lib.base.ImageStorage;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/**
 * Created by farithjhg on 28/06/2016..
 */
@Module
public class LibsModule {
    private Fragment fragment;

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @Singleton
    EventBus providesEventBus() {
        return new GreenRobotEventBus();
    }

    @Provides
    @Singleton
    ImageLoader providesImageLoader(Fragment fragment) {
        GlideImageLoader imageLoader = new GlideImageLoader();
        if (fragment != null) {
            imageLoader.setLoaderContext(fragment);
        }
        return imageLoader;
    }

    @Provides
    @Singleton
    ImageStorage providesImageStorage(Context context, EventBus eventBus) {
        ImageStorage imageStorage = new CloudinaryImageStorage(context, eventBus);
        return imageStorage;
    }

    @Provides
    @Singleton
    Fragment providesFragment(){
        return this.fragment;
    }
}
