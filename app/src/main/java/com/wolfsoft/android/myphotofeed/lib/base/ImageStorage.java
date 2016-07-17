package com.wolfsoft.android.myphotofeed.lib.base;

import java.io.File;

/**
 * Created by farithjhg on 28/06/2016..
 */
public interface ImageStorage {
    String getImageUrl(String id);
    void upload(File file, String id, ImageStorageFinishedListener listener);
}
