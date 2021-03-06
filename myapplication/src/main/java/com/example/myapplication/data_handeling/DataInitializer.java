package com.example.myapplication.data_handeling;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataInitializer extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "honden.db";

    public DataInitializer(Context context,boolean IsTest) {
        super(context, IsTest?"test"+DATABASE_NAME:DATABASE_NAME, null, VERSION);
    }

    /*
    * In onCreate we initialize the structure of the database.
    * there are 5 tables of which 3 are in use; Appgebruiker, Afspraken and Advertentie
    * */
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
                        " BeginTijd datetime," +
                        " EindTijd datetime," +
                        " Prijs double," +
                        " AdvertentieType text," +
                        " Locatie text," +
                        " SpecialeVoorkeurenHond text," +
                        " Capaciteit int," +
                        " ErvaringHonden text," +
                        " OptiesEten text," +
                        " IdAdvertentiePlaatser text," +
                        " CONSTRAINT fk_gebruiker_advertentie" +
                        "    FOREIGN KEY (IdAdvertentiePlaatser)" +
                        "    REFERENCES App_Gebruiker (id))");
        db.execSQL(
                "create table Hond(" +
                        "id text primary key," +
                        " Naam text," +
                        " Geboortedatum datetime," +
                        " Ras text," +
                        " Opmerkingen text," +
                        " Eigenaar int," +
                        " CONSTRAINT fk_gebruiker_hond" +
                        "    FOREIGN KEY (Eigenaar)" +
                        "    REFERENCES App_Gebruiker (id))");
        db.execSQL(
                "create table Afspraak(" +
                        "id text primary key," +
                        " Status text," +
                        " Afgesproken_prijs double," +
                        " Isgeaccepteerdeigenaar BOOLEAN," +
                        " IsgeaccepteerdOppas BOOLEAN," +
                        " Oppas text," +
                        " Eigenaar text," +
                        " Advertentie text," +
                        " CONSTRAINT fk_gebruiker_afspraak" +
                        "    FOREIGN KEY (Oppas)" +
                        "    REFERENCES App_Gebruiker (id), " +
                        " CONSTRAINT fk_gebruiker_afspraak" +
                        "    FOREIGN KEY (Eigenaar)" +
                        "    REFERENCES App_Gebruiker (id)," +
                        " CONSTRAINT fk_advertentie_afspraak" +
                        "    FOREIGN KEY (Advertentie)" +
                        "    REFERENCES Advertentie (id))");
        db.execSQL(
                "create table Review(" +
                        "id text primary key," +
                        " Inhoud text," +
                        " Sterren enum," +
                        " Reviewer int," +
                        " Gereviewde int," +
                        " Afspraak int," +
                        " CONSTRAINT fk_gebruiker_review" +
                        "    FOREIGN KEY (Reviewer)" +
                        "    REFERENCES App_Gebruiker (id)," +
                        " CONSTRAINT fk_gebruiker_review" +
                        "    FOREIGN KEY (Gereviewde)" +
                        "    REFERENCES App_Gebruiker (id)," +
                        " CONSTRAINT fk_afspraak_review" +
                        "    FOREIGN KEY (Afspraak)" +
                        "    REFERENCES Afspraak (id))");
        db.execSQL(
                "create table Message(" +
                        " id text primary key," +
                        " Contents text," +
                        " SendAtTime datetime," +
                        " Sender text," +
                        " Receiver text," +
                        " CONSTRAINT fk_gebruiker_message" +
                        "    FOREIGN KEY (Sender)" +
                        "    REFERENCES App_Gebruiker (id)," +
                        " CONSTRAINT fk_gebruiker_review" +
                        "    FOREIGN KEY (Receiver)" +
                        "    REFERENCES App_Gebruiker (id))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}

