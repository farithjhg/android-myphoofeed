package com.wolfsoft.android.myphotofeed.login;

/**
 * Created by farithjhg on 29/06/2016.
 */
public class SignupInteractorImpl implements SignupInteractor {
    private LoginRepository loginRepository;

    public SignupInteractorImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public void execute(String email, String password) {
        loginRepository.signUp(email, password);
    }
}
