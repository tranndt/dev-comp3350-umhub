package comp3350.umhub.business;

import javax.security.auth.login.LoginException;

import comp3350.umhub.application.SignUpException;

public interface ILogin {
    void signUp(String username, String password) throws SignUpException;
    void login(String username, String password) throws LoginException;
}
