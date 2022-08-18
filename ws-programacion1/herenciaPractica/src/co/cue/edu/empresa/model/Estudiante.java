package co.cue.edu.empresa.model;

public class Estudiante extends Persona{
    int notas []= new int[3];
    public Estudiante(String nombre, String cedula) {
        super(nombre, cedula);
    }
}
