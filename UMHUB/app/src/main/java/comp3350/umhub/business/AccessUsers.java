package comp3350.umhub.business;

import java.util.ArrayList;
import java.util.List;

import comp3350.umhub.application.UserException;
import comp3350.umhub.objects.User;
import comp3350.umhub.persistence.interfaces.IUserPersistence;

public class AccessUsers implements IAccessUsers {
    User currentUser;
    IUserPersistence userPersistence;

    public AccessUsers(IUserPersistence iUserPersistence) {
        userPersistence = iUserPersistence;
    }

    @Override
    public User getCurrentUser() {
        return currentUser;
    }

    @Override
    public void setCurrentUser(String username) {
        currentUser = getUser(username);
    }

    @Override
    public void addUser(String username, String password) {
        if (username != null && password != null) {
            try {
                userPersistence.insertUser(username,password);
            } catch (UserException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            users = userPersistence.getAllUsers();
        } catch (UserException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User getUser(String uid) {
        User user = null;
        if (uid != null) {
            try {
                user = userPersistence.getUser(uid);
            } catch (UserException e) {
                System.out.printf("User %s not found\n",uid);
                e.printStackTrace();
            }
        }
        return user;
    }
}
