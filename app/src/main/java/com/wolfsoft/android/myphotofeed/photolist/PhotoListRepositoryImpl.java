package com.wolfsoft.android.myphotofeed.photolist;

import com.firebase.client.DataSnapshot;
import com.firebase.client.FirebaseError;
import com.wolfsoft.android.myphotofeed.domain.FirebaseAPI;
import com.wolfsoft.android.myphotofeed.domain.FirebaseActionListenerCallback;
import com.wolfsoft.android.myphotofeed.domain.FirebaseEventListenerCallback;
import com.wolfsoft.android.myphotofeed.entities.Photo;
import com.wolfsoft.android.myphotofeed.lib.base.EventBus;
import com.wolfsoft.android.myphotofeed.photolist.events.PhotoListEvent;

/**
 * Created by farithjhg on 01/07/2016.
 */
public class PhotoListRepositoryImpl implements PhotoListRepository{
    private EventBus eventBus;
    private FirebaseAPI firebase;

    public PhotoListRepositoryImpl(FirebaseAPI firebase, EventBus eventBus) {
        this.firebase = firebase;
        this.eventBus = eventBus;
    }

    @Override
    public void subscribe() {
        firebase.checkForData(new FirebaseActionListenerCallback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError(FirebaseError error) {
                if(error != null){
                    post(PhotoListEvent.READ_EVENT, error.getMessage());
                }else{
                    post(PhotoListEvent.READ_EVENT, "");
                }
            }
        });
        firebase.subscribe(new FirebaseEventListenerCallback() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot) {
                Photo photo = dataSnapshot.getValue(Photo.class);
                photo.setId(dataSnapshot.getKey());
                String email = firebase.getAuthEmail();
                boolean publishedByMe = photo.getEmail().equals(email);
                photo.setPublishedByMe(publishedByMe);
                post(PhotoListEvent.READ_EVENT, photo);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Photo photo = dataSnapshot.getValue(Photo.class);
                photo.setId(dataSnapshot.getKey());

                post(PhotoListEvent.DELETE_EVENT, photo);
            }

            @Override
            public void onCancelled(FirebaseError error) {
                post(PhotoListEvent.READ_EVENT, error.getMessage());
            }
        });
    }

    @Override
    public void unsubscribe() {
        firebase.unsubscribe();
    }

    @Override
    public void remove(final Photo photo) {
        firebase.remove(photo, new FirebaseActionListenerCallback() {
            @Override
            public void onSuccess() {
                post(PhotoListEvent.DELETE_EVENT, photo);
            }

            @Override
            public void onError(FirebaseError error) {
                post(PhotoListEvent.DELETE_EVENT, error.getMessage());
            }
        });
    }

    @Override
    public void likePhoto(final Photo photo) {
        String email = firebase.getAuthEmail();
        photo.getLikeList().add(email);
        if(checkDisLike(photo)) {
            photo.getDisLikeList().remove(email);
        }
        firebase.update(photo);
        post(PhotoListEvent.UPDATE_EVENT, photo);
    }

    @Override
    public void disLikePhoto(Photo photo) {
        String email = firebase.getAuthEmail();
        photo.getDisLikeList().add(email);
        if(checkLike(photo)) {
            photo.getLikeList().remove(email);
        }
        firebase.update(photo);
        post(PhotoListEvent.UPDATE_EVENT, photo);
    }

    @Override
    public boolean checkLike(Photo photo) {
        String email = firebase.getAuthEmail();
        return photo.likedByMe(email);
    }

    @Override
    public boolean checkDisLike(Photo photo) {
        String email = firebase.getAuthEmail();
        return photo.disLikedByMe(email);
    }

    private void post(int type, Photo photo){
        post(type, photo, null);
    }

    private void post(int type, String error){
        post(type, null, error);
    }

    private void post(int type, Photo photo, String error){
        PhotoListEvent event = new PhotoListEvent();
        event.setType(type);
        event.setError(error);
        event.setPhoto(photo);
        eventBus.post(event);
    }
}
