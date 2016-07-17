package com.wolfsoft.android.myphotofeed.photolist.ui.adapters;

import android.widget.ImageView;

import com.wolfsoft.android.myphotofeed.entities.Photo;

/**
 * Created by farithjhg on 30/06/2016.
 */
public interface OnItemClickListener {
    void onPlaceClick(Photo photo);
    void onShareClick(Photo photo, ImageView img);
    void onDeleteClick(Photo photo);
    void onLikeClick(Photo photo);
    void onDisLikeClick(Photo photo);
    void showImage(Photo photo);
}
