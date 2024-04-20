package comp3350.umhub.business;

import javax.security.auth.login.LoginException;

import comp3350.umhub.application.Services;
import comp3350.umhub.application.SignUpException;
import comp3350.umhub.objects.User;

public class Login implements ILogin{
    private IAccessUsers iAccessUsers;

    public Login()
    {
        iAccessUsers = Services.getAccessUsers();
    }

    public Login(final IAccessUsers accessUsers)
    {
        this.iAccessUsers = accessUsers;
    }

    @Override
    public void signUp(String username, String password) throws SignUpException {
        try {
            User user = iAccessUsers.getUser(username);
            if (user != null) {
                throw new SignUpException("Username is already taken !");
            }
        }catch(Exception e){
            throw new SignUpException("Error checking if username has been taken");
        }
        try {
            iAccessUsers.addUser(username,password);
        }catch(Exception e){
            throw new SignUpException("Error adding user to signed-up users");
        }
    }


    @Override
    public void login(String username, String password) throws LoginException {
        try {
            User user = iAccessUsers.getUser(username);
            if (user == null || !user.getPassword().equals(password)) {
                throw new LoginException("Invalid username or password");
            } else {
                iAccessUsers.setCurrentUser(username);
            }
        }catch(Exception e){
            throw new LoginException("Invalid username or password");
        }
    }


}


