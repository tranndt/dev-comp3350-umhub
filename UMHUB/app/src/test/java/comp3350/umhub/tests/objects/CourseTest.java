package comp3350.umhub.tests.objects;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import comp3350.umhub.objects.Course;
import comp3350.umhub.objects.Major;
import comp3350.umhub.objects.Program;

import static org.junit.Assert.*;

public class CourseTest {

    @Test
    public void testCourse1(){
        Course course, course1;
        Major major;
        Program program1, program2;
        List<Program> programList;

        System.out.println("\nStarting testCourse");
        major = new Major("Computer Science");
        programList = new ArrayList<>();
        program1 = new Program("Bachelor of Science - Computer Science","Computer Science");
        program2 = new Program("Bachelor of Computer Science Honors","Computer Science");
        programList.add(program1);
        programList.add(program2);

        course = new Course("COMP 3350", "Software Engineering", "Course to get you trained in industry standards of coding projects",3, "Computer Science");
        assertNotNull(course);
        assertTrue("Software Engineering".equals(course.getName()));
        assertTrue("COMP 3350".equals(course.getId()));
        assertTrue("Course to get you trained in industry standards of coding projects".equals(course.getDescription()));
        assertEquals(3,course.getYear());

        course1 = new Course("COMP1010","Not Software Engineering","This course is not SE",1,"Computer Science");
        assert(!course.equals(course1));
        course1 = new Course("COMP 3350", "Software Engineering", "Course to get you trained in industry standards of coding projects",3, "Computer Science");
        assert(course.equals(course1));
        System.out.println("Finished testCourse");
    }
}
