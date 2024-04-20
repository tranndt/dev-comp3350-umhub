package comp3350.umhub.objects;

public class CourseReview{
    int _id;
    String review;
    String userId;
    int score;
    String courseId;

    public static int MAX_REVIEW_SCORE = 5;
    public static int MIN_REVIEW_SCORE = 1;



    public int getId() {
        return _id;
    }

    public String getUser() {
        return userId;
    }

    public int getScore() {
        return score;
    }

    public String getReview() {
        return review;
    }

    public CourseReview(String courseId , String userId, String review, int score){
        this._id = 0;
        this.userId = userId;
        this.courseId = courseId;
        this.score = score;
        this.review = review;

    }

    public CourseReview(int id, String courseId , String userId, String review, int score){
        this._id = id;
        this.userId = userId;
        this.courseId = courseId;
        this.score = score;
        this.review = review;
    }

    public String getCourseId() {
        return courseId;
    }

    public boolean equals(CourseReview other){
        return this.getId() == other.getId();
    }


    @Override
    public String toString() {
        return "CourseReview{" +
                "id=" + _id +
                ", course=" + courseId +
                ", user=" + userId +
                ", score=" + score +
                ", desc1='" + review + '\'' +
                '}';
    }
}
