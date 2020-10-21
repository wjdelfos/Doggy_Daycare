package com.example.myapplication;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.example.myapplication.controller.login.LoginActivity;
import com.example.myapplication.controller.messaging.MessagingActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class TestThroughEntireApp {

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
        Password="123";
        Intents.init();
    }

    @After
    public void tearDown() {
        Intents.release();
    }

    @Test
    public void WalkThoughLoginTillMessaging() {
        //Walk through entire app
        onView(withId(R.id.Telefoon_nr))
                .perform(typeText(Username), closeSoftKeyboard());
        onView(withId(R.id.Wachtwoord))
                .perform(typeText(Password), closeSoftKeyboard());
        onView(withId(R.id.Login)).perform(click());
        onView(withId(R.id.AdvertRecycler)).perform(
                RecyclerViewActions.actionOnItemAtPosition(0,click()));
        onView(withId(R.id.Messaging)).perform(click());


        //check if the activity messaging has been reached. If so all steps have succeded
        intended(hasComponent(MessagingActivity.class.getName()));
    }
}