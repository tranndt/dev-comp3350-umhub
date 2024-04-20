package comp3350.umhub.tests.business;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import comp3350.umhub.business.AccessCourses;
import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.Major;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AccessCoursesIT {

    private AccessCourses accessCourses;
    @Before
    public void setUp(){
        this.accessCourses = new AccessCourses();
    }


    @Test
    public void getCoursesByMajorTest(){
        System.out.println("\nStarting Access Course integration test - getCoursesByMajorTest");

        Major major = new Major("Computer Science");

        List<Course> courses = accessCourses.getCoursesByMajor(major);

        assertNotNull("Courses list should not be null", courses);
        assert(courses.size()!=0);

        assertEquals("COMP1010", courses.get(0).getName());

        System.out.println("Finished Access Course integration test - getCoursesByMajorTest");

    }
}
