package com.wolfsoft.android.myphotofeed.main.di;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.wolfsoft.android.myphotofeed.domain.FirebaseAPI;
import com.wolfsoft.android.myphotofeed.lib.base.EventBus;
import com.wolfsoft.android.myphotofeed.lib.base.ImageStorage;
import com.wolfsoft.android.myphotofeed.main.MainPresenter;
import com.wolfsoft.android.myphotofeed.main.MainPresenterImpl;
import com.wolfsoft.android.myphotofeed.main.MainRepository;
import com.wolfsoft.android.myphotofeed.main.MainRepositoryImpl;
import com.wolfsoft.android.myphotofeed.main.SessionInteractor;
import com.wolfsoft.android.myphotofeed.main.SessionInteractorImpl;
import com.wolfsoft.android.myphotofeed.main.UploadInteractor;
import com.wolfsoft.android.myphotofeed.main.UploadInteractorImpl;
import com.wolfsoft.android.myphotofeed.main.ui.MainView;
import com.wolfsoft.android.myphotofeed.main.ui.adapters.MainSectionsPagerAdapter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by farithjhg on 30/06/2016.
 */
@Module
public class MainModule {
    private MainView view;
    private String[] titles;
    private Fragment[] fragments;
    private FragmentManager fragmentManager;

    public MainModule(MainView view, FragmentManager fragmentManager, Fragment[] fragments, String[] titles) {
        this.view = view;
        this.titles = titles;
        this.fragments = fragments;
        this.fragmentManager = fragmentManager;
    }

    @Provides
    @Singleton
    MainView providesMainView() {
        return this.view;
    }

    @Provides @Singleton
    MainPresenter providesMainPresenter(MainView view, EventBus eventBus, UploadInteractor uploadInteractor, SessionInteractor sessionInteractor) {
        return new MainPresenterImpl(view, eventBus, uploadInteractor, sessionInteractor);
    }

    @Provides @Singleton
    UploadInteractor providesUploadInteractor(MainRepository repository) {
        return new UploadInteractorImpl(repository);
    }

    @Provides @Singleton
    SessionInteractor providesSessionInteractor(MainRepository repository) {
        return new SessionInteractorImpl(repository);
    }

    @Provides @Singleton
    MainRepository providesMainRepository(EventBus eventBus, FirebaseAPI firebase, ImageStorage imageStorage) {
        return new MainRepositoryImpl(eventBus, firebase, imageStorage);
    }

    @Provides @Singleton
    MainSectionsPagerAdapter providesAdapter(FragmentManager fm, Fragment[] fragments, String[] titles){
        return new MainSectionsPagerAdapter(fm, fragments, titles);
    }

    @Provides @Singleton
    FragmentManager providesAdapterFragmentManager(){
        return this.fragmentManager;
    }

    @Provides @Singleton
    Fragment[] providesFragmentArrayForAdapter(){
        return this.fragments;
    }

    @Provides
    @Singleton
    String[] providesStringArrayForAdapter(){
        return this.titles;
    }



}
