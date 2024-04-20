package comp3350.umhub.persistence.stubs;

import java.util.ArrayList;
import java.util.List;

import comp3350.umhub.objects.CourseReview;
import comp3350.umhub.persistence.interfaces.ICourseReviewPersistence;

public class CourseReviewPersistenceStub implements ICourseReviewPersistence {
    int id = 1;
    List<CourseReview> courseReviews;

    public CourseReview getCourseReview(int id) {
        CourseReview courseReview = null;
        for (CourseReview review : courseReviews) {
            if (review.getId() == id){
                courseReview = review;
                break;
            }
        }
        return courseReview;
    }

    @Override
    public List<CourseReview> getCourseReviewsSequential() {
        return courseReviews;
    }

    @Override
    public List<CourseReview> getCourseReviewsSequential(String courseId) {
        List<CourseReview>  courseReviews1= new ArrayList<>();
        for (CourseReview review : courseReviews) {
            if (review.getCourseId().equals(courseId)) courseReviews1.add(review);
        }
        return courseReviews1;
    }

    @Override
    public void insert(String courseID, String userID, String review, int reviewScore) {
        if (courseID != null && userID != null && review != null
                && reviewScore >= CourseReview.MIN_REVIEW_SCORE && reviewScore<= CourseReview.MAX_REVIEW_SCORE)
            courseReviews.add(new CourseReview(id++,courseID,userID,review,reviewScore));
    }

    public CourseReviewPersistenceStub(){
        this.courseReviews = new ArrayList<>();
        String comp3350 = "COMP 3350";
        String comp3170 = "COMP 3170";
        String comp3430 = "COMP 3430";
        String comp3010 = "COMP 3010";
        String u1 = "u1";
        String u2 = "u2";
        String u3 = "u3";
        String u4 = "u4";
        insert(comp3350,u1,"Awesome",5);
        insert(comp3170,u1,"Nice",5);
        insert(comp3010,u1,"Awesome",5);
        insert(comp3430,u2,"Awesome",5);
        insert(comp3170,u2,"Great",5);
        insert(comp3350,u2,"Awesome",5);
        insert(comp3350,u3,"Excellent",5);
        insert(comp3010,u3,"Loved it",5);
        insert(comp3430,u3,"Awesome",5);
        insert(comp3010,u4,"Awesome",5);
        insert(comp3170,u4,"Ugh",2);
        insert(comp3350,u4,"Awesome",5);

    }

    public String toString(){
        String res = this.getClass().toString() + "\n";
        if (courseReviews != null){
            for (CourseReview c: courseReviews) {
                res += c.toString() + "\n";
            }
        }
        return res;
    }

}
