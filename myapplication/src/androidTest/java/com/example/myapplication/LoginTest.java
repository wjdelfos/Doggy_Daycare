package com.example.myapplication;

import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.example.myapplication.controller.login.LoginActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginTest {

    private String Username;
    private String WrongUsername;
    private String Password;

    @Rule
    public ActivityScenarioRule<LoginActivity> activityRule
            = new ActivityScenarioRule<>(LoginActivity.class);

    @Before
    public void initStrings() {
        // Specify a valid string.
        Username = "123456789";
        WrongUsername = "qwerty123456789";
        Password="123";
        Intents.init();
    }

    @After
    public void tearDown() {
        Intents.release();
    }

    @Test
    public void changeText_sameActivity() {
        // Type text and then press the button.
        onView(withId(R.id.Telefoon_nr))
                .perform(typeText(Username), closeSoftKeyboard());

        // Check that the text was changed.
        onView(withId(R.id.Telefoon_nr))
                .check(matches(withText(Username)));
    }

    @Test
    public void FillInWrongUsername() {
        // Type text and then press the button.
        onView(withId(R.id.Telefoon_nr))
                .perform(typeText(WrongUsername), closeSoftKeyboard());

        // Check that the text was changed.
        // The letters wont be accepted as input and the right username should be recorded
        onView(withId(R.id.Telefoon_nr))
                .check(matches(withText(Username)));
    }

    @Test
    public void Login() {
        // Type text and then press the button.
        onView(withId(R.id.Telefoon_nr))
                .perform(typeText(Username), closeSoftKeyboard());
        onView(withId(R.id.Wachtwoord))
                .perform(typeText(Password), closeSoftKeyboard());

        //Action
        onView(withId(R.id.Login)).perform(click());

        //Check if new activity has been started
        intended(hasComponent(MainActivity.class.getName()));
    }
}