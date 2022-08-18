package co.cue.edu.empresa.model;

public class Profesor extends Persona{

    private String categoria;
    public Profesor(String nombre, String cedula,String categoria) {
        super(nombre, cedula);
        this.categoria= categoria;
    }

    public String getCategoria() {
        return categoria;
    }
}
