package com.wolfsoft.android.myphotofeed.photolist.di;

import com.wolfsoft.android.myphotofeed.domain.FirebaseAPI;
import com.wolfsoft.android.myphotofeed.domain.Util;
import com.wolfsoft.android.myphotofeed.entities.Photo;
import com.wolfsoft.android.myphotofeed.lib.base.EventBus;
import com.wolfsoft.android.myphotofeed.lib.base.ImageLoader;
import com.wolfsoft.android.myphotofeed.photolist.PhotoListInteractor;
import com.wolfsoft.android.myphotofeed.photolist.PhotoListInteractorImpl;
import com.wolfsoft.android.myphotofeed.photolist.PhotoListPresenter;
import com.wolfsoft.android.myphotofeed.photolist.PhotoListPresenterImpl;
import com.wolfsoft.android.myphotofeed.photolist.PhotoListRepository;
import com.wolfsoft.android.myphotofeed.photolist.PhotoListRepositoryImpl;
import com.wolfsoft.android.myphotofeed.photolist.ui.PhotoListView;
import com.wolfsoft.android.myphotofeed.photolist.ui.adapters.OnItemClickListener;
import com.wolfsoft.android.myphotofeed.photolist.ui.adapters.PhotoListAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by farithjhg on 01/07/2016.
 */
@Module
public class PhotoListModule {
    PhotoListView view;
    OnItemClickListener onItemClickListener;

    public PhotoListModule(PhotoListView view, OnItemClickListener onItemClickListener) {
        this.view = view;
        this.onItemClickListener = onItemClickListener;
    }

    @Provides @Singleton
    PhotoListView providesPhotoContentView() {
        return this.view;
    }

    @Provides @Singleton
    PhotoListPresenter providesPhotoListPresenter(EventBus eventBus, PhotoListView view, PhotoListInteractor listInteractor) {
        return new PhotoListPresenterImpl(eventBus, view, listInteractor);
    }

    @Provides @Singleton
    PhotoListInteractor providesPhotoListInteractor(PhotoListRepository repository) {
        return new PhotoListInteractorImpl(repository);
    }

    @Provides @Singleton
    PhotoListRepository providesPhotoListRepository(FirebaseAPI firebase, EventBus eventBus) {
        return new PhotoListRepositoryImpl(firebase, eventBus);
    }

    @Provides @Singleton
    PhotoListAdapter providesPhotosAdapter(FirebaseAPI firebase,Util utils, List<Photo> photoList, ImageLoader imageLoader, OnItemClickListener onItemClickListener) {
        return new PhotoListAdapter(firebase, utils, photoList, imageLoader, onItemClickListener);
    }

    @Provides @Singleton
    OnItemClickListener providesOnItemClickListener() {
        return this.onItemClickListener;
    }

    @Provides
    @Singleton
    List<Photo> providesPhotosList() {
        return new ArrayList<Photo>();
    }

}