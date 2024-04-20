package comp3350.umhub.business;


import java.util.List;

import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.CourseReview;

public interface IAccessCourseReviews {
    List<CourseReview> getAllCourseReviews();
    List<CourseReview> getCourseReviewByCourse(Course course);
    CourseReview getCourseReview(int id);
    void add(String courseID, String userID, String review, int score);
}
