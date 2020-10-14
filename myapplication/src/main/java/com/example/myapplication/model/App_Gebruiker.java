package com.example.myapplication.model;

import java.util.Date;
import java.util.UUID;

public class App_Gebruiker {
    // region Private variables
    private UUID ID;
    private enum Geslachten {man, vrouw, overig}
    private Geslachten Geslacht;
    private String Naam;
    private String Plaatsnaam;
    private String Straatnaam;
    private int Huisnummer;
    private String Postcode;
    private int Telefoon_Nummer;
    private Date Geboortedatum;
    private String Wachtwoord;
    private String IntroductieText;
    // endregion

    // region constructor
    public App_Gebruiker(){
        this(UUID.randomUUID());
    }
    public App_Gebruiker(UUID id){
       ID=id;
    }

    public App_Gebruiker( String naam, String plaatsnaam, String straatnaam, int huisnummer, String postcode, int telefoon_Nummer, Date geboortedatum, String wachtwoord, String introductieText) {
        this.ID = UUID.randomUUID();
        Naam = naam;
        Plaatsnaam = plaatsnaam;
        Straatnaam = straatnaam;
        Huisnummer = huisnummer;
        Postcode = postcode;
        Telefoon_Nummer = telefoon_Nummer;
        Geboortedatum = geboortedatum;
        Wachtwoord = wachtwoord;
        IntroductieText = introductieText;
    }

    // endregion

    // region Public getters and setters
    public UUID getID() {
        return ID;
    }

    public String getNaam() {
        return Naam;
    }

    public void setNaam(String naam) {
        Naam = naam;
    }

    public String getPlaatsnaam() {
        return Plaatsnaam;
    }

    public void setPlaatsnaam(String plaatsnaam) {
        Plaatsnaam = plaatsnaam;
    }

    public String getStraatnaam() {
        return Straatnaam;
    }

    public void setStraatnaam(String straatnaam) {
        Straatnaam = straatnaam;
    }

    public int getHuisnummer() {
        return Huisnummer;
    }

    public void setHuisnummer(int huisnummer) {
        Huisnummer = huisnummer;
    }

    public String getPostcode() {
        return Postcode;
    }

    public void setPostcode(String postcode) {
        Postcode = postcode;
    }

    public int getTelefoon_Nummer() {
        return Telefoon_Nummer;
    }

    public void setTelefoon_Nummer(int telefoon_Nummer) {
        Telefoon_Nummer = telefoon_Nummer;
    }

    public Date getGeboortedatum() {
        return Geboortedatum;
    }

    public void setGeboortedatum(Date geboortedatum) {
        Geboortedatum = geboortedatum;
    }

    public String getWachtwoord() {
        return Wachtwoord;
    }

    public void setWachtwoord(String wachtwoord) {
        Wachtwoord = wachtwoord;
    }

    public String getIntroductieText() {
        return IntroductieText;
    }

    public void setIntroductieText(String introductieText) {
        IntroductieText = introductieText;
    }

    public Geslachten getGeslacht() {
        return Geslacht;
    }

    public void setGeslacht(Geslachten geslacht) {
        Geslacht = geslacht;
    }

    // endregion


}
