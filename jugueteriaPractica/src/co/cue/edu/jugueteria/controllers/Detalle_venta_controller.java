package co.cue.edu.jugueteria.controllers;

import co.cue.edu.jugueteria.impl.Detalle_venta_impl;
import co.cue.edu.jugueteria.model.Detalle_venta;
import co.cue.edu.jugueteria.model.Juguete;
import co.cue.edu.jugueteria.model.Venta;

import javax.swing.*;

public class Detalle_venta_controller {
    Detalle_venta_impl detalle_venta_impl = new Detalle_venta_impl();
    Juguete_controller  juguete_controller = new Juguete_controller();

    public Detalle_venta[] createDetalleVenta( Juguete[] toyInventory, int positionToyInventory,int totalVendidos){
            return detalle_venta_impl.createDetalleVenta(totalVendidos,toyInventory,positionToyInventory);
    }

}
