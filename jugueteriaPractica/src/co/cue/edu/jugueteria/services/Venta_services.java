package co.cue.edu.jugueteria.services;

import co.cue.edu.jugueteria.model.Cliente;
import co.cue.edu.jugueteria.model.Detalle_venta;
import co.cue.edu.jugueteria.model.Empleado;
import co.cue.edu.jugueteria.model.Venta;

public interface Venta_services {
    public Venta createSale(String saleDate, Empleado empleado, Cliente cliente, int totalSoldToys, Detalle_venta[] toysSold);

}
