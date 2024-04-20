package comp3350.umhub.persistence.stubs;

import java.util.ArrayList;
import java.util.List;

import comp3350.umhub.objects.Course;
import comp3350.umhub.persistence.interfaces.ICoursePersistence;

public class CoursePersistenceStub implements ICoursePersistence {
    List<Course> courses;

    public CoursePersistenceStub(){
        this.courses = new ArrayList<>();

        String major1 = "Computer Science";
        String major2 = "Mathematics";
        courses.add(new Course("COMP3350","Software Engineering","Random description",3,major1));
        courses.add(new Course("COMP3430","Operating Systems","Random description",3,major1));
        courses.add(new Course("MATH1500","Calculus 1","Random description",1,major2));
        courses.add(new Course("MATH1700","Calculus 2","Random description",1,major2));
        courses.add(new Course("COMP2150","Object Oriented Programming","Random description",2,major1));
        courses.add(new Course("COMP2160","Programming Practices","Random description",2,major1));
        courses.add(new Course("COMP4170","4000 Level Course","Random description",4,major1));
        courses.add(new Course("MATH4700","Calculus 4","Random description",4,major2));


    }

    @Override
    public Course getCourse(String courseId) {
        Course  course = null;
        for (Course c : courses) {
            if (c.getId().equals(courseId)) {
                course = c;
                break;
            }
        }
        return course;
    }

    @Override
    public List<Course> getCoursesSequential() {
        return courses;
    }

    @Override
    public List<Course> getCoursesByMajor(String major) {
        List<Course>  courses1 = new ArrayList<>();
        for (Course c : courses) {
            if (c.getMajor().equals(major)) courses1.add(c);
        }
        return courses1;
    }

    @Override
    public List<Course> getCoursesByProgram(String name) {
        return null;
    }

    @Override
    public List<Course> getCoursesByYearProgram(String name, int year) {
        return null;
    }

    @Override
    public List<Course> getCoursesByYearMajor(String major, int year) {
        List<Course>  courses1 = new ArrayList<>();
        for (Course c : courses) {
            if (c.getMajor().equals(major) && c.getYear() == year) courses1.add(c);
        }
        return courses1;
    }
}
