package comp3350.umhub.business;

import java.util.Comparator;

import comp3350.umhub.objects.TutorEntry;

public class ratingSorter implements Comparator<TutorEntry> {

    @Override
    public int compare(TutorEntry o1, TutorEntry o2) {
        return (int)(o2.getAverageRating()-o1.getAverageRating());
    }
}
