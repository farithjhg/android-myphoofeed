package com.wolfsoft.android.myphotofeed.photolist.ui;

import com.wolfsoft.android.myphotofeed.entities.Photo;

/**
 * Created by farithjhg on 30/06/2016.
 */
public interface PhotoListView {
    void showList();
    void hideList();
    void showProgress();
    void hideProgress();

    void addPhoto(Photo photo);
    void updatePhoto(Photo photo);
    void removePhoto(Photo photo);
    void onPhotosError(String error);
}
