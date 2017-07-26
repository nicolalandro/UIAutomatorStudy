package custom.camera.test.nick.uiautomator;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;

public class UIAutomatorUtil
{
    private UiDevice mDevice;

    public UIAutomatorUtil(UiDevice device)
    {
        mDevice = device;
    }

    public void toggleBluethoot() throws InterruptedException
    {
        Context context = InstrumentationRegistry.getContext();

        Intent intentAirplaneMode = new Intent(Settings.ACTION_BLUETOOTH_SETTINGS);
        intentAirplaneMode.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        context.startActivity(intentAirplaneMode);

        Thread.sleep(20);

        mDevice.findObject(By.res("com.android.settings:id/switch_widget")).click();

        mDevice.pressBack();
    }

    public void swipeRight()
    {
        mDevice.swipe(600, 600, 200, 600, 20);
    }

    public void swipeLeft()
    {
        mDevice.swipe(200, 600, 600, 600, 20);
    }

    public void shortDropDownMenu()
    {
        mDevice.swipe(10, 10, 10, 60, 2);
    }

    public void allDropDownMenu()
    {
        mDevice.swipe(10, 10, 10, 600, 50);
    }
}
