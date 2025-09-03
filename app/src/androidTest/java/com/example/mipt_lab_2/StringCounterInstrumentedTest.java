package com.example.mipt_lab_2;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.hamcrest.CoreMatchers.anything;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

public class StringCounterInstrumentedTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void wordCountTest() {
        // simulate button click
        onView(withId(R.id.mainTextInput)).perform(typeText("  Hello!,.,. ,. ., Welcome!   "), closeSoftKeyboard());

        onView(withId(R.id.mainButton)).perform(click());

        String expected = getInstrumentation()
                .getTargetContext()
                .getString(R.string.foundWords) + "2";

        onView(withId(R.id.outputTextView)).check(matches(withText(expected)));
    }

    @Test
    public void charCountTest() {
        // simulate button click
        onView(withId(R.id.mainTextInput)).perform(typeText("  !.a;/  "), closeSoftKeyboard());

        onView(withId(R.id.countTypeSelector)).perform(click());

        onData(anything())
                .atPosition(1)
                .perform(click());

        onView(withId(R.id.mainButton)).perform(click());

        String expected = getInstrumentation()
                .getTargetContext()
                .getString(R.string.foundChars) + "9";

        onView(withId(R.id.outputTextView)).check(matches(withText(expected)));
    }
}
