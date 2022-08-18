package co.cue.edu.empresa.model;

public class Notas_curso {
    Estudiante estudiante;
    Curso curso;
    int arrayNotas[]=new int[3];

    public Notas_curso(Estudiante estudiante, Curso curso) {
        this.estudiante = estudiante;
        this.curso = curso;
    }

    public void setArrayNotas(int[] arrayNotas) {
        this.arrayNotas = arrayNotas;
    }
}
