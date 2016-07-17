package com.wolfsoft.android.myphotofeed.main;

/**
 * Created by farithjhg on 30/06/2016.
 */
public class SessionInteractorImpl implements SessionInteractor {
    MainRepository repository;

    public SessionInteractorImpl(MainRepository repository) {
        this.repository = repository;
    }

    @Override
    public void logout() {
        repository.logout();
    }
}