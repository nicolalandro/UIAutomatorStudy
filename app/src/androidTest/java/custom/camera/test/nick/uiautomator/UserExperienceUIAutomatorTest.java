package custom.camera.test.nick.uiautomator;


import android.support.test.InstrumentationRegistry;
import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;


@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class UserExperienceUIAutomatorTest
{

    private UIAutomatorUtil uiAutomatorUtil;
    private UiDevice mDevice;
    private UiScrollable mScrollable;

    @Before
    public void setUp() throws Exception
    {
        // Initialize UiDevice instance
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        mScrollable = new UiScrollable(new UiSelector().scrollable(false));

        uiAutomatorUtil = new UIAutomatorUtil(mDevice);

        mDevice.pressHome();
        mDevice.findObject(By.desc("App")).click();
        mScrollable.scrollToEnd(20);
        mDevice.findObject(By.text("UiAutomator")).click();
    }

    @Test
    public void assert_about_label() throws Exception
    {
        Thread.sleep(2000);

        UiObject textView = mDevice.findObject(new UiSelector().className(TextView.class).textContains("Hello World!"));

        assertEquals("Hello World!" , textView.getText());
    }


}
