package co.cue.edu.empresa.model;

public class Estudiante extends Persona{
    private int puntajeIngreso;
    public Estudiante(String nombre, String cedula,int puntajeIngreso) {
        super(nombre, cedula);
        this.puntajeIngreso = puntajeIngreso;
    }
}
