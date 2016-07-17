package com.wolfsoft.android.myphotofeed.login.di;


import com.wolfsoft.android.myphotofeed.PhotoFeedAppModule;
import com.wolfsoft.android.myphotofeed.domain.di.DomainModule;
import com.wolfsoft.android.myphotofeed.lib.di.LibsModule;
import com.wolfsoft.android.myphotofeed.login.ui.LoginActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by farithjhg on 29/06/2016.
 */
@Singleton
@Component(modules = {LoginModule.class, DomainModule.class, LibsModule.class, PhotoFeedAppModule.class})
public interface LoginComponent {
    void inject(LoginActivity activity);
}
