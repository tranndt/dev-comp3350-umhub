package comp3350.umhub;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import comp3350.umhub.presentation.HomeActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginSystemTest {
    @Rule
    public ActivityTestRule<HomeActivity> activityRule = new ActivityTestRule<>(HomeActivity.class);

    @Test
    public void reviewLogin() {
        onView(withId(R.id.login1)).perform(click());
        onView(withId(R.id.etUserName)).perform(typeText("admin"));
        onView(withId(R.id.etUserName)).perform(closeSoftKeyboard());
        onView(withId(R.id.etPassword)).perform(typeText("123456"));
        onView(withId(R.id.etPassword)).perform(closeSoftKeyboard());
        onView(withId(R.id.btnLogin)).perform(click());
    }
}
