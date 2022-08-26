package co.cue.edu.jugueteria.impl;
import co.cue.edu.jugueteria.aux_impl.Aux_impl;
import co.cue.edu.jugueteria.model.Categoria;
import co.cue.edu.jugueteria.model.Juguete;
import co.cue.edu.jugueteria.services.Juguete_services;

import javax.swing.*;

public class Juguete_impl implements Juguete_services {
    public Juguete[] toyInventory = new Juguete[100];
    public int toyInventoryPosition = 0;
    Aux_impl aux_impl = new Aux_impl();



    @Override
    public void addToyInventory(String toyName, int toyAmount, int optionCategory, double toyPrice) {
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
        toyInventory[toyInventoryPosition] = new Juguete(toyName,toyAmount,toyCategory,toyPrice);
        toyInventoryPosition++;
    }

    @Override
    public void toysType() {
        int acumuladorPlastico=0;
        int acumuladorTela = 0;
        int acumuladorElectronico = 0;
        if(toyInventoryPosition >0){
            for (int i = 0; i< toyInventoryPosition; i++){
                if(toyInventory[i].toyCategory.equals(Categoria.PLASTICO)) acumuladorPlastico = acumuladorPlastico+ toyInventory[i].getToyAmount();
                else if (toyInventory[i].toyCategory.equals(Categoria.TELA)) acumuladorTela = acumuladorTela + toyInventory[i].getToyAmount();
                else acumuladorElectronico = acumuladorElectronico + toyInventory[i].getToyAmount();
            }
            JOptionPane.showMessageDialog(null, "Hay "+ acumuladorPlastico +" juguetes de tipo 'Plastico'\n"+
                    "Hay "+ acumuladorTela + " juguetes de tipo 'Tela'\n"+
                    "Hay "+ acumuladorElectronico+ " juguetes de tipo 'Electronico'");
        }else JOptionPane.showMessageDialog(null, "Aún no se ha agregado ningún juguete al inventario");
    }

    @Override
    public void totalToys() {
        if (toyInventoryPosition>0){
            int totalToys = 0;
            for (int i = 0 ; i<toyInventoryPosition; i++){
                totalToys= toyInventory[i].getToyAmount()+totalToys;
            }
            JOptionPane.showMessageDialog(null,"Actualmente la juguetería cuenta con "+totalToys + " juguetes");

        }else JOptionPane.showMessageDialog(null,"Aún no se ha agregado ningún juguete al inventario");

    }

    @Override
    public void totalToysValue() {
        if (toyInventoryPosition >0){
            double totalToysValue = 0;
            for (int i = 0; i<toyInventoryPosition; i++){
                totalToysValue = (toyInventory[i].getToyPrice() * toyInventory[i].getToyAmount())+totalToysValue;
            }
            JOptionPane.showMessageDialog(null,"El valor total de los juguetes de la tienda es de: "+totalToysValue);

        }else  JOptionPane.showMessageDialog(null,"Aún no se ha agregado ningún juguete al inventario");

    }

    @Override
    public void minMaxToysType() {
        if (toyInventoryPosition >0){
           int acumuladorTela=0;
           int acumuladorPlastico=0;
           int acumuladorElectronic=0;

            String categoriaMenor;
            String categoriaMayor;
            for ( int i = 0; i<toyInventoryPosition ; i++){
                if (toyInventory[i].toyCategory.equals(Categoria.PLASTICO)) acumuladorPlastico+= toyInventory[i].getToyAmount();
                else if (toyInventory[i].toyCategory.equals(Categoria.TELA)) acumuladorTela += toyInventory[i].getToyAmount();
                else acumuladorElectronic+=toyInventory[i].getToyAmount();
            }
            //calcular mayor
            if (aux_impl.mayor(acumuladorPlastico,acumuladorElectronic,acumuladorTela)){
                categoriaMayor= Categoria.PLASTICO;
            }else{
                if(aux_impl.mayor(acumuladorTela,acumuladorElectronic,acumuladorPlastico)){
                    categoriaMayor=Categoria.TELA;
                }else categoriaMayor = Categoria.ELECTRONICO;
            }
            //calcular menor
            if (aux_impl.menor(acumuladorPlastico,acumuladorElectronic,acumuladorElectronic)) {
                categoriaMenor = Categoria.PLASTICO;
            }
            else{
                if(aux_impl.menor(acumuladorTela,acumuladorElectronic,acumuladorPlastico)){
                    categoriaMenor = Categoria.TELA;
                }else categoriaMenor= Categoria.ELECTRONICO;
            }
        JOptionPane.showMessageDialog(null, "La categoría con mas juguetes disponibles es juguetes de: " + categoriaMayor + "\n"+
                "La categoría con menos juguetes disponibles es juguetes de: "+ categoriaMenor);
        }else  JOptionPane.showMessageDialog(null,"Aún no se ha agregado ningún juguete al inventario");

    }

    @Override
    public void filterToys(int price) {
        if (toyInventoryPosition >0 ){
            Juguete filteredToys[];
            int totalToys=0;
            int positionFilteredToys=0;
            StringBuilder finalString= new StringBuilder();
            for (int i= 0; i<toyInventoryPosition ; i++){
                if(toyInventory[i].getToyPrice()>=price){
                    totalToys++;
                }
            }
            if (totalToys!=0){
                filteredToys = new Juguete[totalToys];
                for (int i = 0; i<toyInventoryPosition; i++){
                    if(toyInventory[i].getToyPrice()>=price){
                        filteredToys[positionFilteredToys]=toyInventory[i];
                        finalString.append("\nNombre:").append(filteredToys[positionFilteredToys].getToyName()).append(" / ").append("Precio: ").append(filteredToys[positionFilteredToys].getToyPrice()).append("\n");
                        positionFilteredToys++;
                    }
                }
                JOptionPane.showMessageDialog(null, "Los juguetes con coinciden con la busqueda son: \n" + finalString);
            }else JOptionPane.showMessageDialog(null,"Lo sentimos, no se encontró ningún juguete que sueperar el rango de precio.");

        }else JOptionPane.showMessageDialog(null,"Aún no se ha agregado ningún juguete al inventario");


    }

    @Override
    public void toyProperties(String toyName) {
        boolean band = false;
        for (int i = 0; i<toyInventoryPosition ; i++){
            if (toyInventory[i].getToyName().equalsIgnoreCase(toyName)){
                JOptionPane.showMessageDialog(null, "Nombre :"+ toyInventory[i].getToyName() + "\n"+
                        "Cantidad :"+ toyInventory[i].getToyAmount() + "\n" +
                        "Precio :" + toyInventory[i].getToyPrice() + "\n"+
                        "Material :" + toyInventory[i].getToyCategory());
                band= true;
            }
        }
        if (!band){
            JOptionPane.showMessageDialog(null,"No se encontró el juguete ingresado");
        }
    }

    @Override
    public Juguete findAToy(String toyName) {
        for (int i = 0; i < toyInventoryPosition; i++) {
            if (toyInventory[i].getToyName().equalsIgnoreCase(toyName)) {
                return toyInventory[i];
            }
        }
        return null;
    }

    @Override
    public void increaseStock(String toyName, int newAmount) {
        boolean band = false;
        for (int i = 0; i< toyInventoryPosition;i++){
            if(toyName.equalsIgnoreCase(toyInventory[i].toyName)){
                toyInventory[i].setToyAmount(newAmount+toyInventory[i].getToyAmount());
                band= true;
            }
        }
        if (!band){
            JOptionPane.showMessageDialog(null,"El juguete ingresado no se encontró, intente nuevamente.");
        }else JOptionPane.showMessageDialog(null, "Unidades añadidas exitosamente!");
    }
    public Juguete[] getToyInventory() {
        return toyInventory;
    }

    public int getToyInventoryPosition() {
        return toyInventoryPosition;
    }
}
