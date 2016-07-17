package com.wolfsoft.android.myphotofeed.domain.di;

import com.wolfsoft.android.myphotofeed.PhotoFeedAppModule;

import javax.inject.Singleton;

import dagger.Component;


/**
 * Created by farithjhg on 28/06/2016.
 */
@Singleton
@Component(modules = {DomainModule.class, PhotoFeedAppModule.class})
public interface DomainComponent {

}
