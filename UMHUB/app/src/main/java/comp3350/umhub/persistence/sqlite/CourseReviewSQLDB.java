package comp3350.umhub.persistence.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import comp3350.umhub.application.Services;
import comp3350.umhub.objects.CourseReview;
import comp3350.umhub.persistence.interfaces.ICourseReviewPersistence;

public class CourseReviewSQLDB implements ICourseReviewPersistence {
    public static final String TABLE_NAME = "COURSEREVIEWS";
    public static final String _ID = "_id";
    public static final String COURSEID = "COURSEID";
    public static final String REVIEW = "REVIEW";
    public static final String SCORE = "SCORE";
    public static final String USERID = "USERID";

    public static String[] ALL_COLUMNS = {_ID, COURSEID, USERID, REVIEW, SCORE};

    private SQLiteDatabase database;

    public CourseReviewSQLDB() {
        try {
            database = Services.getDatabase();
        } catch (DatabaseNotCreatedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public CourseReview getCourseReview(int id) {
        CourseReview courseReview = null;
        try {
            String WHERE_CLAUSE = String.format("%s = %d",_ID,id);
            Cursor cursor = database.query(TABLE_NAME, ALL_COLUMNS, WHERE_CLAUSE, null, null, null, null);
            if (cursor != null) {
                cursor.moveToFirst();
                int _id = cursor.getInt(cursor.getColumnIndex(_ID));
                String courseId = cursor.getString(cursor.getColumnIndex(COURSEID));
                String userId = cursor.getString(cursor.getColumnIndex(USERID));
                int score = cursor.getInt(cursor.getColumnIndex(SCORE));
                String review = cursor.getString(cursor.getColumnIndex(REVIEW));
                courseReview = new CourseReview(_id,courseId,userId,review,score);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return courseReview;
        }
    }

    @Override
    public List<CourseReview> getCourseReviewsSequential() {
        final List<CourseReview> courseReviews = new ArrayList<>();
        try {
            Cursor cursor = database.query(TABLE_NAME, ALL_COLUMNS,null,null,null,null,null);
            if (cursor != null) {
                cursor.moveToFirst();
                do {
                    int _id = cursor.getInt(cursor.getColumnIndex(_ID));
                    String courseId = cursor.getString(cursor.getColumnIndex(COURSEID));
                    String userId = cursor.getString(cursor.getColumnIndex(USERID));
                    int score = cursor.getInt(cursor.getColumnIndex(SCORE));
                    String review = cursor.getString(cursor.getColumnIndex(REVIEW));
                    courseReviews.add(new CourseReview(_id,courseId,userId,review,score));
                } while (cursor.moveToNext());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }    finally {
            return courseReviews;
        }
    }

    @Override
    public List<CourseReview> getCourseReviewsSequential(String myCourseId) {
        final List<CourseReview> courseReviews = new ArrayList<>();
        try {
            Cursor cursor = database.query(TABLE_NAME, ALL_COLUMNS,COURSEID + "= '" + myCourseId +"'",null,null,null,null);
            if (cursor != null) {
                cursor.moveToFirst();
                do {
                    int _id = cursor.getInt(cursor.getColumnIndex(_ID));
                    String courseId = cursor.getString(cursor.getColumnIndex(COURSEID));
                    String userId = cursor.getString(cursor.getColumnIndex(USERID));
                    int score = cursor.getInt(cursor.getColumnIndex(SCORE));
                    String review = cursor.getString(cursor.getColumnIndex(REVIEW));
                    courseReviews.add(new CourseReview(_id,courseId,userId,review,score));
                } while (cursor.moveToNext());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }    finally {
            return courseReviews;
        }
    }

    @Override
    public void insert(String courseID, String userID, String review, int reviewScore) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(COURSEID, courseID);
        contentValue.put(USERID, userID);
        contentValue.put(REVIEW, review);
        contentValue.put(SCORE,reviewScore);
        database.insert(TABLE_NAME, null, contentValue);
    }


    public int update(long _id, String courseID, String review) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COURSEID, courseID);
        contentValues.put(REVIEW, review);
        int i = database.update(TABLE_NAME, contentValues, _ID + " = " + _id, null);
        return i;
    }

    public void delete(long _id) {
        database.delete(TABLE_NAME, _ID + "=" + _id, null);
    }


}

