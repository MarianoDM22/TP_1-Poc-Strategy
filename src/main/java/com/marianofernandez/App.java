package com.marianofernandez;

import com.marianofernandez.Entidades.Espartano;
import com.marianofernandez.Entidades.Humano;
import com.marianofernandez.Entidades.Vikingo;
import com.marianofernandez.Jdbc.Jdbc;
import com.marianofernandez.Strategy.BeberEspartanoImp;
import com.marianofernandez.Strategy.BeberVikingoImp;
import com.marianofernandez.Strategy.OrinarEspartanoImp;
import com.marianofernandez.Strategy.OrinarVikingoImp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "BATALLA DE FRESCAS!!!" );

        Jdbc jdbc = new Jdbc();
        String ganador = " ";

        List<Humano> EquipoVikingo = Arrays.asList(
                new Vikingo("Odin", 99, 100, new OrinarVikingoImp(), new BeberVikingoImp(), 5),
                new Vikingo("Thor", 30, 95, new OrinarVikingoImp(), new BeberVikingoImp(), 3),
                new Vikingo("Loki", 21, 70, new OrinarVikingoImp(), new BeberVikingoImp(), 2));

        List<Humano> EquipoEspartano = Arrays.asList(
                new Espartano("Zeus", 99, 100, new OrinarEspartanoImp(), new BeberEspartanoImp(), 5),
                new Espartano("Homero", 45, 75, new OrinarEspartanoImp(), new BeberEspartanoImp(), 3),
                new Espartano("Hercules", 18, 90, new OrinarEspartanoImp(), new BeberEspartanoImp(), 2));

        Humano tabernero = new Humano("German", 33, 75, new OrinarEspartanoImp(), new BeberVikingoImp());

        //ORDENO POR PESO
        List<Humano> ordenarVikingos = (EquipoVikingo.stream()
                .sorted(Comparator.comparing(Humano::getPeso))
                .collect(Collectors.toList()));

        List<Humano> ordenarEspartanos = (EquipoEspartano.stream()
                .sorted(Comparator.comparing(Humano::getPeso))
                .collect(Collectors.toList()));

        //MUESTRO ORDENADOS
        System.out.println(String.format("VIKINGOS: %s", ordenarVikingos));
        System.out.println(String.format("ESPARTANOS: %s", ordenarEspartanos));

        //AGARRO EL PRIMERO DE CADA EQUIPO
        Optional<Humano> vikingo = ordenarVikingos.stream().findFirst();
        Optional<Humano> espartano = ordenarEspartanos.stream().findFirst();

        //MUESTRO ENFRENTAMIENTO
        System.out.println(String.format("\nVIKINGOS: %s", vikingo.get().toString()));
        System.out.println("VS");
        System.out.println(String.format("ESPARTANOS: %s ", espartano.get().toString()));

        //INICIA ENFRENTAMIENTO
        while (vikingo.get().getContAguante() <= Vikingo.Aguante){
            vikingo.get().orinar();
            vikingo.get().beber();
        }

        while (espartano.get().getContAguante() <= Espartano.Aguante){
            espartano.get().orinar();
            espartano.get().beber();
        }

        //RESULTADOS
        if (vikingo.get().getContBeber() > espartano.get().getContBeber()){
            System.out.println("\nEQUIPO VIKINGOS GANAN!!!");
            System.out.println(String.format("VIKINGO: %s", vikingo.get().getContBeber()));
            System.out.println(String.format("ESPARTANO: %s", espartano.get().getContBeber()));
            jdbc.insertJdbc(vikingo);
            ganador = "vikingos";
        }
        else if (vikingo.get().getContBeber() < espartano.get().getContBeber()){
            System.out.println("\nEQUIPO ESPARTANO GANA!!!");
            System.out.println(String.format("VIKINGO: %s", vikingo.get().getContBeber()));
            System.out.println(String.format("ESPARTANO: %s", espartano.get().getContBeber()));
            jdbc.insertJdbc(espartano);
            ganador = "espartanos";
        }
        else{
            System.out.println("EMPATE!!!");
            System.out.println(String.format("VIKINGO: %s", vikingo.get().getContBeber()));
            System.out.println(String.format("ESPARTANO: %s", espartano.get().getContBeber()));
            ganador = "empate";
        }

        //SI NO SE EMPATA EL GANADARO VA CONTRA EL TABERNERO
        if (!ganador.equals("empate")) {
            System.out.println("\n\nEL TABERNO MITAD VIKINGO MITAD ESPARTANO APARECE!!");

            if (ganador.equals("vikingos")) {
                vikingo.get().setContAguante(0);
                vikingo.get().setContBeber(0);

                System.out.println(String.format("\nVIKINGO: %s", vikingo.get().toString()));
                System.out.println("VS");
                System.out.println(String.format("TABERNERO: %s ", tabernero.toString()));

                while (tabernero.getContAguante() <= 10) {
                    tabernero.orinar();
                    tabernero.beber();
                }

                while (vikingo.get().getContAguante() <= Vikingo.Aguante) {
                    vikingo.get().orinar();
                    vikingo.get().beber();
                }

                if (tabernero.getContBeber() > vikingo.get().getContBeber()) {
                    System.out.println("\nEL TABERNERO ES UN DIOS!!");
                    System.out.println(String.format("VIKINGO: %s", vikingo.get().getContBeber()));
                    System.out.println(String.format("TABERNERO: %s", tabernero.getContBeber()));
                }
                else if (tabernero.getContBeber() < vikingo.get().getContBeber()) {
                    System.out.println("\nVIKINGOS GANAN!!");
                    System.out.println(String.format("VIKINGO: %s", vikingo.get().getContBeber()));
                    System.out.println(String.format("TABERNERO: %s", tabernero.getContBeber()));
                }
                else {
                    System.out.println("\nES UN EMPATE!!!!!");
                    System.out.println(String.format("VIKINGO: %s", vikingo.get().getContBeber()));
                    System.out.println(String.format("TABERNERO: %s", tabernero.getContBeber()));
                }
            } else {
                espartano.get().setContAguante(0);
                espartano.get().setContBeber(0);

                System.out.println(String.format("\nESPARTANO", espartano.get().toString()));
                System.out.println("VS");
                System.out.println(String.format("TABERNERO %s ", tabernero.toString()));

                while (espartano.get().getContAguante() <= Espartano.Aguante) {
                    espartano.get().orinar();
                    espartano.get().beber();
                }

                while (tabernero.getContAguante() <= Espartano.Aguante) {
                    tabernero.orinar();
                    tabernero.beber();
                }

                if (tabernero.getContBeber() > espartano.get().getContBeber()) {
                    System.out.println("\nEL TABERNERO ES UN DIOS!!");
                    System.out.println(String.format("ESPARTANOS: %s", espartano.get().getContBeber()));
                    System.out.println(String.format("TABERNERO: %s", tabernero.getContBeber()));
                }
                else if (tabernero.getContBeber() < espartano.get().getContBeber()) {
                    System.out.println("\nESPARTANOS GANAN!!");
                    System.out.println(String.format("ESPARTANOS: %s", espartano.get().getContBeber()));
                    System.out.println(String.format("TABERNERO: %s", tabernero.getContBeber()));
                }
                else {
                    System.out.println("\nES UN EMPATE!!!!!");
                    System.out.println(String.format("ESPAETANOS: %s", espartano.get().getContBeber()));
                    System.out.println(String.format("TABERNERO: %s", tabernero.getContBeber()));
                }
            }
        }
    }
}
