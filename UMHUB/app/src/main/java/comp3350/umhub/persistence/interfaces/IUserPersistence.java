package comp3350.umhub.persistence.interfaces;

import java.util.List;

import comp3350.umhub.application.UserException;
import comp3350.umhub.objects.User;

public interface IUserPersistence {
    void insertUser(String username, String password) throws UserException;
    User getUser(String username) throws UserException;
    List<User> getAllUsers() throws UserException;

    void delete(String username);
}



