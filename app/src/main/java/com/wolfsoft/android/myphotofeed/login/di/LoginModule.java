package com.wolfsoft.android.myphotofeed.login.di;

import com.wolfsoft.android.myphotofeed.domain.FirebaseAPI;
import com.wolfsoft.android.myphotofeed.lib.base.EventBus;
import com.wolfsoft.android.myphotofeed.login.LoginInteractor;
import com.wolfsoft.android.myphotofeed.login.LoginInteractorImpl;
import com.wolfsoft.android.myphotofeed.login.LoginPresenter;
import com.wolfsoft.android.myphotofeed.login.LoginPresenterImpl;
import com.wolfsoft.android.myphotofeed.login.LoginRepository;
import com.wolfsoft.android.myphotofeed.login.LoginRepositoryImpl;
import com.wolfsoft.android.myphotofeed.login.SignupInteractor;
import com.wolfsoft.android.myphotofeed.login.SignupInteractorImpl;
import com.wolfsoft.android.myphotofeed.login.ui.LoginView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by farithjhg on 29/06/2016.
 */
@Module
public class LoginModule {
    LoginView view;

    public LoginModule(LoginView view) {
        this.view = view;
    }

    @Provides @Singleton
    LoginView providesLoginView() {
        return this.view;
    }

    @Provides @Singleton
    LoginPresenter providesLoginPresenter(EventBus eventBus, LoginView loginView, LoginInteractor loginInteractor, SignupInteractor signupInteractor) {
        return new LoginPresenterImpl(eventBus, loginView, loginInteractor, signupInteractor);
    }

    @Provides @Singleton
    LoginInteractor providesLoginInteractor(LoginRepository repository) {
        return new LoginInteractorImpl(repository);
    }

    @Provides @Singleton
    SignupInteractor providesSignupInteractor(LoginRepository repository) {
        return new SignupInteractorImpl(repository);
    }

    @Provides @Singleton
    LoginRepository providesLoginRepository(FirebaseAPI firebase, EventBus eventBus) {
        return new LoginRepositoryImpl(firebase, eventBus);
    }
}
