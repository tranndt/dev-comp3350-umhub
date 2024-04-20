package comp3350.umhub.persistence.interfaces;

import java.util.List;

import comp3350.umhub.objects.TutorEntry;
import comp3350.umhub.objects.TutorRating;

public interface ITutorPersistence {
    TutorEntry getTutorEntry(String email, String course);
    List<TutorEntry> getTutorEntriesSequential();
    List<TutorEntry> getTutorEntriesByCourse(String course);
    List<TutorEntry> getTutorEntriesByTutor(String email);
    void insertTutorEntry(String name, String email, String courseid, String type);

    //    float getTutorEntryAverageRating(String email, String course);
    List<TutorRating> getTutorRatingsSequential();
    List<TutorRating> getTutorRatingsByTutorEntry(String email, String courseid);
    void insertTutorRating(String email, String courseid, float rating, String user);
    void update(int id, String email, String courseId, float rating, String username);
}
