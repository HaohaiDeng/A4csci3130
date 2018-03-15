package com.acme.a3csci3130;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.TouchUtils;
import android.view.View;
import android.widget.ListView;

import com.firebase.ui.database.FirebaseListAdapter;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

/**
 * Created by denghaohai on 15/03/2018.
 */

@RunWith(AndroidJUnit4.class)
public class UpdateTest {

    @Rule
    public ActivityTestRule<ViewListActivity> sActivityTestRule = new ActivityTestRule<>(ViewListActivity.class);

    @Rule
    public ActivityTestRule<DetailViewActivity> tActivityTestRule = new ActivityTestRule<>(DetailViewActivity.class);

    @Test
    public void Case3() throws Exception{
        onData(instanceOf(Buiness.class))
                .inAdapterView(allOf(withId(R.id.listView), isDisplayed()))
                .atPosition(0)
                .perform(click());
        onView(withId(R.id.name_U)).perform(typeText("Dave"), closeSoftKeyboard());
        onView(withId(R.id.updateButton)).perform(click());
    }
}
