package co.cue.edu.jugueteria.impl;

import co.cue.edu.jugueteria.model.Cliente;
import co.cue.edu.jugueteria.services.Cliente_services;

public class Cliente_impl implements Cliente_services {
    public Cliente createClient ( String userName, String id, String phoneNumber, String adress, String birthdayDate, String emailAdress){
        return new Cliente(userName,id,phoneNumber,adress,birthdayDate,emailAdress);
    }

}
