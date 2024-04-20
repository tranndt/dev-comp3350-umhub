package comp3350.umhub.tests.objects;

import org.junit.Test;

import comp3350.umhub.objects.Program;

import static org.junit.Assert.*;


public class ProgramTest {

    @Test
    public void testProgram1(){
        Program program, program1;

        System.out.println("\nStarting testProgram");
        program = new Program("Bachelor of Science Major - Computer Science", "Computer Science");

        assertNotNull(program);
        assertEquals("Bachelor of Science Major - Computer Science", program.getName());
        assertEquals("Computer Science", program.getMajor());

        program1 = new Program("Different program - Computer Science", "Computer Science");
        assert(!program.equals(program1));
        program1 = new Program("Bachelor of Science Major - Computer Science", "Computer Science");
        assert(program.equals(program1));

        System.out.println("Finished testProgram");
    }
}
