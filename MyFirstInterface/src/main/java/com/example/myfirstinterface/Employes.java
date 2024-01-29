package com.example.myfirstinterface;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Employes {
    private StringProperty ID_Employes;
    private StringProperty nomEmploye;
    private StringProperty fonctionEmploye;
    private StringProperty PrenomsEmp;
    private StringProperty numTelEmp;
    private StringProperty style;

    // Constructeur
    public Employes() {
        this.ID_Employes = new SimpleStringProperty();
        this.nomEmploye = new SimpleStringProperty();
        this.fonctionEmploye = new SimpleStringProperty();
        this.PrenomsEmp = new SimpleStringProperty();
        this.numTelEmp = new SimpleStringProperty();
        this.style = new SimpleStringProperty();
    }

    public String getFonctionEmploye() {
        return fonctionEmploye.get();
    }

    public StringProperty fonctionEmployeProperty() {
        return fonctionEmploye;
    }

    public void setFonctionEmploye(String fonctionEmploye) {
        this.fonctionEmploye.set(fonctionEmploye);
    }

    public String getPrenomsEmp() {
        return PrenomsEmp.get();
    }

    public StringProperty prenomsEmpProperty() {
        return PrenomsEmp;
    }

    public void setPrenomsEmp(String prenomsEmp) {
        this.PrenomsEmp.set(prenomsEmp);
    }

    // Getter et Setter pour ID_Employes
    public String getID_Employes() {
        return ID_Employes.get();
    }

    public StringProperty ID_EmployesProperty() {
        return ID_Employes;
    }

    public void setID_Employes(String ID_Employes) {
        this.ID_Employes.set(ID_Employes);
    }

    // Getter et Setter pour nomEmploye
    public String getNomEmploye() {
        return nomEmploye.get();
    }

    public StringProperty nomEmployeProperty() {
        return nomEmploye;
    }

    public void setNomEmploye(String nomEmploye) {
        this.nomEmploye.set(nomEmploye);
    }

    // Getter et Setter pour numTelEmp
    public String getNumTelEmp() {
        return numTelEmp.get();
    }

    public StringProperty numTelEmpProperty() {
        return numTelEmp;
    }

    public void setNumTelEmp(String numTelEmp) {
        this.numTelEmp.set(numTelEmp);
    }

    public StringProperty styleProperty() {
        return style;
    }

    public void setStyle(String style) {
        this.style.set(style);
    }

    public String getStyle() {
        return style.get();
    }
}








