package co.cue.edu.jugueteria.controllers;

import co.cue.edu.jugueteria.impl.Venta_impl;
import co.cue.edu.jugueteria.model.*;

import javax.swing.*;

public class Venta_controller {
    Venta_impl venta_impl = new Venta_impl();
    Cliente_controller cliente_controller = new Cliente_controller();
    Empleado_controller empleado_controller = new Empleado_controller();
    Detalle_venta_controller detalle_venta_controller = new Detalle_venta_controller();

    public  void createSale(Empleado[] employeeArray, int employeeArrayPosition, Cliente[] clientArray, int positionClientArray, Juguete[] toyInventory, int toyInventoryPosition) {
        if (employeeArrayPosition>0){
            String saleDate = JOptionPane.showInputDialog("Ingrese la fecha de la venta");
            Empleado empleado = empleado_controller.searchEmployee(employeeArray, employeeArrayPosition);
            Cliente cliente = cliente_controller.createClient();
            clientArray[positionClientArray]=cliente;
            int totalSoldToys = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el total de articulos vendidos"));
            Detalle_venta arrayDetalleVenta[];
            arrayDetalleVenta=detalle_venta_controller.createDetalleVenta(toyInventory,toyInventoryPosition,totalSoldToys);
            venta_impl.createSale(saleDate,empleado,cliente,totalSoldToys,arrayDetalleVenta);
            detalle_venta_controller.detalle_venta_impl.printDetails(venta_impl.createSale(saleDate,empleado,cliente,totalSoldToys,arrayDetalleVenta));

        }else JOptionPane.showMessageDialog(null,"Debe crear un empleado para registrar una venta");


    }


}
