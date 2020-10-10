package com.example.myapplication.model;

import java.util.UUID;

public class Afspraak {
    private UUID ID;
    private double AfgesprokenPrijs;
    private enum Status{concept,geaccepteerd,afgewezen,betaald}

}
