package comp3350.umhub.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import comp3350.umhub.tests.business.AccessCoursesIT;
import comp3350.umhub.tests.business.AccessMajorsIT;
import comp3350.umhub.tests.business.AccessProgramsIT;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        AccessMajorsIT.class,
        AccessProgramsIT.class,
        AccessCoursesIT.class,
})
public class AllIntegrationTests {
}
