package co.cue.edu.jugueteria.impl;

import co.cue.edu.jugueteria.model.Cliente;
import co.cue.edu.jugueteria.model.Detalle_venta;
import co.cue.edu.jugueteria.model.Empleado;
import co.cue.edu.jugueteria.model.Venta;
import co.cue.edu.jugueteria.services.Venta_services;

public class Venta_impl implements Venta_services {
    @Override
    public Venta createSale(String saleDate, Empleado empleado, Cliente cliente, int totalSoldToys, Detalle_venta[] toysSold) {
        return new Venta(saleDate,empleado,cliente,totalSoldToys,toysSold);
    }

}
