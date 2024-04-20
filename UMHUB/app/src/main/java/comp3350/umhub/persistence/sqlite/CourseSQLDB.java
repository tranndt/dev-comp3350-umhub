package comp3350.umhub.persistence.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import comp3350.umhub.application.Services;
import comp3350.umhub.objects.Course;
import comp3350.umhub.persistence.interfaces.ICoursePersistence;

public class CourseSQLDB implements ICoursePersistence {

    public static final String TABLE_COURSES = "COURSES";
    public static final String _ID = "_id";
    public static final String NAME = "NAME";
    public static final String DESCRIPTION = "DESCRIPTION";
    public static final String YEAR = "YEAR";
    public static final String MAJOR = "MAJOR";
    public static String[] COLUMNS_COURSES = {_ID, NAME, DESCRIPTION, YEAR, MAJOR};


    public static final String CP_COURSEID = "COURSEID";
    public static final String CP_PROGRAMID = "PROGRAMID";


    private SQLiteDatabase database; // may later implement as singleton
    public CourseSQLDB() {
        try {
            database = Services.getDatabase();
        } catch (DatabaseNotCreatedException e) {
            e.printStackTrace();
        }

    }


    @Override
    public Course getCourse(String courseId) {
        Course course = null;
        try {
            Cursor cursor = database.query(TABLE_COURSES, COLUMNS_COURSES, _ID + "='" + courseId+"'", null, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
                String id = cursor.getString(cursor.getColumnIndex(_ID));
                String name = cursor.getString(cursor.getColumnIndex(NAME));
                String description = cursor.getString(cursor.getColumnIndex(DESCRIPTION));
                int year = cursor.getInt(cursor.getColumnIndex(YEAR));
                String major = cursor.getString(cursor.getColumnIndex(MAJOR));
                course = new Course(id, name,description,year,major);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return course;
        }
    }

    @Override
    public List<Course> getCoursesSequential() {
        final List<Course> courses = new ArrayList<>();
        try {
            Cursor cursor = database.query(TABLE_COURSES, COLUMNS_COURSES, null, null, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
                do {
                    String id = cursor.getString(cursor.getColumnIndex(_ID));
                    String name = cursor.getString(cursor.getColumnIndex(NAME));
                    String description = cursor.getString(cursor.getColumnIndex(DESCRIPTION));
                    int year = cursor.getInt(cursor.getColumnIndex(YEAR));
                    String major = cursor.getString(cursor.getColumnIndex(MAJOR));
                    courses.add(new Course(id, name,description,year,major));
                } while (cursor.moveToNext());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return courses;
        }
    }

    @Override
    public List<Course> getCoursesByMajor(String myMajor) {
        final List<Course> courses = new ArrayList<>();
        try {
            String WHERE_CLAUSE = String.format("%s = '%s'",MAJOR,myMajor);
            Cursor cursor = database.query(TABLE_COURSES, COLUMNS_COURSES, WHERE_CLAUSE, null, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
                do {
                    String id = cursor.getString(cursor.getColumnIndex(_ID));
                    String name = cursor.getString(cursor.getColumnIndex(NAME));
                    String description = cursor.getString(cursor.getColumnIndex(DESCRIPTION));
                    int year = cursor.getInt(cursor.getColumnIndex(YEAR));
                    String major = cursor.getString(cursor.getColumnIndex(MAJOR));
                    courses.add(new Course(id, name,description,year,major));
                } while (cursor.moveToNext());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return courses;
        }
    }

    @Override
    public List<Course> getCoursesByYearMajor(String myMajor, int myYear) {
        final List<Course> courses = new ArrayList<>();
        try {
            String WHERE_CLAUSE = String.format("%s = '%s' and %s = %d",MAJOR,myMajor,YEAR,myYear);
            Cursor cursor = database.query(TABLE_COURSES, COLUMNS_COURSES, WHERE_CLAUSE, null, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
                do {
                    String id = cursor.getString(cursor.getColumnIndex(_ID));
                    String name = cursor.getString(cursor.getColumnIndex(NAME));
                    String description = cursor.getString(cursor.getColumnIndex(DESCRIPTION));
                    int year = cursor.getInt(cursor.getColumnIndex(YEAR));
                    String major = cursor.getString(cursor.getColumnIndex(MAJOR));
                    courses.add(new Course(id, name,description,year,major));
                } while (cursor.moveToNext());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return courses;
        }
    }

    @Override
    public List<Course> getCoursesByProgram(String program) {
        final List<Course> courses = new ArrayList<>();
        try {
            String rawQuery = String.format("SELECT * FROM COURSESPROGRAMS AS CP JOIN COURSES AS C ON CP.COURSEID=C._id WHERE %s = '%s'", CP_PROGRAMID,program);
            Cursor cursor = database.rawQuery(rawQuery,null);
            if (cursor != null) {
                cursor.moveToFirst();
                do {
                    String id = cursor.getString(cursor.getColumnIndex(_ID));
                    String name = cursor.getString(cursor.getColumnIndex(NAME));
                    String description = cursor.getString(cursor.getColumnIndex(DESCRIPTION));
                    int year = cursor.getInt(cursor.getColumnIndex(YEAR));
                    String major = cursor.getString(cursor.getColumnIndex(MAJOR));
                    courses.add(new Course(id, name,description,year,major));
                } while (cursor.moveToNext());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return courses;
        }
    }

    @Override
    public List<Course> getCoursesByYearProgram(String program, int myYear) {
        final List<Course> courses = new ArrayList<>();
        try {
            String rawQuery = String.format("SELECT * FROM COURSESPROGRAMS AS CP JOIN COURSES AS C ON CP.COURSEID=C._id WHERE %s = '%s' AND %s = %d", CP_PROGRAMID,program,YEAR,myYear);
            Cursor cursor = database.rawQuery(rawQuery,null);
            if (cursor != null) {
                cursor.moveToFirst();
                do {
                    String id = cursor.getString(cursor.getColumnIndex(_ID));
                    String name = cursor.getString(cursor.getColumnIndex(NAME));
                    String description = cursor.getString(cursor.getColumnIndex(DESCRIPTION));
                    int year = cursor.getInt(cursor.getColumnIndex(YEAR));
                    String major = cursor.getString(cursor.getColumnIndex(MAJOR));
                    courses.add(new Course(id, name,description,year,major));
                } while (cursor.moveToNext());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return courses;
        }
    }




    public void insert(String courseID, String name, String desc, int year, String major){
        ContentValues contentValue = new ContentValues();
        contentValue.put(_ID, courseID);
        contentValue.put(NAME,name);
        contentValue.put(DESCRIPTION, desc);
        contentValue.put(YEAR, year);
        contentValue.put(MAJOR, major);
        database.insert(TABLE_COURSES, null, contentValue);
    }

}

