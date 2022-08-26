package co.cue.edu.jugueteria.impl;

import co.cue.edu.jugueteria.controllers.Cliente_controller;
import co.cue.edu.jugueteria.controllers.Detalle_venta_controller;
import co.cue.edu.jugueteria.model.Cliente;
import co.cue.edu.jugueteria.model.Detalle_venta;
import co.cue.edu.jugueteria.model.Empleado;
import co.cue.edu.jugueteria.model.Venta;
import co.cue.edu.jugueteria.services.Venta_services;
import javax.swing.*;
public class Venta_impl implements Venta_services {
    Venta salesArray[]= new Venta[100];
    int salesArrayPosition=0;
    Detalle_venta_controller detalle_venta_controller = new Detalle_venta_controller();
    Cliente_controller cliente_controller = new Cliente_controller();
    @Override
    public void createSale(String saleDate, Empleado empleado, Cliente cliente, int totalSoldToys, Detalle_venta[] toysSold) {
        System.out.println(cliente.getUserName());
        System.out.println(empleado.getUserName());
        if (empleado != null && cliente != null){
            salesArray[salesArrayPosition]= new Venta(saleDate,empleado,cliente,totalSoldToys,toysSold);
            detalle_venta_controller.printDetails(salesArray[salesArrayPosition]);
            salesArrayPosition++;
        }else JOptionPane.showMessageDialog(null,"Se ha producico un error en la venta, compruebe las entradas.");

    }

    @Override
    public Cliente decisionClient(int option,Cliente clientArray[], int clientArrayPosition) {
        while (option<1 || option>2) {
            option = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la opción que desea realizar: \n+" +
                    "1. Crear cliente \n" +
                    "2. Cliente existente"));
        }
        switch (option){
            case 1:
                return cliente_controller.createClient();
            case 2:
                return cliente_controller.wantedClient(clientArray,clientArrayPosition);
        }
        return null;
    }

    }
