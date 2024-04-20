package comp3350.umhub.persistence.sqlite;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import comp3350.umhub.application.Services;
import comp3350.umhub.objects.Major;
import comp3350.umhub.persistence.interfaces.IMajorPersistence;

public class MajorSQLDB implements IMajorPersistence {
    public static final String TABLE_MAJORS = "MAJORS";
    public static final String _ID = "_id";
    public static String[] COLUMNS = {_ID};
    private SQLiteDatabase database;

    public MajorSQLDB() {
        try {
            database = Services.getDatabase();
        } catch (DatabaseNotCreatedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Major> getMajorsSequential() {
        final List<Major> majors = new ArrayList<>();
        try {
            Cursor cursor = database.query(TABLE_MAJORS, COLUMNS, null, null, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
                do {
                    String id = cursor.getString(cursor.getColumnIndex(_ID));
                    majors.add(new Major(id));
                } while (cursor.moveToNext());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return majors;
        }
    }

    @Override
    public Major getMajor(String majorName) {
        Major major = null;
        try {
            String WHERE_CLAUSE = String.format("%s = '%s'", _ID, majorName);
            Cursor cursor = database.query(TABLE_MAJORS, COLUMNS, WHERE_CLAUSE, null, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
                String id = cursor.getString(cursor.getColumnIndex(_ID));
                major = new Major(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return major;
        }
    }



}
