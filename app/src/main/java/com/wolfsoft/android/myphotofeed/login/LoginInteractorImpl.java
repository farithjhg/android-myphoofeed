package com.wolfsoft.android.myphotofeed.login;

/**
 * Created by farithjhg on 29/06/2016.
 */
public class LoginInteractorImpl implements LoginInteractor {
    private LoginRepository loginRepository;

    public LoginInteractorImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public void execute(String email, String password) {
        loginRepository.signIn(email, password);
    }
}
