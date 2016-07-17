package com.wolfsoft.android.myphotofeed.photomap.di;

import com.wolfsoft.android.myphotofeed.domain.FirebaseAPI;
import com.wolfsoft.android.myphotofeed.lib.base.EventBus;
import com.wolfsoft.android.myphotofeed.photomap.PhotoMapInteractor;
import com.wolfsoft.android.myphotofeed.photomap.PhotoMapInteractorImpl;
import com.wolfsoft.android.myphotofeed.photomap.PhotoMapPresenter;
import com.wolfsoft.android.myphotofeed.photomap.PhotoMapPresenterImpl;
import com.wolfsoft.android.myphotofeed.photomap.PhotoMapRepository;
import com.wolfsoft.android.myphotofeed.photomap.PhotoMapRepositoryImpl;
import com.wolfsoft.android.myphotofeed.photomap.ui.PhotoMapView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by farithjhg on 01/07/2016.
 */
@Module
public class PhotoMapModule {
    PhotoMapView view;

    public PhotoMapModule(PhotoMapView view) {
        this.view = view;
    }

    @Provides
    @Singleton
    PhotoMapView providesPhotoContentView() {
        return this.view;
    }

    @Provides @Singleton
    PhotoMapPresenter providesPhotoContentPresenter(EventBus eventBus, PhotoMapView view, PhotoMapInteractor listInteractor) {
        return new PhotoMapPresenterImpl(eventBus, view, listInteractor);
    }

    @Provides @Singleton
    PhotoMapInteractor providesPhotoContentInteractor(PhotoMapRepository repository) {
        return new PhotoMapInteractorImpl(repository);
    }

    @Provides @Singleton
    PhotoMapRepository providesPhotoContentRepository(FirebaseAPI firebase, EventBus eventBus) {
        return new PhotoMapRepositoryImpl(firebase, eventBus);
    }
}
