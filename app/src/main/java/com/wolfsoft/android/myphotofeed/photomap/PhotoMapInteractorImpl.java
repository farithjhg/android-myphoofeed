package com.wolfsoft.android.myphotofeed.photomap;

/**
 * Created by farithjhg on 01/07/2016.
 */
public class PhotoMapInteractorImpl implements PhotoMapInteractor {

    PhotoMapRepository repository;

    public PhotoMapInteractorImpl(PhotoMapRepository repository) {
        this.repository = repository;
    }

    @Override
    public void subscribe() {
        repository.subscribe();
    }

    @Override
    public void unsubscribe() {
        repository.unsubscribe();
    }
}