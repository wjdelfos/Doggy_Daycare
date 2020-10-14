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
            TestPersoon.setHuisnummer(5);
            TestPersoon.setIntroductieText("ik ben een test gebruiker");
            TestPersoon.setWachtwoord("123");

            this.addApp_Gebruiker(new App_Gebruiker());

        }

        public void addApp_Gebruiker(App_Gebruiker app_Gebruiker) {
            String sql = "INSERT INTO App_Gebruiker VALUES ('" + app_Gebruiker.getID() + "', '" + app_Gebruiker.getNaam() + "', '" + app_Gebruiker.getPlaatsnaam() + "', '" + app_Gebruiker.getStraatnaam() + "', '" + app_Gebruiker.getHuisnummer() + "', '" + app_Gebruiker.getPostcode() + "','" + app_Gebruiker.getTelefoon_Nummer() + "', '" + app_Gebruiker.getGeboortedatum()+ "', '" + app_Gebruiker.getWachtwoord()+ "', '" + app_Gebruiker.getIntroductieText() + "' )";
            mDatabase.execSQL(sql);
        }

        public void addAdvertentie(Advertentie advertentie) {
            String sql = "INSERT INTO Advertentie VALUES ('" + advertentie.getID() + "','" + advertentie.getBeginTijd() + "','" + advertentie.getEindTijd() + "','" + advertentie.getPrijs() + "','" + advertentie.getLocatie() + "','" + advertentie.getSpecialeVoorkeurenHond() + "','" + advertentie.getCapaciteit() + "','" + advertentie.getErvaringHonden() + "','" + advertentie.getOptiesEten() + "','" + advertentie.get_AdvertentiePlaatser() + "' )";
            mDatabase.execSQL(sql);
        }

        public void addHond(Hond hond) {
            String sql = "INSERT INTO Hond VALUES ('" + hond.getID() + "','" + hond.getNaam() + "','" + hond.getLeeftijd() + "','" + hond.getRas() + "','" + hond.getOpmerkingen() + "','" + hond.getEigenaar() + "' )";
            mDatabase.execSQL(sql);
        }

        public void addAfspraak(Afspraak afspraak) {
            String sql = "INSERT INTO Afspraak VALUES ('" + afspraak.getID() + "','" + afspraak.getStatusAfspraak() + "','" + afspraak.getAfgesprokenPrijs() + "','" + afspraak.getOppas() + "','" + afspraak.getEigenaar() + "','" + afspraak.getAdvertentie() + "' )";
            mDatabase.execSQL(sql);
        }

//String a = QueryBuilder.buildQueryString(false,"",new String[]{"iets"},null,"iets",null,null,null);
}
