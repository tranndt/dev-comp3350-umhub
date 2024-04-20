package comp3350.umhub;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginSystemTest.class,
        ReviewSystemTest.class,
        RatingSystemTest.class,
        SignupSystemTest.class,
})
public class AllSystemTests { }
