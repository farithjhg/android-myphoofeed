package com.wolfsoft.android.myphotofeed.photolist;

import com.wolfsoft.android.myphotofeed.entities.Photo;

/**
 * Created by farithjhg on 01/07/2016.
 */
public class PhotoListInteractorImpl implements PhotoListInteractor {

    PhotoListRepository repository;

    public PhotoListInteractorImpl(PhotoListRepository repository) {
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

    @Override
    public void likePhoto(Photo photo) {
        repository.likePhoto(photo);
    }

    @Override
    public void disLikePhoto(Photo photo) {
        repository.disLikePhoto(photo);
    }

    @Override
    public void removePhoto(Photo photo) {
        repository.remove(photo);
    }

    @Override
    public boolean checkLike(Photo photo) {
        return repository.checkLike(photo);
    }

    @Override
    public boolean checkDisLike(Photo photo) {
        return repository.checkDisLike(photo);
    }
}
