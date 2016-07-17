package com.wolfsoft.android.myphotofeed.main;

import android.location.Location;

import com.wolfsoft.android.myphotofeed.main.events.MainEvent;

/**
 * Created by farithjhg on 29/06/2016.
 */
public interface MainPresenter {
    void onCreate();
    void onDestroy();

    void logout();
    void uploadPhoto(Location location, String path);
    void onEventMainThread(MainEvent event);
}
