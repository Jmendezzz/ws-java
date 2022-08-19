package co.cue.edu.empresa.aplication;

import co.cue.edu.empresa.model.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String categoria= Categoria.AUXILIAR;
        Profesor profesor= new Profesor("","",categoria);
        Programa_academico arrayProgramas[]= new Programa_academico[5];
        int option = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la opción que quiere realizar \n"+
                "1. Crear un programa academico \n"));
        switch (option){
            case 1:
                String nombrePrograma = JOptionPane.showInputDialog("Ingrese el nombre del programa");
                String facultadPrograma = JOptionPane.showInputDialog("Ingrese la faculad a la cual pertenece el programa");
                arrayProgramas[0]= new Programa_academico(nombrePrograma,facultadPrograma);
                int cantidadCursos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de cursos del programa "+ nombrePrograma));
                Curso arrayCursos[] = new Curso[cantidadCursos];

                for ( int i = 0; i<cantidadCursos; i++){

                    String nombreCurso = JOptionPane.showInputDialog("Ingrese el nombre del curso" + (i+1));
                    String nombreProfesor =  JOptionPane.showInputDialog("Ingrese el nombre del profesor de "+nombreCurso);
                    String cedulaProfesor = JOptionPane.showInputDialog("Ingrese la cedula del docente "+nombreProfesor);
                    Profesor profesorAsignado  = new Profesor(nombreProfesor,cedulaProfesor,Categoria.AUXILIAR);
                    int cantidadEstudiantes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de estudiantes del curso de " +nombreCurso));
                    Notas_curso arrayEstudiantesNotas[] = new Notas_curso[cantidadEstudiantes];
                    arrayCursos[i]=new Curso (nombreCurso,profesorAsignado);
                    arrayCursos[i].cantidadEstudiante(cantidadEstudiantes);
                    for (int j = 0 ; j<cantidadEstudiantes; j++){
                        String nombreEstudiante = JOptionPane.showInputDialog("Ingrese el nombre del estudiante "+(j+1));
                        String identificacionEstudiante = JOptionPane.showInputDialog("Ingrese el No. de identificación de "+nombreEstudiante);
                        int puntajeAdmision = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el puntaje de admision de "+ nombreEstudiante));
                        arrayEstudiantesNotas[j] = new Notas_curso(new Estudiante(nombreEstudiante,identificacionEstudiante,puntajeAdmision),arrayCursos[i]);
                        arrayCursos[i].setArrayEstudiante(arrayEstudiantesNotas[j],j);
                    }
                }

                break;
        }
    }
}