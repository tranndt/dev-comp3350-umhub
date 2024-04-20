package comp3350.umhub.objects;

import java.text.DecimalFormat;

public class TutorRating {
    int _id;
    String email;
    String courseId;
    float rating;
    String username;

    public TutorRating(int _id, String email, String courseId, float rating, String username){
        this._id = _id;
        this.email = email;
        this.courseId = courseId;
        this.rating = rating;
        this.username = username;
    }

    public int get_id() {
        return _id;
    }

    public String getUsername() {
        return username;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getEmail() {
        return email;
    }

    public float getRating() {
        DecimalFormat df = new DecimalFormat("#.##");
        return Float.parseFloat(df.format(rating));
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

}
