package co.cue.edu.jugueteria.impl;

import co.cue.edu.jugueteria.model.Cliente;
import co.cue.edu.jugueteria.services.Cliente_services;


public class Cliente_impl implements Cliente_services {
    Cliente clientArray[] = new Cliente[20];
    int clientArrayPosition = 0;

    public Cliente[] getClientArray() {
        return clientArray;
    }

    public int getClientArrayPosition() {
        return clientArrayPosition;
    }

    public Cliente createClient (String userName, String id, String phoneNumber, String adress, String birthdayDate, String emailAdress){
        clientArray[clientArrayPosition]= new Cliente(userName,id,phoneNumber,adress,birthdayDate,emailAdress);
        clientArrayPosition++;
        return new Cliente(userName,id,phoneNumber,adress,birthdayDate,emailAdress);

    }

    @Override
    public Cliente wantedClient(String clientName, Cliente clientArray[], int clientArrayPosition) {
        for (int i = 0 ; i<clientArrayPosition;i++){
            if (clientArray[i].getUserName().equalsIgnoreCase(clientName)){
                return  clientArray[i];
            }
        }
        return null;
    }

}
