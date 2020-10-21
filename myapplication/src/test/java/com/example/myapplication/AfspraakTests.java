package com.example.myapplication;

import com.example.myapplication.model.Afspraak;

import org.junit.Test;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class AfspraakTests {

    //init with specific id

    @Test
    public void InitialisationUUID() {
        UUID input =UUID.randomUUID();

        Afspraak result = new Afspraak(input);

        assertThat(result, instanceOf(Afspraak.class));
        assertNotNull(result);
        assertSame(input,result.getID());
    }

    //init with specific params

    @Test
    public void InitialisationWithParameters() {
        //input
        Double input=1.0;

        Afspraak result = new Afspraak(input,null,true,true,null,null,null);

        assertThat(result, instanceOf(Afspraak.class));
        assertNotNull(result);
        assertTrue(input.equals(result.getAfgesprokenPrijs()));
    }



}