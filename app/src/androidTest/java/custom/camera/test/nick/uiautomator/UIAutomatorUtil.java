package custom.camera.test.nick.uiautomator;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.By;

public class UIAutomatorUtil
{
    public static void toggleBluethoot() throws InterruptedException
    {
        Context context = InstrumentationRegistry.getContext();

        Intent intentAirplaneMode = new Intent(Settings.ACTION_BLUETOOTH_SETTINGS);
        intentAirplaneMode.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        context.startActivity(intentAirplaneMode);

        Thread.sleep(20);

        UIAutomatorGenericTest.mDevice.findObject(By.res("com.android.settings:id/switch_widget")).click();

        UIAutomatorGenericTest.mDevice.pressBack();
    }

    public static void swipeRight()
    {
        UIAutomatorGenericTest.mDevice.swipe(600,600,200,600,20);
    }

    public static void swipeLeft()
    {
        UIAutomatorGenericTest.mDevice.swipe(200,600,600,600,20);
    }

    public static void shortDropDownMenu()
    {
        UIAutomatorGenericTest.mDevice.swipe(10,10,10,60,2);
    }

    public static void allDropDownMenu()
    {
        UIAutomatorGenericTest.mDevice.swipe(10,10,10,600,50);
    }
}
