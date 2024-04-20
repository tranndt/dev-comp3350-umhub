package comp3350.umhub.business;
import java.util.ArrayList;
import java.util.List;

import comp3350.umhub.application.Services;
import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.CourseReview;
import comp3350.umhub.persistence.interfaces.ICourseReviewPersistence;

public class AccessCourseReviews implements IAccessCourseReviews {
    private ICourseReviewPersistence courseReviewPersistence;

    public AccessCourseReviews(){
        courseReviewPersistence = Services.getCourseReviewPersistence();
    }

    public AccessCourseReviews(final ICourseReviewPersistence persistence) {
        courseReviewPersistence = persistence;
    }

    @Override
    public List<CourseReview> getAllCourseReviews() {
        return courseReviewPersistence.getCourseReviewsSequential();
    }

    @Override
    public List<CourseReview> getCourseReviewByCourse(Course course) {
        if (course != null) return courseReviewPersistence.getCourseReviewsSequential(course.getId());
        return new ArrayList<>();

    }

    @Override
    public CourseReview getCourseReview(int id) {
        return courseReviewPersistence.getCourseReview(id);
    }

    @Override
    public void add(String courseID, String userID, String review, int score) {
        if (courseID != null && userID != null)
            courseReviewPersistence.insert(courseID,userID,review,score);
    }
}
