package co.cue.edu.jugueteria.aplication;

import co.cue.edu.jugueteria.controllers.Juguete_controller;
import co.cue.edu.jugueteria.controllers.Jugueteria_controller;
import co.cue.edu.jugueteria.controllers.Menu_controller;
import co.cue.edu.jugueteria.controllers.Venta_controller;
import co.cue.edu.jugueteria.impl.Menu_impl;
import co.cue.edu.jugueteria.model.Cliente;
import co.cue.edu.jugueteria.model.Empleado;
import co.cue.edu.jugueteria.model.Juguete;
import co.cue.edu.jugueteria.model.Venta;

import javax.swing.*;

public class Jugueteria {
    public static void main(String[] args) {
        Juguete toyInventory []= new Juguete[100];
        Cliente clientArray [] = new Cliente[20];
        Empleado employeeArray[] = new Empleado[5];
        int employeeArrayPosition=0;
        int toyInventoryPosition=0;
        int positionArregloCliente=0;
        Jugueteria_controller jugueteria_controller = new Jugueteria_controller();
        Menu_controller menu_controller = new Menu_controller();
        Juguete_controller juguete_controller  = new Juguete_controller();
        Venta_controller venta_controller = new Venta_controller();
        int option=1;
        while (option!=0){
            option=menu_controller.mainMenu();
            switch (option){
                case 1:
                    switch (menu_controller.creationMenu()){
                        case 1:
                            jugueteria_controller.createToy(toyInventory,toyInventoryPosition);
                            toyInventoryPosition++;
                            break;
                        case 2:
                            jugueteria_controller.createEmployee(employeeArray,employeeArrayPosition);
                            employeeArrayPosition++;
                            break;
                    }break;
                case 2:
                    switch (menu_controller.reportMenu()){
                        case 1:
                            juguete_controller.toysType(toyInventory,toyInventoryPosition);
                            break;
                        case 2:
                            juguete_controller.totalToys(toyInventory,toyInventoryPosition);
                            break;
                        case 3:
                            juguete_controller.totalToysValue(toyInventory,toyInventoryPosition);
                            break;
                        case 4:
                            juguete_controller.minMaxToysType(toyInventory,toyInventoryPosition);
                            break;
                        case 5:
                            juguete_controller.filterToys(toyInventory,toyInventoryPosition);
                            break;
                        case 6:
                            jugueteria_controller.increaseStock(toyInventory,toyInventoryPosition);
                            break;
                        case 7:
                            juguete_controller.toyProperties(toyInventory,toyInventoryPosition);
                            break;
                    }break;
                case 3:
                    venta_controller.createSale(employeeArray,employeeArrayPosition,clientArray,positionArregloCliente,toyInventory,toyInventoryPosition);
                    break;
            }
        }
    }
}