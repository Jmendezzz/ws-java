package co.cue.edu.empresa.model;

public class Programa_academico {
    private String nombrePrograma;
    private String facultadPrograma;
    private Curso arrayCurso[];
    public void setCantidadCursos(int cantidad){
        arrayCurso = new  Curso[cantidad];
    }

    public Programa_academico(String nombrePrograma, String facultadPrograma) {
        this.nombrePrograma = nombrePrograma;
        this.facultadPrograma = facultadPrograma;
    }

    public String getNombrePrograma() {
        return nombrePrograma;
    }

    public void setNombrePrograma(String nombrePrograma) {
        this.nombrePrograma = nombrePrograma;
    }

    public String getFacultadPrograma() {
        return facultadPrograma;
    }

    public void setFacultadPrograma(String facultadPrograma) {
        this.facultadPrograma = facultadPrograma;
    }
}
