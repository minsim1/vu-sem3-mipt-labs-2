package com.example.mipt_lab_2;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class CalculatorInstrumentedTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void divideByZero() {
        // Attempt to divide by zero
        onView(withId(R.id.buttonFor1)).perform(click());
        onView(withId(R.id.buttonFor2)).perform(click());
        onView(withId(R.id.buttonForDivision)).perform(click());
        onView(withId(R.id.buttonFor0)).perform(click());
        onView(withId(R.id.equalsButton)).perform(click());
        // Check if the output message is correct
        onView(withId(R.id.mainTextView)).check(matches(withText(R.string.divByZeroErr)));
    }

    @Test
    public void sqrtNegNumber() {
        // Attempt to divide by zero
        onView(withId(R.id.buttonFor1)).perform(click());
        onView(withId(R.id.buttonFor2)).perform(click());
        onView(withId(R.id.buttonChangePolarity)).perform(click());
        onView(withId(R.id.buttonForSquareRoot)).perform(click());
        // Check if the output message is correct
        onView(withId(R.id.mainTextView)).check(matches(withText(R.string.sqrtFromNegNum)));
    }

    @Test
    public void addition() {
        // Attempt to divide by zero
        onView(withId(R.id.buttonFor1)).perform(click());
        onView(withId(R.id.buttonFor2)).perform(click());
        onView(withId(R.id.buttonForAddition)).perform(click());
        onView(withId(R.id.buttonFor6)).perform(click());
        onView(withId(R.id.buttonFor7)).perform(click());
        onView(withId(R.id.equalsButton)).perform(click());
        // Check if the output message is correct
        onView(withId(R.id.mainTextView)).check(matches(withText("79.0")));
    }
}

