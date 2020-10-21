package com.example.myapplication;

import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.myapplication.data_handeling.HondenDB;
import com.example.myapplication.model.Advertentie;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.sql.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class DatabaseUnitTests {
    @Test
    public void DatabaseInit() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        //this is a user called bob in the database that is automatically added the first time the database is run
        String result=HondenDB.get(appContext).CheckCredentials(123456789,"123").getNaam();
        assertEquals(result,"Bob de tester");
    }

    @Test
    public void AddAdvert() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        //setup new advert
        Advertentie newAdvert=new Advertentie();
        Date date=new Date(System.currentTimeMillis());
        newAdvert.setBeginTijd(date);
        newAdvert.setEindTijd(date);
        newAdvert.setAdvertentieType(Advertentie.AdvertentieTypes.oppas);
        //add a valid user to the test advert
        newAdvert.setAdvertentiePlaatser(HondenDB.get(appContext).CheckCredentials(123456789,"123").getID());

        //action
        boolean result = false;
        HondenDB.get(appContext).addAdvertentie(newAdvert);

        //checking for entry with that ID
        for (Advertentie a :HondenDB.get(appContext).getAdvertenties()) {
            if (a.getID().equals(newAdvert.getID())) {
                result = true;
            }
        }

        //assertion
        assertTrue(result);
    }
}