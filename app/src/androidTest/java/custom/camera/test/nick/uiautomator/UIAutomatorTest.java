package custom.camera.test.nick.uiautomator;


import android.support.test.InstrumentationRegistry;
import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static custom.camera.test.nick.uiautomator.UIAutomatorUtil.*;


@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class UIAutomatorTest
{
    public static UiDevice mDevice;


    @Before
    public void setUp() throws Exception
    {
        // Initialize UiDevice instance
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
    }

    @Test
    public void swipe() throws Exception
    {
        swipeRight();

        Thread.sleep(2000);

        swipeLeft();

        Thread.sleep(2000);

        shortDropDownMenu();

        Thread.sleep(2000);
    }

    @Test
    public void showDropdownMenu() throws Exception
    {
        allDropDownMenu();

        Thread.sleep(2000);
    }

    @Test
    public void bluetooth() throws Exception
    {
        toggleBluethoot();

        Thread.sleep(2000);

        toggleBluethoot();
    }

}
