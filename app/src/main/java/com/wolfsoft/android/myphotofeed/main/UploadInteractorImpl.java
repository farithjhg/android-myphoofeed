package com.wolfsoft.android.myphotofeed.main;

import android.location.Location;

/**
 * Created by farithjhg on 30/06/2016.
 */
public class UploadInteractorImpl implements UploadInteractor {
    private MainRepository repository;

    public UploadInteractorImpl(MainRepository repository) {
        this.repository = repository;
    }

    @Override
    public void execute(Location location, String path) {
        repository.uploadPhoto(location, path);
    }

}