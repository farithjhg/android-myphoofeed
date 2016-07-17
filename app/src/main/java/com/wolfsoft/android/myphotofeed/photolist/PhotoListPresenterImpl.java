package com.wolfsoft.android.myphotofeed.photolist;

import com.wolfsoft.android.myphotofeed.entities.Photo;
import com.wolfsoft.android.myphotofeed.lib.base.EventBus;
import com.wolfsoft.android.myphotofeed.photolist.events.PhotoListEvent;
import com.wolfsoft.android.myphotofeed.photolist.ui.PhotoListView;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

/**
 * Created by farithjhg on 01/07/2016.
 */
public class PhotoListPresenterImpl implements PhotoListPresenter {
    EventBus eventBus;
    PhotoListView view;
    PhotoListInteractor interactor;
    private final static String EMPTY_LIST = "Empty List";

    public PhotoListPresenterImpl(EventBus eventBus, PhotoListView view, PhotoListInteractor interactor) {
        this.eventBus = eventBus;
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        this.view = null;
        eventBus.unregister(this);
    }

    @Override
    public void subscribe() {
        if (view != null){
            view.hideList();
            view.showProgress();
        }
        interactor.subscribe();
    }

    @Override
    public void unsubscribe() {
        interactor.unsubscribe();
    }

    @Override
    public void onLikeClick(Photo photo) {
        int like = photo.getLike();
        int disLike = photo.getDisLike();
        if(!interactor.checkLike(photo)) {
            photo.setLike(like+1);
            if(interactor.checkDisLike(photo)){
                photo.setDisLike(disLike-1);
            }
            interactor.likePhoto(photo);
        }
    }

    @Override
    public void onDisLikeClick(Photo photo) {
        int like = photo.getLike();
        int disLike = photo.getDisLike();
        if(!interactor.checkDisLike(photo)) {
            photo.setDisLike(disLike+1);
            if(interactor.checkLike(photo)) {
                photo.setLike(like-1);
            }
            interactor.disLikePhoto(photo);
        }
    }

    @Override
    public void removePhoto(Photo photo) {
        interactor.removePhoto(photo);
    }

    @Override
    @Subscribe
    public void onEventMainThread(PhotoListEvent event) {
        if (this.view != null) {
            view.hideProgress();
            view.showList();

            String error = event.getError();
            if (error != null) {
                if (error.isEmpty()) {
                    view.onPhotosError(EMPTY_LIST);
                } else {
                    view.onPhotosError(error);
                }
            } else {
                if (event.getType() == PhotoListEvent.READ_EVENT) {
                    view.addPhoto(event.getPhoto());
                } else if (event.getType() == PhotoListEvent.UPDATE_EVENT) {
                    view.updatePhoto(event.getPhoto());
                } else if (event.getType() == PhotoListEvent.DELETE_EVENT) {
                    view.removePhoto(event.getPhoto());
                }
            }
        }
    }
}
