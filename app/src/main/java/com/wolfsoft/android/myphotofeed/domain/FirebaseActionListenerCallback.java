package com.wolfsoft.android.myphotofeed.domain;

import com.firebase.client.FirebaseError;

/**
 * Created by farithjhg on 28/06/2016.
 */
public interface FirebaseActionListenerCallback {
    void onSuccess();
    void onError(FirebaseError error);
}
