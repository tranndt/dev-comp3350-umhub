package comp3350.umhub.objects;

import comp3350.umhub.application.Services;

public class TutorEntry {
    private String name;
    private String email;
    private String course;
    private String type;

    public TutorEntry(String name, String email, String course, String type){
        this.name = name;
        this.email = email;
        this.course = course;
        this.type = type;
    }

    public TutorEntry(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public float getAverageRating(){
        return Services.getAccessTutors().getAverageRating(this);
    }

    public String getType() {
        return type;
    }

    public String displayName(){
        return type+" "+name;
    }


    public String getCourse() {
        return course;
    }


}
