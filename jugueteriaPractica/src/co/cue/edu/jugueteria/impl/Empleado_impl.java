package co.cue.edu.jugueteria.impl;

import co.cue.edu.jugueteria.controllers.Empleado_controller;
import co.cue.edu.jugueteria.controllers.Jugueteria_controller;
import co.cue.edu.jugueteria.model.Empleado;
import co.cue.edu.jugueteria.services.Empleado_services;

public class Empleado_impl implements Empleado_services {
    @Override
    public Empleado searchEmployee(String employeeName, Empleado[] emploeeArray, int employeeArrayPosition) {
        boolean band = false;
        for (int i = 0; i<employeeArrayPosition; i++){
            if(emploeeArray[i].getUserName().equalsIgnoreCase(employeeName)) {
                band= true;
                return emploeeArray[i];
            }
        }
        return null;
    }

}
