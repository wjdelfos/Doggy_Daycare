package com.example.myapplication;

import com.example.myapplication.model.Advertentie;

import org.junit.Test;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;

public class AdvertentieTests {
    /*
    * These tests test the initialisation of a model in different ways
    * */
    @Test
    public void StandardInitialisation() {
        Advertentie result = new Advertentie();
        assertThat(result, instanceOf(Advertentie.class));
        assertNotNull(result);
    }

    //init with specific id

    @Test
    public void InitialisationUUID() {
        UUID input =UUID.randomUUID();

        Advertentie result = new Advertentie(input);

        assertThat(result, instanceOf(Advertentie.class));
        assertNotNull(result);
        assertSame(input,result.getID());
    }

    //init with specific params

    @Test
    public void InitialisationWithParameters() {
        //input
        String input="TestLocatie";

        Advertentie result = new Advertentie(null,null,null,null,0,input,null,0,null,null,null);

        assertThat(result, instanceOf(Advertentie.class));
        assertNotNull(result);
        assertSame(input,result.getLocatie());
    }



}