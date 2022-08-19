package co.cue.edu.empresa.model;

public class Curso {
    private Notas_curso[] arrayEstudiante;
    public String nombreCurso;
    private Profesor profesorAginado;

    public Curso(String nombreCurso, Profesor profesorAginado) {
        this.nombreCurso = nombreCurso;
        this.profesorAginado = profesorAginado;
    }

    public void cantidadEstudiante(int cantidad){
        arrayEstudiante = new Notas_curso[cantidad];
    }
    public void setArrayEstudiante(Notas_curso estudiante,int position){
        arrayEstudiante[position] = estudiante;
    }
    public Profesor getProfesorAginado() {
        return profesorAginado;
    }

    public void setProfesorAginado(Profesor profesorAginado) {
        this.profesorAginado = profesorAginado;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }
}
