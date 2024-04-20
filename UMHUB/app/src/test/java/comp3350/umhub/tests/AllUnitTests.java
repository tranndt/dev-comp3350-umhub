package comp3350.umhub.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import comp3350.umhub.tests.objects.*;
import comp3350.umhub.tests.business.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CourseTest.class,
        MajorTest.class,
        ProgramTest.class,
        AccessMajorsTest.class,
        AccessProgramsTest.class,
        UsersTest.class,
        LoginTest.class,
        AccessCoursesTest.class,
        TutorEntryTest.class,
})

public class AllUnitTests {
}
