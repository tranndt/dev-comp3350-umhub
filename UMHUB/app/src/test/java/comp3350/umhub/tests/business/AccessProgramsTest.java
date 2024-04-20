package comp3350.umhub.tests.business;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import comp3350.umhub.business.AccessPrograms;
import comp3350.umhub.business.IAccessPrograms;
import comp3350.umhub.objects.Major;
import comp3350.umhub.objects.Program;
import comp3350.umhub.persistence.interfaces.IProgramPersistence;
import comp3350.umhub.persistence.stubs.ProgramPersistenceStub;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class AccessProgramsTest {

    private IAccessPrograms accessPrograms;

    @Before
    public void setUp() {
        IProgramPersistence persistence = new ProgramPersistenceStub();
        accessPrograms = new AccessPrograms(persistence);
    }

    @Test
    public void testGetPrograms()
    {
        final Program program;
        System.out.println("\nStarting test AccessPrograms");
        List<Program> programs = accessPrograms.getProgramsByMajor(new Major("Computer Science"));
        assertNotNull("list of program should not be null", programs);
        program = programs.get(0);
        assertNotNull("first sequential program should not be null", program);
        assertTrue("Computer Science General".equals(program.getName()));
        assertTrue("Computer Science".equals(program.getMajor()));

        System.out.println("Finished test AccessPrograms");
    }

}
