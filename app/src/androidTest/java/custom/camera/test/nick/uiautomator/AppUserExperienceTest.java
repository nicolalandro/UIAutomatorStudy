package custom.camera.test.nick.uiautomator;


import android.support.test.InstrumentationRegistry;
import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class AppUserExperienceTest
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
    public void xxx() throws Exception
    {
        Thread.sleep(2000);
    }


}
