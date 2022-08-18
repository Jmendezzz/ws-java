package co.cue.edu.empresa.aplication;

import co.cue.edu.empresa.model.Categoria;
import co.cue.edu.empresa.model.Profesor;

public class Main {
    public static void main(String[] args) {
        String categoria= Categoria.AUXILIAR;
        Profesor profesor= new Profesor("","",categoria);

        System.out.println("Hello world!");
    }
}