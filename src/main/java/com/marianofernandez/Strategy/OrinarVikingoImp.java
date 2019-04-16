package com.marianofernandez.Strategy;

import java.util.Random;

public class OrinarVikingoImp implements Orinar {

    Random random = new Random();

    public int orinar() {
        return random.nextInt(15 - 1) + 1;
    }
}
