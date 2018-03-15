package com.acme.a3csci3130;

import android.support.test.rule.ActivityTestRule;
import android.widget.Toast;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import android.support.test.runner.AndroidJUnit4;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.not;

/**
 * Created by denghaohai on 15/03/2018.
 */

@RunWith(AndroidJUnit4.class)
public class CreateTest {

    @Rule
    public ActivityTestRule<initial_pageActivity> fActivityTestRule = new ActivityTestRule<>(initial_pageActivity.class);
    @Rule
    public ActivityTestRule<CreateBuinessAcitivity> mActivityTestRule = new ActivityTestRule<>(CreateBuinessAcitivity.class);

    @Test
    public void Case1() throws Exception {
        onView(withId(R.id.create)).perform(click());
        onView(withId(R.id.id)).
                perform(typeText("320777777"),closeSoftKeyboard());
        onView(withId(R.id.name)).
                perform(typeText("AegeanSea"),closeSoftKeyboard());
        onView(withId(R.id.PB)).
                    perform(typeText("Processor"),closeSoftKeyboard());
        onView(withId(R.id.Address)).
                    perform(typeText("1015 Barrington"),closeSoftKeyboard());
        onView(withId(R.id.province)).
                perform(typeText("NS"),closeSoftKeyboard());
        onView(withId(R.id.submitButton)).perform(click());
        onView(withText("added to database successfully"))
                .inRoot(withDecorView(not(mActivityTestRule.getActivity().getWindow().getDecorView())))
                .check(matches(isDisplayed()));
    }

}
