package comp3350.umhub.persistence.stubs;

import java.util.ArrayList;
import java.util.List;

import comp3350.umhub.objects.TutorEntry;
import comp3350.umhub.objects.TutorRating;
import comp3350.umhub.persistence.interfaces.ITutorPersistence;

public class TutorPersistenceStub implements ITutorPersistence {
    private List<TutorEntry> tutorEntries;

    public TutorPersistenceStub(){
        this.tutorEntries = new ArrayList<>();


        tutorEntries.add(new TutorEntry("Cool","cool@umhub.ca","COMP 3350","Professor"));
        tutorEntries.add(new TutorEntry("Tall","tall@umanitoba.ca","COMP 3350","TA"));
        tutorEntries.add(new TutorEntry("Middle","middle@umanitoba.ca","COMP 3350","TA"));
        tutorEntries.add(new TutorEntry("Short","short@umanitoba.ca","COMP 1010","Professor"));
        tutorEntries.add(new TutorEntry("Grumpy","grumps@umanitoba.ca","COMP 1010","Professor"));
        tutorEntries.add(new TutorEntry("Awesome","awsm@umanitoba.ca","MATH 1500","TA"));
        tutorEntries.add(new TutorEntry("Nice","noice@umanitoba.ca","MATH 1500","Professor"));
        tutorEntries.add(new TutorEntry("Angry","angry@umanitoba.ca","MATH 1700","TA"));
        tutorEntries.add(new TutorEntry("Funny","funyan@umanitoba.ca","MATH 1700","Professor"));
        tutorEntries.add(new TutorEntry("Smart","smarties@umanitoba.ca","COMP 3430","Professor"));
        tutorEntries.add(new TutorEntry("Sleepy","sleepy@umanitoba.ca","COMP 3430","TA"));
    }

    public List<TutorEntry> getTutorEntries() {
        return tutorEntries;
    }

    @Override
    public TutorEntry getTutorEntry(String email, String course) {
        return null;
    }

    @Override
    public List<TutorEntry> getTutorEntriesSequential() {
        return tutorEntries;
    }

    @Override
    public List<TutorEntry> getTutorEntriesByCourse(String course) {
        List<TutorEntry> byCourse = new ArrayList<>();
        for(int i=0; i<tutorEntries.size();i++){
            if(tutorEntries.get(i).getCourse().compareTo(course)==0){
                byCourse.add(tutorEntries.get(i));
            }
        }
        return byCourse;
    }

    @Override
    public List<TutorEntry> getTutorEntriesByTutor(String email) {
        List<TutorEntry> byEmail = new ArrayList<>();
        for(int i=0; i<tutorEntries.size();i++){
            if(tutorEntries.get(i).getEmail().compareTo(email)==0){
                byEmail.add(tutorEntries.get(i));
            }
        }
        return byEmail;
    }

    @Override
    public void insertTutorEntry(String name, String email, String courseid, String type) {
        tutorEntries.add(new TutorEntry(name,email,courseid,type));
    }

    @Override
    public List<TutorRating> getTutorRatingsSequential() {
        return null;
    }

    @Override
    public List<TutorRating> getTutorRatingsByTutorEntry(String email, String courseid) {
        return null;
    }

    @Override
    public void insertTutorRating(String email, String courseid, float rating, String user) {

    }

    @Override
    public void update(int id, String email, String courseId, float rating, String username) {

    }
}
