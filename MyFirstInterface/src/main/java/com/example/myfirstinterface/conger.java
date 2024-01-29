package com.example.myfirstinterface;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class conger {
    private StringProperty Id_conger;
    private StringProperty DateDebConger;
    private StringProperty Id_empl;
    private StringProperty Name_empl;
    private StringProperty Last_name_empl;
    private StringProperty Fonction_empl;
    private StringProperty PhoneNumber;
    private StringProperty DateRetour;
    private StringProperty Nbr_jour;
    private StringProperty Solde_conge;
    private StringProperty ExceptionDate;

    public conger() {
        this.Id_conger = new SimpleStringProperty();
        this.DateDebConger = new SimpleStringProperty();
        this.Id_empl = new SimpleStringProperty();
        this.Name_empl = new SimpleStringProperty();
        this.Fonction_empl = new SimpleStringProperty();
        this.PhoneNumber = new SimpleStringProperty();
        this.DateRetour = new SimpleStringProperty();
        this.Nbr_jour = new SimpleStringProperty();
        this.Solde_conge = new SimpleStringProperty();
        this.ExceptionDate = new SimpleStringProperty();
        this.Last_name_empl = new SimpleStringProperty();
    }

    public String getLast_name_empl() {
        return Last_name_empl.get();
    }

    public StringProperty last_name_emplProperty() {
        return Last_name_empl;
    }

    public void setLast_name_empl(String last_name_empl) {
        this.Last_name_empl.set(last_name_empl);
    }

    public String getId_conger() {
        return Id_conger.get();
    }

    public StringProperty id_congerProperty() {
        return Id_conger;
    }

    public void setId_conger(String id_conger) {
        this.Id_conger.set(id_conger);
    }

    public String getDateDebConger() {
        return DateDebConger.get();
    }

    public StringProperty dateDebCongerProperty() {
        return DateDebConger;
    }

    public void setDateDebConger(String dateDebConger) {
        this.DateDebConger.set(dateDebConger);
    }

    public String getId_empl() {
        return Id_empl.get();
    }

    public StringProperty id_emplProperty() {
        return Id_empl;
    }

    public void setId_empl(String id_empl) {
        this.Id_empl.set(id_empl);
    }

    public String getName_empl() {
        return Name_empl.get();
    }

    public StringProperty name_emplProperty() {
        return Name_empl;
    }

    public void setName_empl(String name_empl) {
        this.Name_empl.set(name_empl);
    }

    public String getFonction_empl() {
        return Fonction_empl.get();
    }

    public StringProperty fonction_emplProperty() {
        return Fonction_empl;
    }

    public void setFonction_empl(String fonction_empl) {
        this.Fonction_empl.set(fonction_empl);
    }

    public String getPhoneNumber() {
        return PhoneNumber.get();
    }

    public StringProperty phoneNumberProperty() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.PhoneNumber.set(phoneNumber);
    }

    public String getDateRetour() {
        return DateRetour.get();
    }

    public StringProperty dateRetourProperty() {
        return DateRetour;
    }

    public void setDateRetour(String dateRetour) {
        this.DateRetour.set(dateRetour);
    }

    public String getNbr_jour() {
        return Nbr_jour.get();
    }

    public StringProperty nbr_jourProperty() {
        return Nbr_jour;
    }

    public void setNbr_jour(String nbr_jour) {
        this.Nbr_jour.set(nbr_jour);
    }

    public String getSolde_conge() {
        return Solde_conge.get();
    }

    public StringProperty solde_congeProperty() {
        return Solde_conge;
    }

    public void setSolde_conge(String solde_conge) {
        this.Solde_conge.set(solde_conge);
    }

    public String getExceptionDate() {
        return ExceptionDate.get();
    }

    public StringProperty exceptionDateProperty() {
        return ExceptionDate;
    }

    public void setExceptionDate(String exceptionDate) {
        this.ExceptionDate.set(exceptionDate);
    }
}
