package com.example.myapplication.data_handeling;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataInitializer extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "honden.db";

    public DataInitializer(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table App_Gebruiker(" +
                        "id text primary key," +
                        " Naam text," +
                        " Plaatsnaam text, " +
                        "Straatnaam text," +
                        " Huisnummer int," +
                        " Postcode text," +
                        " Telefoon_Nummer int," +
                        " Geboortedatum datetime," +
                        " Wachtwoord text," +
                        " Introductie text)");
        db.execSQL(
                "create table Advertentie(" +
                        "id text primary key," +
                        " BeginTijd DateTime," +
                        " EindTijd DateTime," +
                        " Prijs double," +
                        " Locatie text," +
                        " SpecialeVoorkeurenHond text," +
                        " Capaciteit int," +
                        " ErvaringHonden text," +
                        " OptiesEten text," +
                        " IdAdvertentiePlaatser text," +
                        " CONSTRAINT fk_gebruiker_advertentie" +
                        "    FOREIGN KEY (IdAdvertentiePlaatser)" +
                        "    REFERENCES App_Gebruiker (id))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}

