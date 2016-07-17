package com.wolfsoft.android.myphotofeed.main;

import android.location.Location;

/**
 * Created by farithjhg on 29/06/2016.
 */
public interface UploadInteractor {
    void execute(Location location, String path);
}
