package co.cue.edu.jugueteria.impl;

import co.cue.edu.jugueteria.model.Categoria;
import co.cue.edu.jugueteria.model.Cliente;
import co.cue.edu.jugueteria.model.Empleado;
import co.cue.edu.jugueteria.model.Juguete;
import co.cue.edu.jugueteria.services.Jugueteria_services;

import javax.swing.*;

public class Jugueteria_impl implements Jugueteria_services {
    @Override
    public void increaseStock(String toyName, int newAmount, Juguete toyArray[], int limit) {
        boolean band = false;
        for (int i = 0; i< limit;i++){
            if(toyName.equalsIgnoreCase(toyArray[i].toyName)){
                toyArray[i].setToyAmount(newAmount+toyArray[i].getToyAmount());
                band= true;
            }
        }
        if (!band){
            JOptionPane.showMessageDialog(null,"El juguete ingresado no se encontró, intente nuevamente.");
        }else JOptionPane.showMessageDialog(null, "Unidades añadidas exitosamente!");
    }

    @Override
    public Cliente createClient(String userName, String id, String phoneNumber, String adress, String birthdayDate, String emailAdress) {
         return new Cliente(userName,id,phoneNumber,adress,birthdayDate,emailAdress);
    }

    @Override
    public Empleado createEmployee(String userName, String id, String phoneNumber, String adress, int salary, String laborDate) {
        return new Empleado(userName,id,phoneNumber,adress,salary,laborDate);
    }

    @Override
    public Juguete createToy(String toyName, int toyAmount, int optionCategory, double toyPrice) {

        while((optionCategory<1) || (optionCategory>3)){
            JOptionPane.showMessageDialog(null,"Ingrese una categoría válida");
            optionCategory = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la categoria del juguete \n"+
                    "1. Plastico \n"+
                    "2. Tela \n"+
                    "3. Electronico"));
        }
        String toyCategory = null;
        switch (optionCategory){
            case 1:
                toyCategory= Categoria.PLASTICO;
                break;
            case 2:
                toyCategory = Categoria.TELA;
                break;
            case 3:
                toyCategory = Categoria.ELECTRONICO;
                break;
        }
        return new Juguete(toyName,toyAmount,toyCategory,toyPrice);
    }


}
