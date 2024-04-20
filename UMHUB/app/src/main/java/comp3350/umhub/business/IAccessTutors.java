package comp3350.umhub.business;

import java.util.List;

import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.TutorEntry;
import comp3350.umhub.objects.TutorRating;
import comp3350.umhub.objects.User;

public interface IAccessTutors {
//    List<TutorEntry> getTutors(Course courseSelected);

    TutorEntry getTutorEntry(String email, String course);
    List<TutorEntry> getAllTutorEntries();
    List<TutorEntry> getTutorEntriesByCourse(Course course);
    List<TutorEntry> getTutorEntriesByTutor(String email);
    void addTutorEntry(TutorEntry entry);

    List<TutorRating> getAllTutorRatings();
    List<TutorRating> getTutorRatings(TutorEntry entry);
    TutorRating getTutorRatingsByUser(TutorEntry entry, User user);
    float getAverageRating(TutorEntry entry);
    void addTutorRating(TutorEntry entry, User currentUser, float rating);
    void updateTutorRating(TutorRating tutorRating);
}
