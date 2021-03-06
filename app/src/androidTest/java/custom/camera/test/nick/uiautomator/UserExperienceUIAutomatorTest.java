package custom.camera.test.nick.uiautomator;


import android.support.test.InstrumentationRegistry;
import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
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

    @Test
    public void assert_about_write() throws Exception
    {
        Thread.sleep(2000);

        UiObject editText = mDevice.findObject(new UiSelector().className(EditText.class));

        assertEquals("" , editText.getText());

        editText.setText("Hello you!");

        assertEquals("Hello you!" , editText.getText());
    }

    @Test
    public void click_button_change_text_view_state() throws Exception
    {
        UiObject editText = mDevice.findObject(new UiSelector().className(EditText.class));
        UiObject button = mDevice.findObject(new UiSelector().className(Button.class));

        editText.setText("Hello you!");
        button.click();

        UiObject textView = mDevice.findObject(new UiSelector().className(TextView.class).textContains("Hello you!"));
        assertEquals("Hello you!" , textView.getText());

    }

    @Test
    public void click_button_change_text_view_state_with_upper_case_clicked() throws Exception
    {
        UiObject editText = mDevice.findObject(new UiSelector().className(EditText.class));
        UiObject button = mDevice.findObject(new UiSelector().className(Button.class));
        UiObject checkBox = mDevice.findObject(new UiSelector().className(CheckBox.class));

        editText.setText("Hello you!");
        checkBox.click();
        button.click();

        UiObject textView = mDevice.findObject(new UiSelector().className(TextView.class).textContains("HELLO YOU!"));
        assertEquals("HELLO YOU!" , textView.getText());

    }

    @Test
    public void add_element_to_list() throws Exception
    {
        UiObject editText = mDevice.findObject(new UiSelector().className(EditText.class));
        UiObject button = mDevice.findObject(new UiSelector().className(Button.class));

        editText.setText("pippo");
        button.click();

        UiObject listView = mDevice.findObject(new UiSelector().className(ListView.class));
        UiObject firstListViewElement = listView.getChild(new UiSelector().clickable(true).index(0));
        assertEquals("pippo" , firstListViewElement.getText());
    }

    @Test
    public void add_uppercase_element_to_list() throws Exception
    {
        UiObject editText = mDevice.findObject(new UiSelector().className(EditText.class));
        UiObject button = mDevice.findObject(new UiSelector().className(Button.class));
        UiObject checkBox = mDevice.findObject(new UiSelector().className(CheckBox.class));

        editText.setText("pippo");
        checkBox.click();
        button.click();

        UiObject listView = mDevice.findObject(new UiSelector().className(ListView.class));
        UiObject firstListViewElement = listView.getChild(new UiSelector().clickable(true).index(0));
        assertEquals("PIPPO" , firstListViewElement.getText());
    }

    @Test
    public void add_much_element_to_list() throws Exception
    {
        addLowerAndUpperCaseTextToListView("pippo");

        addLowerAndUpperCaseTextToListView("pluto");

        addLowerAndUpperCaseTextToListView("paperino");

        addLowerAndUpperCaseTextToListView("topolino");

        mDevice.pressBack();

        UiScrollable listViewScrollable = new UiScrollable(new UiSelector().className(ListView.class));
        listViewScrollable.scrollToEnd(20);

        UiObject listView = mDevice.findObject(new UiSelector().className(ListView.class));
        UiObject lastListViewElement = listView.getChild(new UiSelector().clickable(true).index(6)); //6 perche sono 6 gli elementi visibili, questo test dipende dal dispostivio
        assertEquals("TOPOLINO" , lastListViewElement.getText());
    }

    private void addLowerAndUpperCaseTextToListView(String text) throws UiObjectNotFoundException
    {
        UiObject editText = mDevice.findObject(new UiSelector().className(EditText.class));
        UiObject button = mDevice.findObject(new UiSelector().className(Button.class));
        UiObject checkBox = mDevice.findObject(new UiSelector().className(CheckBox.class));

        editText.setText(text);
        button.click();
        checkBox.click();
        button.click();
        checkBox.click();
    }
}
