package comp3350.umhub.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import comp3350.umhub.application.Services;
import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.TutorEntry;
import comp3350.umhub.objects.TutorRating;
import comp3350.umhub.objects.User;
import comp3350.umhub.persistence.interfaces.ITutorPersistence;

public class AccessTutors implements IAccessTutors{
    ITutorPersistence tutorPersistence;

    public AccessTutors(){
        tutorPersistence = Services.getTutorPersistence();

    }

    public AccessTutors(final ITutorPersistence persistence){
        tutorPersistence = persistence;
    }

    @Override
    public List<TutorEntry> getAllTutorEntries() {
        List<TutorEntry> list = tutorPersistence.getTutorEntriesSequential();
        Collections.sort(list,new ratingSorter());
        return list;
    }

    @Override
    public TutorEntry getTutorEntry(String email, String course) {
        if (email != null && course != null) return tutorPersistence.getTutorEntry(email,course);
        return null;
    }

    @Override
    public List<TutorEntry> getTutorEntriesByCourse(Course course) {
        List<TutorEntry> list = new ArrayList<>();
        if (course != null) {
           list = tutorPersistence.getTutorEntriesByCourse(course.getId());
            Collections.sort(list, new ratingSorter());
        }
        return list;
    }

    @Override
    public List<TutorEntry> getTutorEntriesByTutor(String email) {
        if (email != null) return tutorPersistence.getTutorEntriesByCourse(email);
        return new ArrayList<>();
    }

    @Override
    public void addTutorEntry(TutorEntry entry) {
        if (entry != null)
            tutorPersistence.insertTutorEntry(entry.getName(),entry.getEmail(),entry.getCourse(),entry.getType());
    }

    @Override
    public List<TutorRating> getAllTutorRatings() {
        List<TutorRating> ratings = tutorPersistence.getTutorRatingsSequential();
        if (ratings != null)
            return ratings;
        else
            return new ArrayList<>();

    }

    @Override
    public List<TutorRating> getTutorRatings(TutorEntry entry) {
        if (entry != null) return tutorPersistence.getTutorRatingsByTutorEntry(entry.getEmail(),entry.getCourse());
        return new ArrayList<>();
    }

    @Override
    public TutorRating getTutorRatingsByUser(TutorEntry entry, User user) {
        TutorRating tutorRating = null;
        List<TutorRating> ratings = getTutorRatings(entry);
        for (TutorRating rating : ratings) {
            if (rating.getUsername().equals(user.getUsername())){
                tutorRating = rating;
                break;
            }
        }
        return tutorRating;
    }


    @Override
    public float getAverageRating(TutorEntry entry){
        List<TutorRating> ratings = getTutorRatings(entry);
        float sum = 0, avg = 0;
        for (TutorRating rating: ratings) {
            sum += rating.getRating();
        }
        avg = sum/ratings.size();
        return avg;
    }

    @Override
    public void addTutorRating(TutorEntry entry, User currentUser, float rating) {
        if (entry != null)
            tutorPersistence.insertTutorRating(entry.getEmail(),entry.getCourse(),rating,currentUser.getUsername());
    }


    @Override
    public void updateTutorRating(TutorRating tutorRating) {
        if (tutorRating != null)
            tutorPersistence.update(tutorRating.get_id(), tutorRating.getEmail(),tutorRating.getCourseId(),tutorRating.getRating(),tutorRating.getUsername());
    }


}
