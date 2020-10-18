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
            App_Gebruiker TestPersoon= new App_Gebruiker();
            TestPersoon.setNaam("Gerard");
            TestPersoon.setTelefoon_Nummer(123456789);
            TestPersoon.setHuisnummer(5);
            TestPersoon.setIntroductieText("ik ben een test gebruiker");
            TestPersoon.setWachtwoord("123");

            Advertentie TestAdvertentie= new Advertentie();
            TestAdvertentie.set_AdvertentiePlaatser(TestPersoon);
            TestAdvertentie.setCapaciteit(3);
            TestAdvertentie.setErvaringHonden("Ik ben opgegroeid met honden");
            TestAdvertentie.setLocatie("rotterdam");
            TestAdvertentie.setPrijs(2);

            this.addApp_Gebruiker(TestPersoon);
            this.addAdvertentie(TestAdvertentie);

        }

        public App_Gebruiker CheckCredentials(int telnr,String passw){

            // sql injection? ;-)
            Cursor cursor = mDatabase.rawQuery("SELECT * FROM App_Gebruiker WHERE Telefoon_Nummer='"+telnr+"'AND Wachtwoord='"+passw+"' limit 1", null);

            try {
                if (cursor.getCount() == 0) {
                    return null;
                }else{
                    // more checks around user validity
                    App_Gebruiker a=null;
                    if(cursor.moveToFirst()){
                    a=CurserToGebruiker(cursor);
                    }
                    return a;
                    //TODO set current user to this user
                }
            } finally {
                cursor.close();
            }
        }
        private App_Gebruiker CurserToGebruiker(Cursor c){
            String UUIDString = c.getString(c.getColumnIndex("id"));
            String naam =c.getString(c.getColumnIndex("Naam"));
            String Plaatsnaam =c.getString(c.getColumnIndex("Plaatsnaam"));
            String Straatnaam =c.getString(c.getColumnIndex("Straatnaam"));
            int Huisnummer =c.getInt(c.getColumnIndex("Huisnummer"));
            String Postcode =c.getString(c.getColumnIndex("Postcode"));
            int Telefoon_Nummer =c.getInt(c.getColumnIndex("Telefoon_Nummer"));
            long Geboortedatum =c.getLong(c.getColumnIndex("Geboortedatum"));
            String Introductie =c.getString(c.getColumnIndex("Introductie"));

            App_Gebruiker gebruiker= new App_Gebruiker(UUID.fromString(UUIDString));
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

        public void addApp_Gebruiker(App_Gebruiker app_Gebruiker) {
            String sql = "INSERT INTO App_Gebruiker VALUES ('" + app_Gebruiker.getID() + "', '" + app_Gebruiker.getNaam() + "', '" + app_Gebruiker.getPlaatsnaam() + "', '" + app_Gebruiker.getStraatnaam() + "', '" + app_Gebruiker.getHuisnummer() + "', '" + app_Gebruiker.getPostcode() + "','" + app_Gebruiker.getTelefoon_Nummer() + "', '" + app_Gebruiker.getGeboortedatum()+ "', '" + app_Gebruiker.getWachtwoord()+ "', '" + app_Gebruiker.getIntroductieText() + "' )";
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

}
