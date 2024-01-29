package com.example.myfirstinterface;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CongesSAB {
    private StringProperty idCongesSAB;
    private StringProperty Id_empl;
    private StringProperty nomCongesSAB;
    private StringProperty prenomCongesSAB;
    private StringProperty dateCongesSAB;
    private StringProperty dateFinCongesSAB;


    public CongesSAB() {
        this.idCongesSAB = new SimpleStringProperty();
        this.nomCongesSAB = new SimpleStringProperty();
        this.prenomCongesSAB = new SimpleStringProperty();
        this.dateCongesSAB = new SimpleStringProperty();
        this.dateFinCongesSAB = new SimpleStringProperty();
        this.Id_empl = new SimpleStringProperty();
    }


    public String getIdCongesSAB() {
        return idCongesSAB.get();
    }

    public StringProperty idCongesSABProperty() {
        return idCongesSAB;
    }

    public void setIdCongesSAB(String idCongesSAB) {
        this.idCongesSAB.set(idCongesSAB);
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

    public String getNomCongesSAB() {
        return nomCongesSAB.get();
    }

    public StringProperty nomCongesSABProperty() {
        return nomCongesSAB;
    }

    public void setNomCongesSAB(String nomCongesSAB) {
        this.nomCongesSAB.set(nomCongesSAB);
    }

    public String getPrenomCongesSAB() {
        return prenomCongesSAB.get();
    }

    public StringProperty prenomCongesSABProperty() {
        return prenomCongesSAB;
    }

    public void setPrenomCongesSAB(String prenomCongesSAB) {
        this.prenomCongesSAB.set(prenomCongesSAB);
    }

    public String getDateCongesSAB() {
        return dateCongesSAB.get();
    }

    public StringProperty dateCongesSABProperty() {
        return dateCongesSAB;
    }

    public void setDateCongesSAB(String dateCongesSAB) {
        this.dateCongesSAB.set(dateCongesSAB);
    }

    public String getDateFinCongesSAB() {
        return dateFinCongesSAB.get();
    }

    public StringProperty dateFinCongesSABProperty() {
        return dateFinCongesSAB;
    }

    public void setDateFinCongesSAB(String dateFinCongesSAB) {
        this.dateFinCongesSAB.set(dateFinCongesSAB);
    }

}
