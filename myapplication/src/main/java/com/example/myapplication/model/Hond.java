package com.example.myapplication.model;

import java.util.UUID;
import java.util.Date;

public class Hond {
    private UUID ID;
private enum geslacht {man,vrouw,overig};
private Date Leeftijd;
private String ras; // stond in fysiek model als data type text (is dat een ding?)
private String opmerkingen;


public Hond(){ this(UUID.randomUUID());}
public Hond(UUID id){ID=id;}

    public void setID(UUID ID) {
        this.ID = ID;
    }

    public void setLeeftijd(Date leeftijd) {
        Leeftijd = leeftijd;
    }

    public void setRas(String ras) {
        this.ras = ras;
    }

    public void setOpmerkingen(String opmerkingen) {
        this.opmerkingen = opmerkingen;
    }

    public Hond (UUID ID, Date Leeftijd, String ras, String opmerkingen){


}
}
