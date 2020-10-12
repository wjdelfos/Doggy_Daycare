package com.example.myapplication.model;

import java.util.UUID;
import java.util.Date;

public class Hond {
    private UUID ID;
    private enum Geslacht {man, vrouw, overig}
    private Date Leeftijd;
    private String Ras; // stond in fysiek model als data type text (is dat een ding?)
    private String Opmerkingen;


    public Hond() {  this(UUID.randomUUID()); }

    public Hond(UUID id) { ID = id; }

    public void setID(UUID ID) {
        this.ID = ID;
    }

    public void setLeeftijd(Date leeftijd) {
        Leeftijd = leeftijd;
    }

    public void setRas(String ras) {
        this.Ras = ras;
    }

    public void setOpmerkingen(String opmerkingen) {
        this.Opmerkingen = opmerkingen;
    }

    public UUID getID() { return ID; }

    public Date getLeeftijd() { return Leeftijd; }

    public String getRas() { return Ras; }

    public String getOpmerkingen() { return Opmerkingen; }

    public Hond(UUID ID, Date Leeftijd, String ras, String opmerkingen) {


    }
}
