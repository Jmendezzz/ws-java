package co.cue.edu.jugueteria.services;

import co.cue.edu.jugueteria.model.Juguete;

public interface Juguete_services {
    public void toysType(Juguete toyInventory[],int limit);
    public void totalToys (Juguete toyInventory[], int limite);
    public void totalToysValue (Juguete toyInventory[], int limite);
    public void minMaxToysType (Juguete toyInventory[], int limite);
    public void filterToys(Juguete toyInventory[], int limite, int price);

    public void toyProperties(Juguete toyInventory[], int limite, String toyName);
    public Juguete findAToy (Juguete toyInventory[], int limite, String toyName);


}
