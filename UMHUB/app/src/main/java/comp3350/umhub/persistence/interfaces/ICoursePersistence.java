package comp3350.umhub.persistence.interfaces;

import java.util.List;

import comp3350.umhub.objects.Course;

public interface ICoursePersistence {
    Course getCourse(String courseId);
    List<Course> getCoursesSequential();
    List<Course> getCoursesByMajor(String major);
    List<Course> getCoursesByProgram(String name);
    List<Course> getCoursesByYearProgram(String name, int year);
    List<Course> getCoursesByYearMajor(String name, int year);
}
