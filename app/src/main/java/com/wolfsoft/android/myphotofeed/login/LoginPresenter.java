package com.wolfsoft.android.myphotofeed.login;

import com.wolfsoft.android.myphotofeed.login.events.LoginEvent;

/**
 * Created by farithjhg on 28/06/2016.
 */
public interface LoginPresenter {
    void onCreate();
    void onDestroy();
    void onEventMainThread(LoginEvent event);
    void login(String email, String password);
    void registerNewUser(String email, String password);
}
