package custom.camera.test.nick.uiautomator;


import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.Until;
import android.widget.Switch;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class UiAUtomatorOfflineTest
{
    @Rule
    public ActivityTestRule<MainActivity> mRealHomeActivity = new ActivityTestRule(MainActivity.class, false, false);

    private UiDevice mDevice;

    @Before
    public void setUp() throws Exception
    {
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
    }

    @Test
    public void airplane_mode_test() throws Exception
    {
        toggleAirplanemode();

        mRealHomeActivity.launchActivity(new Intent());
        mDevice.wait(Until.hasObject(By.text("UiAutomator")), 6000);

        toggleAirplanemode();
    }

    public void toggleAirplanemode() throws InterruptedException
    {
        Context context = InstrumentationRegistry.getContext();
        Intent intentAirplaneMode = new Intent(Settings.ACTION_AIRPLANE_MODE_SETTINGS);
        intentAirplaneMode.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intentAirplaneMode);

        mDevice.wait(Until.hasObject(By.text("Airplane mode")), 200);
        boolean checkedBefore = mDevice.findObject(By.clazz(Switch.class)).isChecked();
        mDevice.findObject(By.clazz(Switch.class)).click();
        boolean checkedAfter;

        do
        {
            checkedAfter = mDevice.findObject(By.clazz(Switch.class)).isChecked();
        } while (checkedAfter == checkedBefore);

        mDevice.pressBack();
    }
}
