package com.example.communityapp;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static androidx.test.espresso.action.ViewActions.click;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void checkAllButtonsAreVisible() {
        onView(withId(R.id.fabCreatePost)).check(matches(isDisplayed()));
        onView(withId(R.id.fabSearchPost)).check(matches(isDisplayed()));
        onView(withId(R.id.fabViewUsers)).check(matches(isDisplayed()));
        onView(withId(R.id.fabSettings)).check(matches(isDisplayed()));
    }

    @Test
    public void checkAppLabelIsVisible() {
        onView(withId(R.id.appLabel)).check(matches(isDisplayed()));
    }

    @Test
    public void testCreatePostButtonClick() {
        onView(withId(R.id.fabCreatePost)).perform(click());

    }
}
