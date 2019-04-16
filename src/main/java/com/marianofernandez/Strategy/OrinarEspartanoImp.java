package com.marianofernandez.Strategy;

import java.util.Random;

public class OrinarEspartanoImp implements Orinar {

    Random random = new Random();

    public int orinar()
    {
        return random.nextInt(10 - 1) + 1;
    }
}
