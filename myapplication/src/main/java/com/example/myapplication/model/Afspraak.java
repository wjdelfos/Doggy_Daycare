package com.example.myapplication.model;

import java.util.UUID;

public class Afspraak {
    public enum StatusAfspraken{concept,geaccepteerd,afgewezen,betaald}


    private UUID ID;
    private double AfgesprokenPrijs;
    private StatusAfspraken statusAfspraak;
    private boolean IsgeaccepteerdOppas;
    private boolean Isgeaccepteerdeigenaar;
    private UUID Oppas;
    private UUID Eigenaar;
    private UUID Advertentie;


    public Afspraak(){
        ID= UUID.randomUUID();
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
    // endregion

}
