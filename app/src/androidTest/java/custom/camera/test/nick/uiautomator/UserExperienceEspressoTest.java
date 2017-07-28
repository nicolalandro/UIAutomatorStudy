package custom.camera.test.nick.uiautomator;


import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
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
    public void assert_about_label() throws Exception
    {
        onView(withId(R.id.text_view)).check(matches(withText("Hello World!")));

        onView(withText("Hello World!")).check(matches(isDisplayed()));
    }

    @Test
    public void assert_about_write() throws Exception
    {
        onView(withId(R.id.edit_text)).check(matches(withText("")));

        onView(withId(R.id.edit_text)).perform(typeText("Hello you!"));

        onView(withId(R.id.edit_text)).check(matches(withText("Hello you!")));
    }

    @Test
    public void click_button_change_text_view_state() throws Exception
    {
        onView(withId(R.id.text_view)).check(matches(isDisplayed()));

        onView(withId(R.id.edit_text)).perform(typeText("Hello you!"));

        onView(withId(R.id.button)).perform(click());

        onView(withId(R.id.text_view)).check(matches(withText("Hello you!")));
    }

    @Test
    public void click_button_change_text_view_state_with_upper_case_clicked() throws Exception
    {
        onView(withId(R.id.text_view)).check(matches(isDisplayed()));

        onView(withId(R.id.edit_text)).perform(typeText("Hello you!"));

        onView(withId(R.id.checkBox)).perform(click());

        onView(withId(R.id.button)).perform(click());

        onView(withId(R.id.text_view)).check(matches(withText("HELLO YOU!")));
    }
}
