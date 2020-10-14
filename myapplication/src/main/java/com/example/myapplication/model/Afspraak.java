package com.example.myapplication.model;

import java.util.UUID;

public class Afspraak {
    private enum StatusAfspraken{concept,geaccepteerd,afgewezen,betaald}


    private UUID ID;
    private double AfgesprokenPrijs;
    private StatusAfspraken statusAfspraak;
    private UUID Oppas;
    private UUID Eigenaar;
    private UUID Advertentie;


    public Afspraak(){
        ID= UUID.randomUUID();
    }

    public Afspraak(UUID ID, double afgesprokenPrijs, StatusAfspraken statusAfspraak, UUID oppas, UUID eigenaar, UUID advertentie) {
        this.ID = ID;
        AfgesprokenPrijs = afgesprokenPrijs;
        this.statusAfspraak = statusAfspraak;
        Oppas = oppas;
        Eigenaar = eigenaar;
        Advertentie = advertentie;
    }

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
    // endregion

}
