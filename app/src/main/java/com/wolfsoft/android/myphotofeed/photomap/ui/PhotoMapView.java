package com.wolfsoft.android.myphotofeed.photomap.ui;

import com.wolfsoft.android.myphotofeed.entities.Photo;

/**
 * Created by farithjhg on 01/07/2016.
 */
public interface PhotoMapView {
    void addPhoto(Photo photo);
    void removePhoto(Photo photo);
    void onPhotosError(String error);
}
