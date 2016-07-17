package com.wolfsoft.android.myphotofeed.photolist;

import com.wolfsoft.android.myphotofeed.entities.Photo;
import com.wolfsoft.android.myphotofeed.photolist.events.PhotoListEvent;

/**
 * Created by farithjhg on 30/06/2016.
 */
public interface PhotoListPresenter {
    void onCreate();
    void onDestroy();

    void subscribe();
    void unsubscribe();
    void onLikeClick(Photo photo);
    void onDisLikeClick(Photo photo);
    void removePhoto(Photo photo);
    void onEventMainThread(PhotoListEvent event);
}
