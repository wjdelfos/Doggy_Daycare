package com.example.myapplication.model;

import java.io.Serializable;
import java.util.UUID;

public class Afspraak implements Serializable {
    public enum StatusAfspraken{concept,geaccepteerd,afgewezen,betaald}


    private UUID ID;
    private double AfgesprokenPrijs;
    private StatusAfspraken statusAfspraak;
    private boolean IsgeaccepteerdOppas;
    private boolean Isgeaccepteerdeigenaar;
    private UUID Oppas;
    private UUID Eigenaar;
    private UUID Advertentie;

    private App_Gebruiker _oppas;
    private App_Gebruiker _eigenaar;
    private Advertentie _advertentie;

    // region Constructors
    public Afspraak(UUID id){
        ID= id;
    }

    public Afspraak(double afgesprokenPrijs, StatusAfspraken statusAfspraak, boolean AcptOpps, boolean AcptEigenaar, UUID oppas, UUID eigenaar, UUID advertentie) {
        this.ID = UUID.randomUUID();
        AfgesprokenPrijs = afgesprokenPrijs;
        this.statusAfspraak = statusAfspraak;
        Isgeaccepteerdeigenaar=AcptEigenaar;
        IsgeaccepteerdOppas=AcptOpps;
        Oppas = oppas;
        Eigenaar = eigenaar;
        Advertentie = advertentie;
    }

    // endregion

    // region Getters and setters

    public UUID getID() {
        return ID;
    }

    public double getAfgesprokenPrijs() {
        return AfgesprokenPrijs;
    }

    public void setAfgesprokenPrijs(double afgesprokenPrijs) {
        AfgesprokenPrijs = afgesprokenPrijs;
    }

    public StatusAfspraken getStatusAfspraak() {
        return statusAfspraak;
    }

    public void setStatusAfspraak(StatusAfspraken statusAfspraak) {
        this.statusAfspraak = statusAfspraak;
    }

    public UUID getOppas() {
        return Oppas;
    }

    public void setOppas(UUID oppas) {
        Oppas = oppas;
    }

    public UUID getEigenaar() {
        return Eigenaar;
    }

    public void setEigenaar(UUID eigenaar) {
        Eigenaar = eigenaar;
    }

    public UUID getAdvertentie() {
        return Advertentie;
    }

    public void setAdvertentie(UUID advertentie) {
        Advertentie = advertentie;
    }

    public boolean isIsgeaccepteerdOppas() {
        return IsgeaccepteerdOppas;
    }

    public void setIsgeaccepteerdOppas(boolean isgeaccepteerdOppas) {
        IsgeaccepteerdOppas = isgeaccepteerdOppas;
    }

    public boolean isIsgeaccepteerdeigenaar() {
        return Isgeaccepteerdeigenaar;
    }

    public void setIsgeaccepteerdeigenaar(boolean isgeaccepteerdeigenaar) {
        Isgeaccepteerdeigenaar = isgeaccepteerdeigenaar;
    }

    public App_Gebruiker get_oppas() {
        return _oppas;
    }

    public void set_oppas(App_Gebruiker _oppas) {
        this._oppas = _oppas;
    }

    public App_Gebruiker get_eigenaar() {
        return _eigenaar;
    }

    public void set_eigenaar(App_Gebruiker _eigenaar) {
        this._eigenaar = _eigenaar;
    }

    public com.example.myapplication.model.Advertentie get_advertentie() {
        return _advertentie;
    }

    public void set_advertentie(com.example.myapplication.model.Advertentie _advertentie) {
        this._advertentie = _advertentie;
    }

    // endregion

}
