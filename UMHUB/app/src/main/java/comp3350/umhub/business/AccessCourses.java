package comp3350.umhub.business;


import java.util.Collections;
import java.util.List;

import comp3350.umhub.application.Services;
import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.Major;
import comp3350.umhub.objects.Program;
import comp3350.umhub.persistence.interfaces.ICoursePersistence;

public class AccessCourses implements IAccessCourses {
    private ICoursePersistence coursePersistence;
    private List<Course> courses;


    public AccessCourses( ){
        coursePersistence = Services.getCoursePersistence();
    }

    public AccessCourses( final ICoursePersistence persistence) {
        coursePersistence = persistence;
    }

    @Override
    public Course getCourse(String courseId) {
        if (courseId != null) return coursePersistence.getCourse(courseId);
        return null;
    }

    @Override
    public List<Course> getAllCourses() {
        courses = coursePersistence.getCoursesSequential();
        Collections.sort(courses,new courseSorter());
        return courses;
    }

    @Override
    public List<Course> getCoursesByProgram(Program program) {
        if (program != null){
            courses = coursePersistence.getCoursesByProgram(program.getName());
            Collections.sort(courses,new courseSorter());
        }

        return courses;
    }

    @Override
    public List<Course> getCoursesByYearProgram(Program program, int year) {
        if (program != null){
            courses = coursePersistence.getCoursesByYearProgram(program.getName(),year);
            Collections.sort(courses, new courseSorter());
        }
        return courses;
    }

    @Override
    public List<Course> getCoursesByMajor(Major major) {
        if (major != null){
            courses = coursePersistence.getCoursesByMajor(major.getName());
            Collections.sort(courses,new courseSorter());
        }
        return courses;
    }

    @Override
    public List<Course> getCoursesByYearMajor(Major major, int year) {
        if (major != null) return coursePersistence.getCoursesByYearMajor(major.getName(),year);
        return null;
    }

}
