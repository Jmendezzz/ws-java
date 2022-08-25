package co.cue.edu.jugueteria.impl;
import co.cue.edu.jugueteria.aux_impl.Aux_impl;
import co.cue.edu.jugueteria.model.Categoria;
import co.cue.edu.jugueteria.model.Juguete;
import co.cue.edu.jugueteria.services.Juguete_services;

import javax.swing.*;

public class Juguete_impl implements Juguete_services {
    Aux_impl aux_impl = new Aux_impl();

    @Override
    public void toysType(Juguete toyInventory[],int limit) {
        int acumuladorPlastico=0;
        int acumuladorTela = 0;
        int acumuladorElectronico = 0;
        if(limit>0){
            for (int i = 0; i<limit;i++){
                if(toyInventory[i].toyCategory.equals(Categoria.PLASTICO)) acumuladorPlastico = acumuladorPlastico+ toyInventory[i].getToyAmount();
                else if (toyInventory[i].toyCategory.equals(Categoria.TELA)) acumuladorTela = acumuladorTela + toyInventory[i].getToyAmount();
                else acumuladorElectronico = acumuladorElectronico + toyInventory[i].getToyAmount();
            }
            JOptionPane.showMessageDialog(null, "Hay "+ acumuladorPlastico +" juguetes de tipo 'Plastico'\n"+
                    "Hay "+ acumuladorTela + " juguetes de tipo 'Tela'\n"+
                    "Hay "+ acumuladorElectronico+ " juguetes de tipo 'Electronico'");
        }else JOptionPane.showMessageDialog(null, "Aún no se ha agrgado ningun juguete al inventario");


    }

    @Override
    public void totalToys(Juguete[] toyInventory, int limite) {
        if (limite>0){
            int totalToys = 0;
            for (int i = 0 ; i<limite; i++){
                totalToys= toyInventory[i].getToyAmount()+totalToys;
            }
            JOptionPane.showMessageDialog(null,"Actualmente la juguetería cuenta con "+totalToys + " juguetes");

        }else JOptionPane.showMessageDialog(null,"Aún no se ha agregado ningún juguete al inventario");

    }

    @Override
    public void totalToysValue(Juguete[] toyInventory, int limite) {
        if (limite >0){
            double totalToysValue = 0;
            for (int i = 0; i<limite; i++){
                totalToysValue = (toyInventory[i].getToyPrice() * toyInventory[i].getToyAmount())+totalToysValue;
            }
            JOptionPane.showMessageDialog(null,"El valor total de los juguetes de la tienda es de: "+totalToysValue);

        }else  JOptionPane.showMessageDialog(null,"Aún no se ha agregado ningún juguete al inventario");

    }

    @Override
    public void minMaxToysType(Juguete[] toyInventory, int limite) {
        if (limite >0){
           int acumuladorTela=0;
           int acumuladorPlastico=0;
           int acumuladorElectronic=0;

            String categoriaMenor;
            String categoriaMayor;
            for ( int i = 0; i<limite ; i++){
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
    public void filterToys(Juguete[] toyInventory, int limite, int price) {
        if (limite >0 ){
            Juguete filteredToys[];
            int totalToys=0;
            int positionFilteredToys=0;
            StringBuilder finalString= new StringBuilder();
            for (int i= 0; i<limite ; i++){
                if(toyInventory[i].getToyPrice()>=price){
                    totalToys++;
                }
            }
            if (totalToys!=0){
                filteredToys = new Juguete[totalToys];
                for (int i = 0; i<limite; i++){
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
    public void toyProperties(Juguete[] toyInventory, int limite, String toyName) {
        boolean band = false;
        for (int i = 0; i<limite ; i++){
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
    public Juguete findAToy(Juguete[] toyInventory, int limite, String toyName) {
        for (int i = 0; i < limite; i++) {
            if (toyInventory[i].getToyName().equalsIgnoreCase(toyName)) {
                return toyInventory[i];
            }
        }
        return null;
    }
}
