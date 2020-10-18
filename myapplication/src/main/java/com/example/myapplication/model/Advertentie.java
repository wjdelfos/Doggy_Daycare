package com.example.myapplication.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class Advertentie implements Serializable {
    private UUID ID;
    private enum AdvertentieTypes {eigenaar,oppas}
    private AdvertentieTypes AdvertentieType;
    private Date BeginTijd;
    private Date EindTijd;
    private double Prijs;
    private String Locatie;
    private String SpecialeVoorkeurenHond;
    private int Capaciteit;
    private String ErvaringHonden;
    private String OptiesEten;
    private UUID AdvertentiePlaatser;
    private App_Gebruiker _AdvertentiePlaatser;

    public Advertentie(UUID ID, AdvertentieTypes type, Date beginTijd, Date eindTijd, double prijs, String locatie, String specialeVoorkeurenHond, int capaciteit, String ervaringHonden, String optiesEten, UUID advertentiePlaatser) {
        this.ID = ID;
        AdvertentieType = type;
        BeginTijd = beginTijd;
        EindTijd = eindTijd;
        Prijs = prijs;
        Locatie = locatie;
        SpecialeVoorkeurenHond = specialeVoorkeurenHond;
        Capaciteit = capaciteit;
        ErvaringHonden = ervaringHonden;
        OptiesEten = optiesEten;
        AdvertentiePlaatser = advertentiePlaatser;
    }
    public Advertentie(){
        ID= UUID.randomUUID();
    }
    public Advertentie(UUID id){
        ID= id;
    }

    // region Getters en setters

    public UUID getID() {
        return ID;
    }

    public Date getBeginTijd() {
        return BeginTijd;
    }

    public void setBeginTijd(Date beginTijd) {
        BeginTijd = beginTijd;
    }

    public Date getEindTijd() {
        return EindTijd;
    }

    public void setEindTijd(Date eindTijd) {
        EindTijd = eindTijd;
    }

    public double getPrijs() {
        return Prijs;
    }

    public void setPrijs(double prijs) {
        Prijs = prijs;
    }

    public String getLocatie() {
        return Locatie;
    }

    public void setLocatie(String locatie) {
        Locatie = locatie;
    }

    public String getSpecialeVoorkeurenHond() {
        return SpecialeVoorkeurenHond;
    }

    public void setSpecialeVoorkeurenHond(String specialeVoorkeurenHond) {
        SpecialeVoorkeurenHond = specialeVoorkeurenHond;
    }

    public int getCapaciteit() {
        return Capaciteit;
    }

    public void setCapaciteit(int capaciteit) {
        Capaciteit = capaciteit;
    }

    public String getErvaringHonden() {
        return ErvaringHonden;
    }

    public void setErvaringHonden(String ervaringHonden) {
        ErvaringHonden = ervaringHonden;
    }

    public String getOptiesEten() {
        return OptiesEten;
    }

    public void setOptiesEten(String optiesEten) {
        OptiesEten = optiesEten;
    }

    public UUID getAdvertentiePlaatser() {
        return AdvertentiePlaatser;
    }

    public void setAdvertentiePlaatser(UUID advertentiePlaatser) {
        AdvertentiePlaatser = advertentiePlaatser;
    }

    public App_Gebruiker get_AdvertentiePlaatser() {
        return _AdvertentiePlaatser;
    }

    public void set_AdvertentiePlaatser(App_Gebruiker _AdvertentiePlaatser) {
        this._AdvertentiePlaatser = _AdvertentiePlaatser;
        this.AdvertentiePlaatser=_AdvertentiePlaatser.getID();
    }


    // endregion
}
