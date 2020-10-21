package com.example.myapplication;

import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.example.myapplication.controller.sign_up.SignUpActivity;

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
public class SignUpTest {

    private String Name;
    private String Place;
    private String PhoneNumber;
    private String WrongPhoneNumber;
    private String Password;

    @Rule
    public ActivityScenarioRule<SignUpActivity> activityRule
            = new ActivityScenarioRule<>(SignUpActivity.class);

    @Before
    public void initStrings() {
        // Specify a valid string.
        Place = "Rotterdam";
        Name = "Mister tester";
        PhoneNumber = "123456789";
        WrongPhoneNumber = "qwerty123456789";
        Password="Password";
        Intents.init();
    }

    @After
    public void tearDown() {
        Intents.release();
    }

    @Test
    public void Register() {
        // Type text and then press the button.
        onView(withId(R.id.PersonName))
                .perform(typeText(Name), closeSoftKeyboard());
        onView(withId(R.id.PlaceName))
                .perform(typeText(Place), closeSoftKeyboard());
        onView(withId(R.id.Phone))
                .perform(typeText(PhoneNumber), closeSoftKeyboard());
        onView(withId(R.id.Password))
                .perform(typeText(Password), closeSoftKeyboard());

        //Action
        onView(withId(R.id.Aanmelden)).perform(click());

        //Check if main activity has been started
        intended(hasComponent(MainActivity.class.getName()));
    }

    @Test
    public void IncorrectlyFillSignUpForm() {
        // Type text but NO PASSWORD HAS BEEN FILLED OUT
        onView(withId(R.id.PersonName))
                .perform(typeText(Name), closeSoftKeyboard());
        onView(withId(R.id.PlaceName))
                .perform(typeText(Place), closeSoftKeyboard());
        onView(withId(R.id.Phone))
                .perform(typeText(PhoneNumber), closeSoftKeyboard());

        //Action
        onView(withId(R.id.Aanmelden)).perform(click());

        //not totally correct test, this test
        onView(withId(R.id.PersonName))
                .check(matches(withText(Name)));
    }
}