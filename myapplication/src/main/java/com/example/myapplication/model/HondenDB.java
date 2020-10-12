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
        }
        /*
        public List<Notitie> getNotities() {
            List<Notitie> notities = new ArrayList<>();
            Cursor cursor = mDatabase.rawQuery("SELECT * FROM Notities", null);

            try {
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    Notitie notitie = cursorToNotitie(cursor);
                    notities.add(notitie);
                    cursor.moveToNext();
                }
            } finally {
                cursor.close();
            }
            return notities;


        }

        private Notitie cursorToNotitie(Cursor cursor) {
            String uuidString = cursor.getString(
                    cursor.getColumnIndex("id"));
            String title = cursor.getString(
                    cursor.getColumnIndex("titel"));
            String desc = cursor.getString(
                    cursor.getColumnIndex("beschrijving"));
            long date = cursor.getLong(
                    cursor.getColumnIndex("datum"));
            Notitie notitie = new Notitie(UUID.fromString(uuidString));
            notitie.setTitel(title);
            notitie.setBeschrijving(desc);
            notitie.setDatum(new Date(date));
            return notitie;
        }

        public Notitie getNotitie(UUID id) {
            Cursor cursor = mDatabase.rawQuery("SELECT * FROM Notities WHERE id='"+id+"'", null);

            try {
                if (cursor.getCount() == 0) {
                    return null;
                }
                cursor.moveToFirst();
                Notitie notitie = cursorToNotitie(cursor);
                return notitie;
            } finally {
                cursor.close();
            }
        }

        private static ContentValues getContentValues(Notitie notitie) {
            ContentValues values = new ContentValues();
            values.put("id", notitie.getId().toString());
            values.put("titel", notitie.getTitel());
            values.put("beschrijving", notitie.getBeschrijving());
            values.put("datum", notitie.getDatum().getTime());
            return values;
        }

        public void addNotitie(Notitie notitie) {
            String sql = "INSERT INTO Notities VALUES ('" + notitie.getId() + "', '" + notitie.getTitel() + "', '" + notitie.getBeschrijving() + "', '" + notitie.getDatum().getTime() + "')";
            mDatabase.execSQL(sql);
        }

        public void updateNotitie(Notitie notitie) {
            mDatabase.execSQL("UPDATE Notities SET titel='" + notitie.getTitel() + "', beschrijving='" + notitie.getBeschrijving() + "', datum='" + notitie.getDatum().getTime() + "' WHERE id='" + notitie.getId() + "'");
        }
    }*/



//String a = QueryBuilder.buildQueryString(false,"",new String[]{"iets"},null,"iets",null,null,null);
}
