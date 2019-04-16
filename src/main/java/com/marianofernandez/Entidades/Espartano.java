package com.marianofernandez.Entidades;

import com.marianofernandez.Strategy.Beber;
import com.marianofernandez.Strategy.Orinar;

public class Espartano extends Humano {

    public static final int Aguante = 5;

    int toleranciaExtra;

    public Espartano(String nombre, int edad, int peso, Orinar orinar, Beber beber, int toleranciaExtra) {
        super(nombre, edad, peso, orinar, beber);
        this.toleranciaExtra = toleranciaExtra;
    }

    public int getToleranciaExtra() {
        return toleranciaExtra;
    }

    public void setToleranciaExtra(int toleranciaExtra) {
        this.toleranciaExtra = toleranciaExtra;
    }

    public void orinar(){
        contAguante += (orinar.orinar() - toleranciaExtra);
    }

    @Override
    public String toString() {
        return "Espartano{" +
                super.toString() +
                "toleranciaExtra=" + toleranciaExtra +
                '}';
    }
}
