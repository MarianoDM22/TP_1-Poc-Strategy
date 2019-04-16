package com.marianofernandez.Entidades;

import com.marianofernandez.Strategy.Beber;
import com.marianofernandez.Strategy.Orinar;

public class Humano {
    private String nombre;
    private int edad;
    private int peso;
    Orinar orinar;
    Beber beber;
    int contBeber;
    int contAguante;

    public Humano()
    {}

    public Humano(String nombre, int edad, int peso, Orinar orinar, Beber beber) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.orinar = orinar;
        this.beber = beber;
        this.contBeber = 0;
        this.contAguante = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public Orinar getOrinar() {
        return orinar;
    }

    public void setOrinar(Orinar orinar) {
        this.orinar = orinar;
    }

    public Beber getBeber() {
        return beber;
    }

    public void setBeber(Beber beber) {
        this.beber = beber;
    }

    public int getContBeber() {
        return contBeber;
    }

    public void setContBeber(int contBeber) {
        this.contBeber = contBeber;
    }

    public int getContAguante() {
        return contAguante;
    }

    public void setContAguante(int contAguante) {
        this.contAguante = contAguante;
    }

    public void beber(){
        contBeber += beber.beber();
    }

    public void orinar(){
        contAguante += orinar.orinar();
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Humano{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
