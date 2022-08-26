package co.cue.edu.jugueteria.controllers;

import co.cue.edu.jugueteria.impl.Venta_impl;
import co.cue.edu.jugueteria.model.*;

import javax.swing.*;

public class Venta_controller {
    Venta_impl venta_impl = new Venta_impl();
    Cliente_controller cliente_controller = new Cliente_controller();
    Empleado_controller empleado_controller = new Empleado_controller();
    Detalle_venta_controller detalle_venta_controller = new Detalle_venta_controller();

    public  void createSale(Juguete toyInventory[],int toyInventoryPosition,Cliente clientArray[], int clientArrayPosition, Empleado employeeArray[], int employeeArrayPosition) {
            String saleDate = JOptionPane.showInputDialog("Ingrese la fecha de la venta");
            Empleado empleado = empleado_controller.searchEmployee(employeeArray,employeeArrayPosition);
             int option = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la opción que desea realizar: \n" +
                "1. Crear cliente \n" +
                "2. Cliente existente"));
            Cliente cliente = venta_impl.decisionClient(option,clientArray,clientArrayPosition);
            int totalSoldToys = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el total de articulos vendidos"));
            Detalle_venta[] arrayDetalleVenta;
            arrayDetalleVenta=detalle_venta_controller.createDetalleVenta(totalSoldToys,toyInventory,toyInventoryPosition);
            venta_impl.createSale(saleDate,empleado,cliente,totalSoldToys,arrayDetalleVenta);
    }


}
