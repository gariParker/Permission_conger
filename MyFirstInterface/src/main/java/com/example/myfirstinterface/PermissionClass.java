package com.example.myfirstinterface;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PermissionClass {
    private StringProperty Id_permis;
    private StringProperty DateDebPermis;
    private StringProperty Id_emplPermis;
    private StringProperty Name_emplPermis;
    private StringProperty Fonction_emplPermis;
    private StringProperty PhoneNumberPermis;
    private StringProperty DateRetourPermis;
    private StringProperty Nbr_jourPermis;
    private StringProperty SoldePermis;
    private StringProperty ObservationPermis;

    public PermissionClass() {
        this.Id_permis = new SimpleStringProperty();
        this.DateDebPermis = new SimpleStringProperty();
        this.Id_emplPermis = new SimpleStringProperty();
        this.Name_emplPermis = new SimpleStringProperty();
        this.Fonction_emplPermis = new SimpleStringProperty();
        this.PhoneNumberPermis = new SimpleStringProperty();
        this.DateRetourPermis = new SimpleStringProperty();
        this.Nbr_jourPermis = new SimpleStringProperty();
        this.SoldePermis = new SimpleStringProperty();
        this.ObservationPermis = new SimpleStringProperty();
    }

    public String getId_permis() {
        return Id_permis.get();
    }

    public StringProperty id_permisProperty() {
        return Id_permis;
    }

    public void setId_permis(String id_permis) {
        this.Id_permis.set(id_permis);
    }

    public String getDateDebPermis() {
        return DateDebPermis.get();
    }

    public StringProperty dateDebPermisProperty() {
        return DateDebPermis;
    }

    public void setDateDebPermis(String dateDebPermis) {
        this.DateDebPermis.set(dateDebPermis);
    }

    public String getId_emplPermis() {
        return Id_emplPermis.get();
    }

    public StringProperty id_emplPermisProperty() {
        return Id_emplPermis;
    }

    public void setId_emplPermis(String id_emplPermis) {
        this.Id_emplPermis.set(id_emplPermis);
    }

    public String getName_emplPermis() {
        return Name_emplPermis.get();
    }

    public StringProperty name_emplPermisProperty() {
        return Name_emplPermis;
    }

    public void setName_emplPermis(String name_emplPermis) {
        this.Name_emplPermis.set(name_emplPermis);
    }

    public String getFonction_emplPermis() {
        return Fonction_emplPermis.get();
    }

    public StringProperty fonction_emplPermisProperty() {
        return Fonction_emplPermis;
    }

    public void setFonction_emplPermis(String fonction_emplPermis) {
        this.Fonction_emplPermis.set(fonction_emplPermis);
    }

    public String getPhoneNumberPermis() {
        return PhoneNumberPermis.get();
    }

    public StringProperty phoneNumberPermisProperty() {
        return PhoneNumberPermis;
    }

    public void setPhoneNumberPermis(String phoneNumberPermis) {
        this.PhoneNumberPermis.set(phoneNumberPermis);
    }

    public String getDateRetourPermis() {
        return DateRetourPermis.get();
    }

    public StringProperty dateRetourPermisProperty() {
        return DateRetourPermis;
    }

    public void setDateRetourPermis(String dateRetourPermis) {
        this.DateRetourPermis.set(dateRetourPermis);
    }

    public String getNbr_jourPermis() {
        return Nbr_jourPermis.get();
    }

    public StringProperty nbr_jourPermisProperty() {
        return Nbr_jourPermis;
    }

    public void setNbr_jourPermis(String nbr_jourPermis) {
        this.Nbr_jourPermis.set(nbr_jourPermis);
    }

    public String getSoldePermis() {
        return SoldePermis.get();
    }

    public StringProperty soldePermisProperty() {
        return SoldePermis;
    }

    public void setSoldePermis(String soldePermis) {
        this.SoldePermis.set(soldePermis);
    }

    public String getObservationPermis() {
        return ObservationPermis.get();
    }

    public StringProperty observationPermisProperty() {
        return ObservationPermis;
    }

    public void setObservationPermis(String observationPermis) {
        this.ObservationPermis.set(observationPermis);
    }
}
