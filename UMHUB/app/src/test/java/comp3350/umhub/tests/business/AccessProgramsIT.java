package comp3350.umhub.tests.business;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import comp3350.umhub.business.AccessPrograms;
import comp3350.umhub.objects.Major;
import comp3350.umhub.objects.Program;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class AccessProgramsIT {
    private AccessPrograms accessPrograms;
    
    @Before
    public void setUp(){
        this.accessPrograms = new AccessPrograms();
    }

    @Test
    public void getProgramsTest(){
        Major majorSelected = new Major("Accounting");
        System.out.println("\nStarting Access Programs integration test - getPrograms");
        List<Program> programs = accessPrograms.getProgramsByMajor(majorSelected);

        assertNotNull("Majors list should not be null", programs);
        assert(programs.size()!=0);

        assertTrue("BComm Honors Accounting".equals(programs.get(0).getName()));

        System.out.println("Finished Access Programs integration test - getPrograms");

    }
}
