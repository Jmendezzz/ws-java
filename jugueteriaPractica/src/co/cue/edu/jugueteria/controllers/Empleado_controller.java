package co.cue.edu.jugueteria.controllers;

import co.cue.edu.jugueteria.impl.Empleado_impl;
import co.cue.edu.jugueteria.model.Empleado;

import javax.swing.*;

public class Empleado_controller {
    Empleado_impl empleado_impl = new Empleado_impl();
    public Empleado searchEmployee( Empleado[] emploeeArray, int employeeArrayPosition) {
        String employeeName = JOptionPane.showInputDialog("Ingrese el nombre del empleado");
        return empleado_impl.searchEmployee(employeeName,emploeeArray,employeeArrayPosition);

    }
}
