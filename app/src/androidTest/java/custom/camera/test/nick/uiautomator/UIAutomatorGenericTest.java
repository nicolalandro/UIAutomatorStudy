package custom.camera.test.nick.uiautomator;


import android.support.test.InstrumentationRegistry;
import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class UIAutomatorGenericTest
{

    private UIAutomatorUtil uiAutomatorUtil;
    private UiDevice mDevice;

    @Before
    public void setUp() throws Exception
    {
        // Initialize UiDevice instance
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        uiAutomatorUtil = new UIAutomatorUtil(mDevice);
    }

    @Test
    public void swipe() throws Exception
    {
        uiAutomatorUtil.swipeRight();

        Thread.sleep(2000);

        uiAutomatorUtil.swipeLeft();

        Thread.sleep(2000);

        uiAutomatorUtil.shortDropDownMenu();

        Thread.sleep(2000);

        mDevice.pressBack();
        Thread.sleep(20);
    }

    @Test
    public void showDropdownMenu() throws Exception
    {
        uiAutomatorUtil.allDropDownMenu();

        Thread.sleep(2000);

        mDevice.pressBack();
        Thread.sleep(20);
    }

    @Test
    public void bluetooth() throws Exception
    {
        uiAutomatorUtil.toggleBluethoot();

        Thread.sleep(2000);

        uiAutomatorUtil.toggleBluethoot();
    }

}
