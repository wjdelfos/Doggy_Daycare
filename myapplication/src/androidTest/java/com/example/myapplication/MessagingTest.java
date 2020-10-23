package com.example.myapplication;

import androidx.test.espresso.contrib.RecyclerViewActions;
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
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MessagingTest {

    private String Username;
    private String Password;
    private String Message;

    @Rule
    public ActivityScenarioRule<LoginActivity> activityRule
            = new ActivityScenarioRule<>(LoginActivity.class);

    @Before
    public void SetupScenario() {
        // log in and start a chat with a specified user
        Username = "123456789";
        Password="123";
        Message="TestMessage";
        Intents.init();
        onView(withId(R.id.Telefoon_nr))
                .perform(typeText(Username), closeSoftKeyboard());
        onView(withId(R.id.Wachtwoord))
                .perform(typeText(Password), closeSoftKeyboard());
        onView(withId(R.id.Login)).perform(click());
        onView(withId(R.id.AdvertRecycler)).perform(
                RecyclerViewActions.actionOnItemAtPosition(0,click()));
        onView(withId(R.id.Messaging)).perform(click());
    }

    @After
    public void tearDown() {
        Intents.release();
    }

    @Test
    public void SendMessage() {
        //Setup
        onView(withId(R.id.messageInput))
                .perform(typeText(Message), closeSoftKeyboard());

        //action
        onView(withId(R.id.buttonSend)).perform(click());


        //check if the message field is empty, it is empty if the message has been added successfully
        onView(withId(R.id.messageInput))
                .check(matches(withText("")));

    }
}