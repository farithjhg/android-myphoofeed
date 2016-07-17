package com.wolfsoft.android.myphotofeed.login;

/**
 * Created by farithjhg on 28/06/2016.
 */
public interface LoginRepository {
    void signUp(final String email, final String password);
    void signIn(String email, String password);
}
