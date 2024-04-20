package comp3350.umhub.business;

import java.util.List;

import comp3350.umhub.objects.User;

public interface IAccessUsers {
    List<User> getAllUsers();
    User getUser(String uid);
    User getCurrentUser();

    void setCurrentUser(String username);

    void addUser(String username, String password);
}
