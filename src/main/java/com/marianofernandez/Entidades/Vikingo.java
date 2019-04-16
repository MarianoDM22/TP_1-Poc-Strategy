package com.marianofernandez.Entidades;

import com.marianofernandez.Strategy.Beber;
import com.marianofernandez.Strategy.Orinar;

public class Vikingo extends Humano {

    public static final int Aguante = 3;

    int bebedorProfesional;

    public Vikingo(String nombre, int edad, int peso, Orinar orinar, Beber beber, int bebedorProfesional) {
        super(nombre, edad, peso, orinar, beber);
        this.bebedorProfesional = bebedorProfesional;
    }

    public int getBebedorProfesional() {
        return bebedorProfesional;
    }

    public void setBebedorProfesional(int bebedorProfesional) {
        this.bebedorProfesional = bebedorProfesional;
    }

    public void beber(){
        contBeber += (beber.beber() + bebedorProfesional);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Vikingo{" +
                super.toString() +
                "bebedorProfesional=" + bebedorProfesional +
                '}';
    }
}
