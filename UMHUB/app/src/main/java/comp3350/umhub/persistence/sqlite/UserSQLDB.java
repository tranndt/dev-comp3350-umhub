package comp3350.umhub.persistence.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import comp3350.umhub.application.Services;
import comp3350.umhub.objects.User;
import comp3350.umhub.persistence.interfaces.IUserPersistence;

public class UserSQLDB implements IUserPersistence {
    private SQLiteDatabase database;

    public static final String TABLE_USERS = "USERS";
    public static final String _ID = "_id";
    public static final String PASSWORD = "PASSWORD";
    public static final String[] COLUMNS = {_ID,PASSWORD};

    public UserSQLDB() {
        try {
            database = Services.getDatabase();
        } catch (DatabaseNotCreatedException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers(){
        final List<User> users = new ArrayList<>();
        try {
            Cursor cursor = database.query(TABLE_USERS, COLUMNS, null, null, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
                do {
                    String id = cursor.getString(cursor.getColumnIndex(_ID));
                    String password = cursor.getString(cursor.getColumnIndex(PASSWORD));
                    users.add(new User(id, password));
                } while (cursor.moveToNext());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return users;
        }
    }

    @Override
    public void insertUser(String username, String password){
            ContentValues contentValue = new ContentValues();
            contentValue.put(_ID, username);
            contentValue.put(PASSWORD, password);
            database.insert(TABLE_USERS, null, contentValue);
    }

    @Override
    public User getUser(String username){
        User user = null;
        try {
            String WHERE_CLAUSE = String.format("%s = '%s'", _ID, username);
            Cursor cursor = database.query(TABLE_USERS, COLUMNS, WHERE_CLAUSE, null, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
                String id = cursor.getString(cursor.getColumnIndex(_ID));
                String password = cursor.getString(cursor.getColumnIndex(PASSWORD));
                user = new User(id, password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return user;
        }
    }

    @Override
    public void delete(String username) {
        String WHERE_CLAUSE = String.format("%s = '%s'", _ID, username);
        database.delete(TABLE_USERS, WHERE_CLAUSE, null);
    }

}
