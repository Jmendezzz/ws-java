package co.cue.edu.jugueteria.controllers;

import co.cue.edu.jugueteria.impl.Juguete_impl;
import co.cue.edu.jugueteria.model.Juguete;

import javax.swing.*;

public class Juguete_controller {
    Juguete_impl juguete_impl = new Juguete_impl();
    public  void toysType (Juguete[] toyInventory, int position){
        juguete_impl.toysType(toyInventory,position);
    }
    public  void totalToys (Juguete[] toyInventory, int position){
        juguete_impl.totalToys(toyInventory,position);
    }
    public  void totalToysValue (Juguete[] toyInventory, int position){
        juguete_impl.totalToysValue(toyInventory,position);
    }
    public void minMaxToysType (Juguete[] toyInventory, int position){
        juguete_impl.minMaxToysType(toyInventory,position);
    }
    public void filterToys(Juguete[] toyInventory, int position){
        int priceRange =Integer.parseInt(JOptionPane.showInputDialog("Ingrese el precio para filtar los juguetes")) ;
        juguete_impl.filterToys(toyInventory,position,priceRange);
    }
    public void toyProperties(Juguete[] toyInventory, int position){
        String toyName = JOptionPane.showInputDialog("Ingrese el nombre del juguete que desea conocer las propiedades");
        juguete_impl.toyProperties(toyInventory,position,toyName);
    }
    public Juguete findAToy(Juguete[] toyInventory, int limite){
        String toyName = JOptionPane.showInputDialog("Ingrese el nombre del juguete que se vendió");
        return juguete_impl.findAToy(toyInventory,limite,toyName);
    }
}
