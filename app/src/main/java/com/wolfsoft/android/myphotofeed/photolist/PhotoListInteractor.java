package com.wolfsoft.android.myphotofeed.photolist;

import com.wolfsoft.android.myphotofeed.entities.Photo;

/**
 * Created by farithjhg on 30/06/2016.
 */
public interface PhotoListInteractor {
    void subscribe();
    void unsubscribe();
    void likePhoto(Photo photo);
    void disLikePhoto(Photo photo);
    void removePhoto(Photo photo);
    boolean checkLike(Photo photo);
    boolean checkDisLike(Photo photo);
}
