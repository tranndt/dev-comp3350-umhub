package comp3350.umhub;

import android.content.Context;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import comp3350.umhub.application.Services;
import comp3350.umhub.persistence.interfaces.IUserPersistence;
import comp3350.umhub.presentation.HomeActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class SignupSystemTest {
    @Rule
    public ActivityTestRule<HomeActivity> activityRule = new ActivityTestRule<>(HomeActivity.class);

    @Before
    public void setup(){
        IUserPersistence userPersistence = Services.getUserPersistence();
        try {
            if (userPersistence.getUser("signupTest") != null) {
                userPersistence.delete("signupTest");
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void reviewSignup() {
        onView(withId(R.id.login1)).perform(click());
        onView(withId(R.id.etUserName)).perform(typeText("signupTest"));
        onView(withId(R.id.etUserName)).perform(closeSoftKeyboard());
        onView(withId(R.id.etPassword)).perform(typeText("test123"));
        onView(withId(R.id.etPassword)).perform(closeSoftKeyboard());
        onView(withId(R.id.btnLogin)).perform(click());
        onView(withId(R.id.btnSignUp)).perform(click());
        onView(withId(R.id.btnLogin)).perform(click());
    }

    @After
    public void cleanUp(){
        IUserPersistence userPersistence = Services.getUserPersistence();
        userPersistence.delete("signupTest");
    }
}
