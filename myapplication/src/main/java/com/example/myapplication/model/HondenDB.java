package com.example.myapplication.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.example.myapplication.data_handeling.DataInitializer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class HondenDB {
    private static HondenDB sHonden;
    private Context mContext;
    private SQLiteDatabase mDatabase;
    private SQLiteQueryBuilder QueryBuilder;

    public static HondenDB get(Context context) {
        return sHonden == null ? new HondenDB(context) : sHonden;
    }

    // private constructor zodat niemand anders een NotitieBlok kan maken
    // en we dus garanderen dat er maar één is
    private HondenDB(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new DataInitializer(mContext).getWritableDatabase();
        AddDummyData();
    }

    private void AddDummyData() {
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM App_Gebruiker", null);
        if(cursor.getCount()<1) {
            App_Gebruiker TestPersoon = new App_Gebruiker();
            TestPersoon.setNaam("Gerard");
            TestPersoon.setTelefoon_Nummer(123456789);
            TestPersoon.setHuisnummer(5);
            TestPersoon.setIntroductieText("ik ben een test gebruiker");
            TestPersoon.setWachtwoord("welkom");


            App_Gebruiker TestPersoon2 = new App_Gebruiker();
            TestPersoon2.setNaam("bob");
            TestPersoon2.setTelefoon_Nummer(123456789);
            TestPersoon2.setHuisnummer(5);
            TestPersoon2.setIntroductieText("ik ben een test gebruiker");
            TestPersoon2.setWachtwoord("123");

            Advertentie TestAdvertentie = new Advertentie();
            TestAdvertentie.set_AdvertentiePlaatser(TestPersoon);
            TestAdvertentie.setCapaciteit(3);
            TestAdvertentie.setErvaringHonden("Ik ben opgegroeid met honden");
            TestAdvertentie.setLocatie("rotterdam");
            TestAdvertentie.setBeginTijd(new Date());
            TestAdvertentie.setPrijs(2.56);

            Advertentie TestAdvertentie2 = new Advertentie();
            TestAdvertentie2.set_AdvertentiePlaatser(TestPersoon2);
            TestAdvertentie2.setCapaciteit(3);
            TestAdvertentie2.setLocatie("rotterdam");
            TestAdvertentie2.setBeginTijd(new Date());


            Advertentie TestAdvertentie3 = new Advertentie();
            TestAdvertentie3.set_AdvertentiePlaatser(TestPersoon2);
            TestAdvertentie3.setCapaciteit(5);
            TestAdvertentie3.setErvaringHonden("sahdjsajn");
            TestAdvertentie3.setLocatie("rotterdam");
            TestAdvertentie3.setPrijs(2);

            this.addApp_Gebruiker(TestPersoon2);
            this.addApp_Gebruiker(TestPersoon);
            this.addAdvertentie(TestAdvertentie);
            this.addAdvertentie(TestAdvertentie2);
            this.addAdvertentie(TestAdvertentie3);
        }
    }

    public App_Gebruiker CheckCredentials(int telnr, String passw) {

        // sql injection? ;-)
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM App_Gebruiker WHERE Telefoon_Nummer='" + telnr + "'AND Wachtwoord='" + passw + "' limit 1", null);

        try {
            if (cursor.getCount() == 0) {
                return null;
            } else {
                // more checks around user validity
                App_Gebruiker a = null;
                if (cursor.moveToFirst()) {
                    a = CurserToGebruiker(cursor);
                }
                return a;
                //TODO set current user to this user
            }
        } finally {
            cursor.close();
        }
    }

    public void addApp_Gebruiker(App_Gebruiker app_Gebruiker) {
        String sql = "INSERT INTO App_Gebruiker VALUES ('" + app_Gebruiker.getID() + "', '" + app_Gebruiker.getNaam() + "', '" + app_Gebruiker.getPlaatsnaam() + "', '" + app_Gebruiker.getStraatnaam() + "', '" + app_Gebruiker.getHuisnummer() + "', '" + app_Gebruiker.getPostcode() + "','" + app_Gebruiker.getTelefoon_Nummer() + "', '" + app_Gebruiker.getGeboortedatum() + "', '" + app_Gebruiker.getWachtwoord() + "', '" + app_Gebruiker.getIntroductieText() + "' )";
        mDatabase.execSQL(sql);
    }

    public void addAdvertentie(Advertentie advertentie) {
        String sql = "INSERT INTO Advertentie VALUES ('" + advertentie.getID() + "','" + advertentie.getBeginTijd() + "','" + advertentie.getEindTijd() + "','" + advertentie.getPrijs() + "','" + advertentie.getLocatie() + "','" + advertentie.getSpecialeVoorkeurenHond() + "','" + advertentie.getCapaciteit() + "','" + advertentie.getErvaringHonden() + "','" + advertentie.getOptiesEten() + "','" + advertentie.getAdvertentiePlaatser() + "' )";
        mDatabase.execSQL(sql);
    }

    public void addHond(Hond hond) {
        String sql = "INSERT INTO Hond VALUES ('" + hond.getID() + "','" + hond.getNaam() + "','" + hond.getLeeftijd() + "','" + hond.getRas() + "','" + hond.getOpmerkingen() + "','" + hond.getEigenaar() + "' )";
        mDatabase.execSQL(sql);
    }

    public void addAfspraak(Afspraak afspraak) {
        String sql = "INSERT INTO Afspraak VALUES ('" + afspraak.getID() + "','" + afspraak.getStatusAfspraak() + "','" + afspraak.getAfgesprokenPrijs() + "','" + afspraak.isIsgeaccepteerdeigenaar() + "','" + afspraak.isIsgeaccepteerdOppas() + "','" + afspraak.getOppas() + "','" + afspraak.getEigenaar() + "','" + afspraak.getAdvertentie() + "' )";
        mDatabase.execSQL(sql);
    }

    public List<Advertentie> getAdvertenties() {
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM Advertentie ", null);
        List<Advertentie> advertenties = new ArrayList<>();
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Advertentie advertentie = cursorToAdvertentie(cursor);
                advertenties.add(advertentie);
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }

        List<Advertentie> fullAdvertenties = new ArrayList<>();
        for (Advertentie a :
                advertenties) {
            fullAdvertenties.add(addUserToAdvert(a));
        }

        return fullAdvertenties;
    }

    private Advertentie addUserToAdvert(Advertentie a) {
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM App_Gebruiker WHERE id = '" + a.getAdvertentiePlaatser().toString()+ "'", null);

        try {
            cursor.moveToFirst();
            App_Gebruiker b = CurserToGebruiker(cursor);
            a.set_AdvertentiePlaatser(b);
            return a;
            //TODO set current user to this user

        } finally {
            cursor.close();
        }
    }


    private App_Gebruiker CurserToGebruiker(Cursor c) {
        String UUIDString = c.getString(c.getColumnIndex("id"));
        String naam = c.getString(c.getColumnIndex("Naam"));
        String Plaatsnaam = c.getString(c.getColumnIndex("Plaatsnaam"));
        String Straatnaam = c.getString(c.getColumnIndex("Straatnaam"));
        int Huisnummer = c.getInt(c.getColumnIndex("Huisnummer"));
        String Postcode = c.getString(c.getColumnIndex("Postcode"));
        int Telefoon_Nummer = c.getInt(c.getColumnIndex("Telefoon_Nummer"));
        long Geboortedatum = c.getLong(c.getColumnIndex("Geboortedatum"));
        String Introductie = c.getString(c.getColumnIndex("Introductie"));

        App_Gebruiker gebruiker = new App_Gebruiker(UUID.fromString(UUIDString));
        gebruiker.setNaam(naam);
        gebruiker.setPlaatsnaam(Plaatsnaam);
        gebruiker.setStraatnaam(Straatnaam);
        gebruiker.setHuisnummer(Huisnummer);
        gebruiker.setPostcode(Postcode);
        gebruiker.setTelefoon_Nummer(Telefoon_Nummer);
        gebruiker.setGeboortedatum(new Date(Geboortedatum));
        gebruiker.setIntroductieText(Introductie);
        return gebruiker;
    }

    private Advertentie cursorToAdvertentie(Cursor c) {
        String UUIDString = c.getString(c.getColumnIndex("id"));
        long BeginTijd = c.getLong(c.getColumnIndex("BeginTijd"));
        long EindTijd = c.getLong(c.getColumnIndex("EindTijd"));
        double Prijs = c.getDouble(c.getColumnIndex("Prijs"));
        String Locatie = c.getString(c.getColumnIndex("Locatie"));
        String SpecialeVoorkeurenHond = c.getString(c.getColumnIndex("SpecialeVoorkeurenHond"));
        int Capaciteit = c.getInt(c.getColumnIndex("Capaciteit"));
        String ErvaringHonden = c.getString(c.getColumnIndex("ErvaringHonden"));
        String OptiesEten = c.getString(c.getColumnIndex("OptiesEten"));
        String IdAdvertentiePlaatser = c.getString(c.getColumnIndex("IdAdvertentiePlaatser"));

        Advertentie advert = new Advertentie(UUID.fromString(UUIDString));
        advert.setBeginTijd(new Date(BeginTijd));
        advert.setEindTijd(new Date(EindTijd));
        advert.setPrijs(Prijs);
        advert.setLocatie(Locatie);
        advert.setSpecialeVoorkeurenHond(SpecialeVoorkeurenHond);
        advert.setCapaciteit(Capaciteit);
        advert.setErvaringHonden(ErvaringHonden);
        advert.setOptiesEten(OptiesEten);
        advert.setAdvertentiePlaatser(UUID.fromString(IdAdvertentiePlaatser));
        return advert;
    }
}
