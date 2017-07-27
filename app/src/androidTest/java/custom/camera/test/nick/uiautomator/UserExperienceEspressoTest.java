package custom.camera.test.nick.uiautomator;


import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class UserExperienceEspressoTest
{
    @Rule
    public ActivityTestRule<MainActivity> mRealHomeActivity = new ActivityTestRule(MainActivity.class, false, false);

    @Before
    public void setUp() throws Exception
    {
        mRealHomeActivity.launchActivity(new Intent());
    }

    @Test
    public void assert_on_label() throws Exception
    {
        onView(withId(R.id.text_view)).check(matches(withText("Hello World!")));
    }
}
