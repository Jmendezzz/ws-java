package co.cue.edu.jugueteria.aplication;

import co.cue.edu.jugueteria.controllers.*;
import co.cue.edu.jugueteria.impl.Cliente_impl;
import co.cue.edu.jugueteria.impl.Menu_impl;
import co.cue.edu.jugueteria.model.Cliente;
import co.cue.edu.jugueteria.model.Empleado;
import co.cue.edu.jugueteria.model.Juguete;
import co.cue.edu.jugueteria.model.Venta;

import javax.swing.*;

public class Jugueteria {
    public static void main(String[] args) {
        Jugueteria_controller jugueteria_controller = new Jugueteria_controller();
        Menu_controller menu_controller = new Menu_controller();
        Juguete_controller juguete_controller  = new Juguete_controller();
        Venta_controller venta_controller = new Venta_controller();
        Empleado_controller empleado_controller = new Empleado_controller();
        Cliente_controller cliente_controller = new Cliente_controller();
        int option=1;
        while (option!=0){
            option=menu_controller.mainMenu();
            switch (option){
                case 1:
                    switch (menu_controller.creationMenu()){
                        case 1:
                                juguete_controller.addToyInventory();
                            break;
                        case 2:
                            empleado_controller.createEmployee();
                            break;
                    }break;
                case 2:
                    switch (menu_controller.reportMenu()){
                        case 1:
                            juguete_controller.toysType();
                            break;
                        case 2:
                            juguete_controller.totalToys();
                            break;
                        case 3:
                            juguete_controller.totalToysValue();
                            break;
                        case 4:
                            juguete_controller.minMaxToysType();
                            break;
                        case 5:
                            juguete_controller.filterToys();
                            break;
                        case 6:
                            juguete_controller.increaseStock();
                            break;
                        case 7:
                            juguete_controller.toyProperties();
                            break;
                    }break;
                case 3:
                    venta_controller.createSale(juguete_controller.service().getToyInventory(),juguete_controller.service().getToyInventoryPosition(),cliente_controller.services().getClientArray(),cliente_controller.services().getClientArrayPosition(),empleado_controller.services().getEmployeeArray(),empleado_controller.services().getEmployeeArrayPosition());
                    break;
            }
        }
    }
}