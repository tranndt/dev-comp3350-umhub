package comp3350.umhub.tests.business;


import org.junit.Before;
import org.junit.Test;

import java.util.List;

import comp3350.umhub.business.AccessCourses;
import comp3350.umhub.business.IAccessCourses;
import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.Major;
import comp3350.umhub.persistence.interfaces.ICoursePersistence;
import comp3350.umhub.persistence.stubs.CoursePersistenceStub;

import static org.junit.Assert.assertEquals;


public class AccessCoursesTest {
    private IAccessCourses accessCourses;

    @Before
    public void setUp(){
        ICoursePersistence persistence = new CoursePersistenceStub();
        accessCourses = new AccessCourses(persistence);
    }


    @Test
    public void testGetAllCoursesByMajor(){
        System.out.println("\nStarting test AccessCourses - get all courses by major");
        Major major = new Major("Computer Science");
        List<Course> courses = accessCourses.getCoursesByMajor(major);
        for(int i=0; i<courses.size(); i++){
            assertEquals(major.getName(),courses.get(i).getMajor());
        }
        System.out.println("Finished test AccessCourses - get all courses by major");
    }

    @Test
    public void testGetCoursesByYearMajor(){
        System.out.println("\nStarting test AccessCourses - get courses by year and program");
        Major major = new Major("Mathematics");
        List<Course> courses = accessCourses.getCoursesByYearMajor(major,1);
        for(int i=0; i<courses.size();i++){
            assertEquals(1,courses.get(i).getYear());
        }

        courses = accessCourses.getCoursesByYearMajor(major,2);
        for(int i=0; i<courses.size();i++){
            assertEquals(2,courses.get(i).getYear());
        }

        courses = accessCourses.getCoursesByYearMajor(major,3);
        for(int i=0; i<courses.size();i++){
            assertEquals(3,courses.get(i).getYear());
        }

        courses = accessCourses.getCoursesByYearMajor(major,4);
        for(int i=0; i<courses.size();i++){
            assertEquals(4,courses.get(i).getYear());
        }
        System.out.println("Finished test AccessCourses - get courses by year and program");
    }

}
