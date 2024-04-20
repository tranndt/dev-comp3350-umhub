package comp3350.umhub.business;

import java.util.Comparator;

import comp3350.umhub.objects.Course;

public class courseSorter implements Comparator<Course> {

    @Override
    public int compare(Course o1, Course o2) {
        int value = o1.getYear() - o2.getYear();
        if(value==0){
            value = o1.getId().compareTo(o2.getId());
        }
        return value;
    }
}
