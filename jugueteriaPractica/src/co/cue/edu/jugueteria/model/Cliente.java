package co.cue.edu.jugueteria.model;

public class Cliente extends Usuario {
    private String birthdayDate;
    private String emailAdress;

    public Cliente(String userName, String id, String phoneNumber, String adress, String birthdayDate,String emailAdress) {
        super(userName, id, phoneNumber, adress);
        this.birthdayDate = birthdayDate;
        this.emailAdress = emailAdress;
    }

    public String getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(String birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }
}
