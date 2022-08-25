package co.cue.edu.jugueteria.controllers;

import co.cue.edu.jugueteria.impl.Jugueteria_impl;
import co.cue.edu.jugueteria.model.Cliente;
import co.cue.edu.jugueteria.model.Empleado;
import co.cue.edu.jugueteria.model.Juguete;

import javax.swing.*;

public class Jugueteria_controller {
    Jugueteria_impl jugueteria_impl = new Jugueteria_impl();
    public void increaseStock(Juguete toyInventory[], int limit){
        String toyName = JOptionPane.showInputDialog("Ingrese el nombre del juguete");
        int newAmount = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad que desea agregar"));
        jugueteria_impl.increaseStock(toyName,newAmount,toyInventory,limit);
    }
    public void  createClient(Cliente[] clientArray, int position){

        String clientName = JOptionPane.showInputDialog("Ingrese el nombre del cliente");
        String clientId = JOptionPane.showInputDialog("Ingrese la cedula del cliente");
        String clientPhoneNumber = JOptionPane.showInputDialog("Ingrese el numero telefonico del cliente "+ clientName);
        String clientAdress = JOptionPane.showInputDialog("Ingrese la direccion de la vivienda del cliente "+ clientName);
        String clientBirthdayDate = JOptionPane.showInputDialog("Ingrese la fecha de cumpleaños del cliente " + clientName);
        String clientEmail = JOptionPane.showInputDialog("Ingrese el correo electronico del cliente "+ clientName);
        clientArray [position]= jugueteria_impl.createClient(clientName,clientId,clientPhoneNumber,clientAdress,clientBirthdayDate,clientEmail);
    }
    public void createEmployee (Empleado[] employeeArray, int position ){

        String employeeName = JOptionPane.showInputDialog("Ingrese el nombre del empleado");
        String employeeId = JOptionPane.showInputDialog("Ingrese la cedula del empleado");
        String employeePhoneNumber = JOptionPane.showInputDialog("Ingrese el numero telefonico del empleado "+ employeeName);
        String employeeAdress = JOptionPane.showInputDialog("Ingrese la direccion de la vivienda del empleado "+ employeeName);
        int employeeSalary = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el salario del empleado "+employeeName));
        String employeeLaborDate = JOptionPane.showInputDialog("Ingrese la fecha de ingreso laboral del empleado "+ employeeName);
        employeeArray[position] = new Empleado(employeeName,employeeId,employeePhoneNumber,employeeAdress,employeeSalary,employeeLaborDate);
    }

    public void createToy(Juguete toyInventory[], int position){

        String toyName = JOptionPane.showInputDialog("Ingrese el nombre del juguete");
        int toyAmount =Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad del juguete " +toyName));
        double toyPrice = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del juguete "+ toyName));
        int categoryOption = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la categoria del juguete \n"+
                "1. Plastico \n"+
                "2. Tela \n"+
                "3. Electronico"));
        toyInventory[position] = jugueteria_impl.createToy(toyName,toyAmount,categoryOption,toyPrice);

    }

}
