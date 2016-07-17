package com.wolfsoft.android.myphotofeed.photomap;

import com.wolfsoft.android.myphotofeed.photomap.events.PhotoMapEvent;

/**
 * Created by farithjhg on 01/07/2016.
 */
public interface PhotoMapPresenter {
    void onCreate();
    void onDestroy();

    void subscribe();
    void unsubscribe();

    void onEventMainThread(PhotoMapEvent event);
}
