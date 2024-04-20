package comp3350.umhub.persistence.stubs;
import java.util.ArrayList;
import java.util.List;

import comp3350.umhub.objects.User;
import comp3350.umhub.persistence.interfaces.IUserPersistence;

public class UserPersistenceStub implements IUserPersistence {
    List<User> users;

    public UserPersistenceStub() {
        users = new ArrayList<>();
        users.add(new User("admin","123456"));
        users.add(new User("admin1","123456"));
        users.add(new User("admin2","123456"));
        users.add(new User("admin3","123456"));

    }

    @Override
    public void insertUser(String username, String password) {
        users.add(new User(username, password));
    }

    @Override
    public void delete(String username) {
        for (int i = 0; i < users.size(); i++) {
            User temp = users.get(i);
            if (temp.getUsername().equals(username))
                users.remove(i);
        }
    }


    @Override
    public User getUser(String username) {
        for (int i = 0; i < users.size(); i++) {
            User temp = users.get(i);
            if (temp.getUsername().equals(username))
                return temp;
        }
        return null;
    }

    public List<User> getAllUsers() {
        return users;
    }

}

