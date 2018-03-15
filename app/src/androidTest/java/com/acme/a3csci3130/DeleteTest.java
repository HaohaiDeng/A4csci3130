package com.acme.a3csci3130;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;

/**
 * Created by denghaohai on 15/03/2018.
 */

@RunWith(AndroidJUnit4.class)
public class DeleteTest {
    @Rule
    public ActivityTestRule<initial_pageActivity> fActivityTestRule = new ActivityTestRule<>(initial_pageActivity.class);

    @Test
    public void Case2() throws Exception{
        onData(instanceOf(Buiness.class))
                .inAdapterView(allOf(withId(R.id.listView), isDisplayed()))
                .atPosition(0)
                .perform(click());
        onView(withId(R.id.view)).perform(click());
    }
}
