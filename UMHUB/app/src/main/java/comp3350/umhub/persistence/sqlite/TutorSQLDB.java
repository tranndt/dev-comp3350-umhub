package comp3350.umhub.persistence.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import comp3350.umhub.application.Services;
import comp3350.umhub.objects.TutorEntry;
import comp3350.umhub.objects.TutorRating;
import comp3350.umhub.persistence.interfaces.ITutorPersistence;

public class TutorSQLDB implements ITutorPersistence {
//    public static final String TABLE_TUTORS = "TUTORS";
    public static final String TABLE_TUTORENTRIES = "TUTORENTRIES ";
    public static final String TABLE_TUTORRATINGS= "TUTORRATINGS";

    public static final String _ID = "_id";
    public static final String EMAIL = "EMAIL";
    public static final String NAME = "NAME";
    public static final String COURSEID = "COURSEID";
    public static final String USERID = "USERID";
    public static final String TYPE = "TYPE";
    public static final String RATING = "RATING";

//    public static String[] COLUMNS_TUTORS = {NAME,EMAIL};
    public static String[] COLUMNS_TUTORENTRIES = {NAME,EMAIL, COURSEID,TYPE};
    public static String[] COLUMNS_TUTORRATINGS = {_ID,EMAIL,COURSEID,RATING,USERID};

    private SQLiteDatabase database;

    public TutorSQLDB() {
        try {
            database = Services.getDatabase();
        } catch (DatabaseNotCreatedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public TutorEntry getTutorEntry(String email, String course) {
        TutorEntry tutorEntry = null;
        try {
            String WHERE_CLAUSE = String.format("%s = '%s' and %s = '%s'", EMAIL, email, COURSEID, course);
            Cursor cursor = database.query(TABLE_TUTORENTRIES, COLUMNS_TUTORENTRIES, WHERE_CLAUSE, null, null, null, null);

            if (cursor != null) {
                cursor.moveToFirst();
                String myemail = cursor.getString(cursor.getColumnIndex(EMAIL));
                String name = cursor.getString(cursor.getColumnIndex(NAME));
                String courseid = cursor.getString(cursor.getColumnIndex(COURSEID));
                String type = cursor.getString(cursor.getColumnIndex(TYPE));
                tutorEntry = new TutorEntry(name,myemail,courseid,type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return tutorEntry;
        }
    }

    @Override
    public List<TutorEntry> getTutorEntriesSequential() {
        final List<TutorEntry> tutorEntries = new ArrayList<>();
        try {
            Cursor cursor = database.query(TABLE_TUTORENTRIES, COLUMNS_TUTORENTRIES, null, null, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
                do {
                    String email = cursor.getString(cursor.getColumnIndex(EMAIL));
                    String name = cursor.getString(cursor.getColumnIndex(NAME));
                    String courseid = cursor.getString(cursor.getColumnIndex(COURSEID));
                    String type = cursor.getString(cursor.getColumnIndex(TYPE));
                    tutorEntries.add(new TutorEntry(name,email,courseid,type));
                } while (cursor.moveToNext());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return tutorEntries;
        }
    }

    @Override
    public List<TutorRating> getTutorRatingsSequential() {
        final List<TutorRating> tutorRatings = new ArrayList<>();
        try {
            Cursor cursor = database.query(TABLE_TUTORRATINGS, COLUMNS_TUTORRATINGS, null, null, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
                do {
                    int _id = cursor.getInt(cursor.getColumnIndex(_ID));
                    String email = cursor.getString(cursor.getColumnIndex(EMAIL));
                    String courseid = cursor.getString(cursor.getColumnIndex(COURSEID));
                    float rating = cursor.getFloat(cursor.getColumnIndex(RATING));
                    String userid = cursor.getString(cursor.getColumnIndex(USERID));
                    tutorRatings.add(new TutorRating(_id,email,courseid,rating,userid));
                } while (cursor.moveToNext());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return tutorRatings;
        }
    }

    @Override
    public List<TutorRating> getTutorRatingsByTutorEntry(String email, String courseid) {
        List<TutorRating> tutorRatings = new ArrayList<>();
        try {
            String WHERE_CLAUSE = String.format("EMAIL = '%s' AND COURSEID = '%s';",email, courseid);
            Cursor cursor = database.query(TABLE_TUTORRATINGS, COLUMNS_TUTORRATINGS, WHERE_CLAUSE, null, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
                do {
                    int _id = cursor.getInt(cursor.getColumnIndex(_ID));
                    String email1 = cursor.getString(cursor.getColumnIndex(EMAIL));
                    String courseid1 = cursor.getString(cursor.getColumnIndex(COURSEID));
                    float rating = cursor.getFloat(cursor.getColumnIndex(RATING));
                    String userid = cursor.getString(cursor.getColumnIndex(USERID));
                    tutorRatings.add(new TutorRating(_id,email,courseid,rating,userid));
                } while (cursor.moveToNext());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return tutorRatings;
        }
    }

    @Override
    public List<TutorEntry> getTutorEntriesByCourse(String course) {
        final List<TutorEntry> tutorEntries = new ArrayList<>();
        try {
            String WHERE_CLAUSE = String.format("%s = '%s'", COURSEID, course);
            Cursor cursor = database.query(TABLE_TUTORENTRIES, COLUMNS_TUTORENTRIES, WHERE_CLAUSE, null, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
                do {
                    String email = cursor.getString(cursor.getColumnIndex(EMAIL));
                    String name = cursor.getString(cursor.getColumnIndex(NAME));
                    String courseid = cursor.getString(cursor.getColumnIndex(COURSEID));
                    String type = cursor.getString(cursor.getColumnIndex(TYPE));
                    tutorEntries.add(new TutorEntry(name,email,courseid,type));
                } while (cursor.moveToNext());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return tutorEntries;
        }
    }

    @Override
    public List<TutorEntry> getTutorEntriesByTutor(String email) {
        final List<TutorEntry> tutorEntries = new ArrayList<>();
        try {
            String WHERE_CLAUSE = String.format("%s = '%s'", EMAIL, email);
            Cursor cursor = database.query(TABLE_TUTORENTRIES, COLUMNS_TUTORENTRIES, WHERE_CLAUSE, null, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
                do {
                    String email1 = cursor.getString(cursor.getColumnIndex(EMAIL));
                    String name = cursor.getString(cursor.getColumnIndex(NAME));
                    String courseid = cursor.getString(cursor.getColumnIndex(COURSEID));
                    String type = cursor.getString(cursor.getColumnIndex(TYPE));
                    tutorEntries.add(new TutorEntry(name,email1,courseid,type));
                } while (cursor.moveToNext());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return tutorEntries;
        }
    }




    public float getTutorEntryAverageRating(String email, String course) {
        float avgRating = 1f;
        try {
            String rawQuery = "SELECT E.NAME, E.EMAIL, E.COURSEID, E.TYPE, AVG(R.RATING) FROM TUTORRATINGS AS R JOIN TUTORENTRIES AS E ON E.EMAIL = R.EMAIL AND E.COURSEID = R.COURSEID" +
            String.format("WHERE E.EMAIL= '%s' AND E.COURSEID = '%s';",email, course) + " GROUP BY E.EMAIL,E.COURSEID ;" ;
            Cursor cursor = database.rawQuery(rawQuery, null);
            if (cursor != null) {
                cursor.moveToFirst();
                do {
                    avgRating = cursor.getFloat(cursor.getColumnIndex("AVG(R.RATING)"));
                } while (cursor.moveToNext());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return avgRating;
        }
    }

    @Override
    public void insertTutorRating(String email, String courseid, float rating, String user){
        ContentValues contentValue = new ContentValues();
        contentValue.put(EMAIL, email);
        contentValue.put(COURSEID, courseid);
        contentValue.put(RATING, rating);
        contentValue.put(USERID,user);
        database.insert(TABLE_TUTORRATINGS, null, contentValue);
    }

    @Override
    public void update(int id, String email, String courseId, float rating, String username) {
        String WHERE_CLAUSE = _ID + " = " + id;
        ContentValues contentValues = new ContentValues();
        contentValues.put(EMAIL, email);
        contentValues.put(COURSEID, courseId);
        contentValues.put(RATING, rating);
        contentValues.put(USERID,username);
        database.update(TABLE_TUTORRATINGS, contentValues, WHERE_CLAUSE, null);
    }

    @Override
    public void insertTutorEntry(String name, String email, String courseid, String type) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(EMAIL, email);
        contentValue.put(COURSEID, courseid);
        contentValue.put(NAME, name);
        contentValue.put(TYPE,type);
        database.insert(TABLE_TUTORENTRIES, null, contentValue);
    }



}
