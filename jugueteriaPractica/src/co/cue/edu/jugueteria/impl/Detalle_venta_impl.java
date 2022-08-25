package co.cue.edu.jugueteria.impl;

import co.cue.edu.jugueteria.controllers.Juguete_controller;
import co.cue.edu.jugueteria.model.Detalle_venta;
import co.cue.edu.jugueteria.model.Juguete;
import co.cue.edu.jugueteria.model.Venta;
import co.cue.edu.jugueteria.services.Detalle_venta_services;

import javax.swing.*;

public class Detalle_venta_impl implements Detalle_venta_services {
    Juguete_controller juguete_controller = new Juguete_controller();
    @Override
    public Detalle_venta[] createDetalleVenta( int totalVendidos,Juguete toyInventory[],int toyInventoryPosition) {

        Detalle_venta[] detalleVenta= new Detalle_venta[totalVendidos];
        for (int i = 0; i<totalVendidos;i++){
            Juguete soldToy = juguete_controller.findAToy(toyInventory,toyInventoryPosition);
            int soldAmount= Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad vendida"));
            soldToy.setToyAmount(soldToy.getToyAmount()-soldAmount);
            detalleVenta[i]=new Detalle_venta(soldToy,soldAmount);

        }
        return detalleVenta;
    }

    @Override
    public void printDetails(Venta venta) {
        JOptionPane.showMessageDialog(null, "Detalles de la venta: \n"+
                "Atendió: "+ venta.getEmployee().getUserName() + "\n"
        + "Cliente: "+ venta.getClient().getUserName() + "\n"+
            "Fecha: "+venta.getSaleDate());
    }
}
