package com.wolfsoft.android.myphotofeed.main.ui;

/**
 * Created by farithjhg on 29/06/2016.
 */
public interface MainView {
    void onUploadInit();
    void onUploadComplete();
    void onUploadError(String error);
}
