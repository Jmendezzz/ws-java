package co.cue.edu.jugueteria.services;

import co.cue.edu.jugueteria.model.Cliente;
import co.cue.edu.jugueteria.model.Empleado;
import co.cue.edu.jugueteria.model.Juguete;

public interface Jugueteria_services {
    public void increaseStock(String toyName, int newAmount, Juguete[] toyArray, int limit);
    public Cliente createClient (String userName, String id, String phoneNumber, String adress, String birthdayDate, String emailAdress);
    public Empleado createEmployee (String userName, String id, String phoneNumber, String adress, int salary, String laborDate);
    public Juguete createToy (String toyName, int toyAmount, int optionCategory, double toyPrice);
}
