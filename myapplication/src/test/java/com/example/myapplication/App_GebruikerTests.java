package com.example.myapplication;

import com.example.myapplication.model.App_Gebruiker;

import org.junit.Test;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;

public class App_GebruikerTests {
    @Test
    public void StandardInitialisation() {
        App_Gebruiker result = new App_Gebruiker();
        assertThat(result, instanceOf(App_Gebruiker.class));
        assertNotNull(result);
    }

    //init with specific id

    @Test
    public void InitialisationUUID() {
        UUID input =UUID.randomUUID();

        App_Gebruiker result = new App_Gebruiker(input);

        assertThat(result, instanceOf(App_Gebruiker.class));
        assertNotNull(result);
        assertSame(input,result.getID());
    }

    //init with specific params

    @Test
    public void InitialisationWithParameters() {
        //input
        String input="TestLocatie";

        App_Gebruiker result = new App_Gebruiker(null,input,null,0,null,0,null,null,null);

        assertThat(result, instanceOf(App_Gebruiker.class));
        assertNotNull(result);
        assertSame(input,result.getPlaatsnaam());
    }



}