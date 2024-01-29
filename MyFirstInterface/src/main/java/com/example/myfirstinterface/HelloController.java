package com.example.myfirstinterface;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;


public class HelloController {
    //Les différentes panels
    @FXML
    private DatePicker DateCongeText;

    @FXML
    private DatePicker DateFinText;
    @FXML
    private Label PrenomTextLab;

    @FXML
    private TextField FontionText;

    @FXML
    private TextField IDText;

    @FXML
    private ImageView ImageEmployerConge;
    @FXML
    private ImageView ImageEmpl;

    @FXML
    private TextField NomText;

    @FXML
    private TextField PhoneText;
    @FXML
    private Pane menamena;
    @FXML
    private Pane paneconger;
    @FXML
    private Pane PanelCongerEmpl;
    @FXML
    private Pane PanelPourListerEmployeSabata;
    //Panel pour la permission

    @FXML
    private Pane PanePermissionListe;

    //panel pour le congé sabhatique
    @FXML
    private Pane PanelCongesSabhatique;
    @FXML
    private Pane PanelMavoValidationCsabata;
    @FXML
    private Label NbrJour;
    //Boutons
    @FXML
    private Button BoutonDeconnecter;
    @FXML
    private Button BtnValiderConger;
    //Tableau pour les employés qui récupèrent les congés sabhatique
    @FXML
    private TableView<CongesSAB> TableCongesSabhatique;
    @FXML
    private ImageView imageSabata1;
    @FXML
    private ImageView imageSabata;
    @FXML
    private TableColumn<CongesSAB, String> ColonneIDCongesSAB;
    @FXML
    private TableColumn<CongesSAB, String> ColonneNOMcongesSAB;
    @FXML
    private TableColumn<CongesSAB, String> ColonnePRENOMcongesSAB;
    @FXML
    private TableColumn<CongesSAB, String> ColonneDATEcongesSAB;
    @FXML
    private TableColumn<CongesSAB, String> ColoneeDATEFINcongesSAB;

    @FXML
    private TextField TeFieldNomEmpCsabata;

    @FXML
    private TextField TextFieldPrenomCsabata;
    @FXML
    private ImageView ImageEmpCongerSabata;
    @FXML
    private DatePicker DateDebCsabata;

    @FXML
    private DatePicker DateFINCsabata;
    @FXML
    private ImageView ImagePermis;

    //Tableau pour lister les employees existants
    @FXML
    private TableView<Employes> TableListEmployes;

    @FXML
    private TableColumn<Employes, String> ColFONCTIONemployes;

    @FXML
    private TableColumn<Employes, String> ColIDEmployes;

    @FXML
    private TableColumn<Employes, String> ColNOMemployes;

    @FXML
    private TableColumn<Employes, String> ColPRENOMemployes;

    @FXML
    private TableColumn<Employes, String> ColTELEPHONEemployes;
    //Tableau pour lister les employes qui ont le congés sabhatique
    @FXML
    private TableView<Employes> TableauEmpMananaCongesSabathique;
    @FXML
    private TableColumn<Employes, String> ColTELsabata;
    @FXML
    private TableColumn<Employes, String> ColFONCTIONsabata;
    @FXML
    private TableColumn<Employes, String> ColPRENOMSsabata;
    @FXML
    private TableColumn<Employes, String> ColNOMsabata;
    @FXML
    private TableColumn<Employes, String> ColIDsabata;
    @FXML
    private ImageView PhotoEmpSabata;

    @FXML
    private TextField barreDeRecherche;
    @FXML
    private DatePicker rechercheParDateDebut;
    @FXML
    private Label motChercher;
    @FXML
    private Button bokotraRefresh;
    @FXML
    private Button BokotraAnnuler;
    @FXML
    private TextField rechercheEmpSabata;
    LocalDate DateRetour;
    //Déclaration du tableau concernant la permission
    @FXML
    private TableView<PermissionClass> TableViewPermission;
    @FXML
    private TableColumn<PermissionClass, String> IdPermisTab;
    @FXML
    private TableColumn<PermissionClass, String> DatePermisTab;
    @FXML
    private TableColumn<PermissionClass, String> NomPermisTab;
    @FXML
    private TableColumn<PermissionClass, String> FonctPermisTab;
    @FXML
    private TableColumn<PermissionClass, String> PhonePermisTab;
    @FXML
    private TableColumn<PermissionClass, String> DateRetourPermisTab;
    @FXML
    private TableColumn<PermissionClass, String> NbrJourPermisTab;
    @FXML
    private TableColumn<PermissionClass, String> SoldeRestePermisTab;
    @FXML
    private TableColumn<PermissionClass, String> ObservePermisTab;

    //Déclaration du tableau concernant le congé
    @FXML
    private TableView<conger> TableViewConges;
    @FXML
    private TableColumn<conger, String> IdCongeTab;
    @FXML
    private TableColumn<conger, String> DateDebTab;
    @FXML
    private TableColumn<conger, String> NomCongeTab;
    @FXML
    private TableColumn<conger, String> PrenomCongeTab;
    @FXML
    private TableColumn<conger, String> FonctionTab;
    @FXML
    private TableColumn<conger, String> PhoneTab;
    @FXML
    private TableColumn<conger, String> DateRetourTab;
    @FXML
    private TableColumn<conger, String> NbrJourTab;
    @FXML
    private TableColumn<conger, String> SoldeTab;
    @FXML
    private TableColumn<conger, String> ExeptionTab;
    @FXML
    private ImageView ImageSimpleConge;

    //Combombox pour les congés
    @FXML
    private ComboBox<String> ExceptionCongerAutoriser;
    @FXML
    private TextField ExceptionAutre;
    @FXML
    private Button BtnDemiJour;

    @FXML
    private TextField RechercheChaqueEmployes;
    boolean IsEdit=false;
    boolean IsEditPermis=false;
    boolean IsPermision=false;
    @FXML
    private Label labelquiVarie;

    @FXML
    private Label labelquiVariee;

//    @FXML
//    private Label labResultat;
    @FXML
    private TextField RechercheCongerText;
    @FXML
    private TextField TextRechercherPermis;
    @FXML
    private Button bokotraImprimerCsabhatique;
    @FXML
    private Button bouttonApropos;


    Connection con;
    PreparedStatement pst;
    int myIndex;
    int id;


    @FXML
    public void initialize() {
        Connect();
        table();
        TableauConger();
        TableauPermission();
        UpdateNewYears();
        SelectionComboxAutre();
        ExceptionAutre.setDisable(true);
        menamena.setVisible(false);
        paneconger.setVisible(false);
        PanelCongerEmpl.setVisible(false);

        PanelCongesSabhatique.setVisible(false);
        PanelPourListerEmployeSabata.setVisible(false);
        PanelMavoValidationCsabata.setVisible(false);
        rechercheParDateDebut.setVisible(false);
        PanePermissionListe.setVisible(false);
//        ObservableList<CongesSAB> items = TableCongesSabhatique.getItems();
//        int nombreElements = items.size();
//        labResultat.setText("N " + nombreElements);
        EcouteurSelection();
        BtnDemiJour.setDisable(true);/////////////
    }
    void UpdateNewYears()
    {
        int anneePrecedente = getDatePrecedent();
        Connect();
        try {
            // Obtenez l'année actuelle
            int anneeActuelle = LocalDate.now().getYear();

            // Vérifiez si l'année a changé
            if (anneeActuelle != anneePrecedente) {
                // Effectuez la mise à jour
                String updateQuery = "UPDATE Conger SET Expiration = 'Expirer' WHERE Expiration = 'En cours'";
                PreparedStatement preparedStatement = con.prepareStatement(updateQuery);
                preparedStatement.executeUpdate();

                String updateCmd = "UPDATE permission SET Expiration = 'Expirer' WHERE Expiration = 'En cours'";
                PreparedStatement preparStatement = con.prepareStatement(updateCmd);
                preparStatement.executeUpdate();

                // Mettez à jour la valeur de l'année précédente
                //anneePrecedente = anneeActuelle;
                String updateCommand = "UPDATE date_precedent SET DatePrecedent = ? WHERE Id_DatePrecede = 1";
                PreparedStatement preparedStmt = con.prepareStatement(updateCommand);
                preparedStmt.setInt(1, anneeActuelle);
                preparedStmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public int getDatePrecedent() {
        int DatePrecede = 0;
        Connect();

        try  {
            String query = "SELECT DatePrecedent FROM date_precedent";
            PreparedStatement preparedStatement = con.prepareStatement(query);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    DatePrecede = resultSet.getInt("DatePrecedent");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return DatePrecede;
    }

    private void EcouteurSelection() {
        // Créez une propriété booléenne pour suivre si quelque chose est sélectionné dans TableView
        SimpleBooleanProperty itemSelected = new SimpleBooleanProperty(false);

        // Ajoutez un écouteur pour la sélection de la TableView
        TableCongesSabhatique.getSelectionModel().getSelectedItems().addListener(new ListChangeListener<CongesSAB>() {
            @Override
            public void onChanged(Change<? extends CongesSAB> c) {
                // Activez le bouton si quelque chose est sélectionné, sinon désactivez-le
                itemSelected.set(!TableCongesSabhatique.getSelectionModel().isEmpty());
            }
        });

        // Liez la désactivation/activation du bouton à la propriété itemSelected
        BokotraAnnuler.disableProperty().bind(itemSelected.not());
    }
    //Fonction pour connecter au base de donnée
    public void Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/basegrh", "root", "");
        } catch (ClassNotFoundException ec) {

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Fonction pour afficher tous les employées existants dans la BDD, dans tableView
    public void table() {
        Connect();
        if (con == null) {
            System.out.println("La connexion à la base de données a échoué.");
            // Gérer l'erreur de connexion
            return;
        }

        ObservableList<Employes> Employees = FXCollections.observableArrayList();
        try {
            PreparedStatement pst = con.prepareStatement("SELECT `Id_empl`, `Name_empl`, `FstName_empl`, `Function_second`, `NumPhone_empl` FROM `employees`");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Employes st = new Employes();
                st.setID_Employes(rs.getString("Id_empl"));
                st.setNomEmploye(rs.getString("Name_empl"));
                st.setPrenomsEmp(rs.getString("FstName_empl"));
                st.setFonctionEmploye(rs.getString("Function_second"));
                st.setNumTelEmp(rs.getString("NumPhone_empl"));
                Employees.add(st);
            }
            TableListEmployes.setItems(Employees);
            ColIDEmployes.setCellValueFactory(f -> f.getValue().ID_EmployesProperty());
            ColNOMemployes.setCellValueFactory(f -> f.getValue().nomEmployeProperty());
            ColPRENOMemployes.setCellValueFactory(f -> f.getValue().prenomsEmpProperty());
            ColFONCTIONemployes.setCellValueFactory(f -> f.getValue().fonctionEmployeProperty());
            ColTELEPHONEemployes.setCellValueFactory(f -> f.getValue().numTelEmpProperty());
        } catch (SQLException eex) {
            Logger.getLogger(HelloController.class.getName()).log(Level.SEVERE, null, eex);
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(HelloController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        TableListEmployes.setRowFactory(tv -> {
            TableRow<Employes> myRow = new TableRow<>();
            myRow.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
                    myIndex = TableListEmployes.getSelectionModel().getSelectedIndex();
                    id = Integer.parseInt(TableListEmployes.getItems().get(myIndex).getID_Employes());
                    IDText.setText(String.valueOf(id));
                    // Récupérez l'employé sélectionné
                    Employes selectedEmployee = TableListEmployes.getItems().get(myIndex);

                    NomText.setText(TableListEmployes.getItems().get(myIndex).getNomEmploye());
                    PrenomTextLab.setText(TableListEmployes.getItems().get(myIndex).getPrenomsEmp());
                    FontionText.setText(TableListEmployes.getItems().get(myIndex).getFonctionEmploye());
                    PhoneText.setText(TableListEmployes.getItems().get(myIndex).getNumTelEmp());

                    // Chargez et affichez l'image de l'employé depuis la base de données
                    try {
                        InputStream imageStream = getImageFromDatabase(selectedEmployee.getID_Employes());
                        if (imageStream != null) {
                            Image employeeImage = new Image(imageStream);
                            ImageEmpl.setImage(employeeImage);
                            ImageEmployerConge.setImage(employeeImage);
                        } else {
                            // Si l'image n'est pas disponible, effacez l'ImageView
                            ImageEmployerConge.setImage(null);
                        }
                    } catch (Exception ex) {
                        // Gérez les exceptions ici
                    }

                }
            });
            return myRow;
        });
    }

    //Fonction pour afficher les employes qui ont obtenus le congé sabhatique
    public void TableSabhatique() {
        Connect();
        if (con == null) {
            System.out.println("La connexion à la base de données a échoué.");
            // Gérer l'erreur de connexion
            return;
        }

        ObservableList<Employes> Employees = FXCollections.observableArrayList();
        try {
            PreparedStatement pst = con.prepareStatement("SELECT `Id_empl`, `Name_empl`, `FstName_empl`, `Function_second`, `NumPhone_empl`, `Date_insert` FROM `employees`");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Employes st = new Employes();
                st.setID_Employes(rs.getString("Id_empl"));
                st.setNomEmploye(rs.getString("Name_empl"));
                st.setPrenomsEmp(rs.getString("FstName_empl"));
                st.setFonctionEmploye(rs.getString("Function_second"));
                st.setNumTelEmp(rs.getString("NumPhone_empl"));

                // Obtenez la date d'embauche de l'employé
                LocalDate dateEmbauche = rs.getDate("Date_insert").toLocalDate();

                // Calculer l'ancienneté en soustrayant l'année d'embauche de l'année actuelle
                int anciennete = LocalDate.now().getYear() - dateEmbauche.getYear();

                // Filtrer les employés ayant une ancienneté de 10 ans ou plus
                if (anciennete >= 10) {
                    Employees.add(st);
                }
            }
            TableauEmpMananaCongesSabathique.setItems(Employees);
            ColIDsabata.setCellValueFactory(f -> f.getValue().ID_EmployesProperty());
            ColNOMsabata.setCellValueFactory(f -> f.getValue().nomEmployeProperty());
            ColPRENOMSsabata.setCellValueFactory(f -> f.getValue().prenomsEmpProperty());
            ColFONCTIONsabata.setCellValueFactory(f -> f.getValue().fonctionEmployeProperty());
            ColTELsabata.setCellValueFactory(f -> f.getValue().numTelEmpProperty());
        } catch (SQLException eex) {
            Logger.getLogger(HelloController.class.getName()).log(Level.SEVERE, null, eex);
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(HelloController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        TableauEmpMananaCongesSabathique.setRowFactory(tv -> {
            TableRow<Employes> myRow = new TableRow<>();
            myRow.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
                    myIndex = TableauEmpMananaCongesSabathique.getSelectionModel().getSelectedIndex();
                    id = Integer.parseInt(TableauEmpMananaCongesSabathique.getItems().get(myIndex).getID_Employes());
                    IDText.setText(String.valueOf(id));

                    Employes selectedEmployee = TableauEmpMananaCongesSabathique.getItems().get(myIndex);

                    TeFieldNomEmpCsabata.setText(TableauEmpMananaCongesSabathique.getItems().get(myIndex).getNomEmploye());
                    TextFieldPrenomCsabata.setText(TableauEmpMananaCongesSabathique.getItems().get(myIndex).getPrenomsEmp());

                    try {
                        InputStream imageStream = getImageFromDatabase(selectedEmployee.getID_Employes());
                        if (imageStream != null) {
                            Image employeeImage = new Image(imageStream);
                            PhotoEmpSabata.setImage(employeeImage);
                            ImageEmpCongerSabata.setImage(employeeImage);
                        } else {
                            ImageEmpCongerSabata.setImage(null);
                        }
                    } catch (Exception ex) {
                        // Gérez les exceptions ici
                    }

                }
            });
            return myRow;
        });
    }

    ///Fonction pour afficher les congés sabhatique en cours
    public void AfficherCongerSabataEnCours() {
        Connect();
        if (con == null) {
            System.out.println("La connexion à la base de données a échoué.");
            // Gérer l'erreur de connexion
            return;
        }

        ObservableList<CongesSAB> congesSABSs = FXCollections.observableArrayList();
        PreparedStatement pst = null;

        try {
            // Préparer la requête SQL pour récupérer les congés sabbatiques en cours
            pst = con.prepareStatement("SELECT `ID_congesab`,Id_empl_tire, `Nom_empSab`, `Prenom_empSab`, `Datedeb_empSab`, `DateFin_empSab` FROM `conges_sabhatique`");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                CongesSAB st = new CongesSAB();
                st.setIdCongesSAB(rs.getString("ID_congesab"));
                st.setId_empl(rs.getString("Id_empl_tire"));
                st.setNomCongesSAB(rs.getString("Nom_empSab"));
                st.setPrenomCongesSAB(rs.getString("Prenom_empSab"));
                st.setDateCongesSAB(rs.getString("Datedeb_empSab"));
                st.setDateFinCongesSAB(rs.getString("DateFin_empSab"));
                congesSABSs.add(st);
            }

            // Définir les données dans la TableView
            TableCongesSabhatique.setItems(congesSABSs);

            // Configurer les cellules des colonnes avec les propriétés correspondantes de CongesSAB
            ColonneIDCongesSAB.setCellValueFactory(f -> f.getValue().idCongesSABProperty());
            ColonneNOMcongesSAB.setCellValueFactory(f -> f.getValue().nomCongesSABProperty());
            ColonnePRENOMcongesSAB.setCellValueFactory(f -> f.getValue().prenomCongesSABProperty());
            ColonneDATEcongesSAB.setCellValueFactory(f -> f.getValue().dateCongesSABProperty());
            ColoneeDATEFINcongesSAB.setCellValueFactory(f -> f.getValue().dateFinCongesSABProperty());

            //Test de coloration
            // Colorer en rouge les lignes de TableCongesSabhatique si le nom existe dans une autre TableView
            TableauEmpMananaCongesSabathique.getItems().forEach(item -> {
                if (congesSABSs.stream().anyMatch(congesSAB -> congesSAB.getNomCongesSAB().equals(item.getNomEmploye()))) {
                    // Appliquer un style CSS pour colorer la ligne en rouge
                    System.out.println("Nom correspondant trouvé : " + item.getNomEmploye());
                    item.setStyle("-fx-background-color: red;");
                }
            });
        } catch (SQLException eex) {
            Logger.getLogger(HelloController.class.getName()).log(Level.SEVERE, null, eex);
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(HelloController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        // Configurer le comportement lors du clic sur une ligne de la TableView
        TableCongesSabhatique.setRowFactory(tv -> {
            TableRow<CongesSAB> myRow = new TableRow<>();
            myRow.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
                    myIndex = TableCongesSabhatique.getSelectionModel().getSelectedIndex();
                    id = Integer.parseInt(TableCongesSabhatique.getItems().get(myIndex).getIdCongesSAB());
                    IDText.setText(String.valueOf(id));
                    // Récupérez l'employé sélectionné
                    CongesSAB selectedEmployee = TableCongesSabhatique.getItems().get(myIndex);

                    // Chargez et affichez l'image de l'employé depuis la base de données
                    try {
                        InputStream imageStream = getImageFromDatabase(selectedEmployee.getId_empl());
                        if (imageStream != null) {
                            Image employeeImage = new Image(imageStream);
                            ImageEmpl.setImage(employeeImage);
                            imageSabata.setImage(employeeImage);
                            //imageSabata1.setImage(employeeImage);
                        } else {
                            // Si l'image n'est pas disponible, effacez l'ImageView
                            imageSabata.setImage(null);
                        }
                    } catch (Exception ex) {
                        // Gérez les exceptions ici
                    }
                }
            });
            return myRow;
        });
    }
    public void TableauConger(){
        Connect();
        if (con == null) {
            System.out.println("La connexion à la base de données a échoué.");
            // Gérer l'erreur de connexion
            return;
        }

        ObservableList<conger> CongeeEmpl = FXCollections.observableArrayList();
        try{
            PreparedStatement pst = con.prepareStatement(" select * from conger");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                conger st = new conger();
                st.setId_conger(rs.getString("Id_conge"));
                st.setDateDebConger(rs.getString("DateDeb"));
                st.setId_empl(rs.getString("Id_empl"));
                st.setName_empl(rs.getString("Name_empl"));
                st.setLast_name_empl(rs.getString("Prenom_empf"));
                st.setFonction_empl(rs.getString("Function_second"));
                st.setPhoneNumber(rs.getString("NumPhone_empl"));
                st.setDateRetour(rs.getString("DateRetour"));
                st.setNbr_jour(rs.getString("Nbr_jour"));
                st.setSolde_conge(rs.getString("Solde_conge"));
                st.setExceptionDate(rs.getString("ExceptionDate"));
                CongeeEmpl.add(st);
            }
            TableViewConges.setItems(CongeeEmpl);
            IdCongeTab.setCellValueFactory(f->f.getValue().id_congerProperty());
            DateDebTab.setCellValueFactory(f->f.getValue().dateDebCongerProperty());
            NomCongeTab.setCellValueFactory(f->f.getValue().name_emplProperty());
            PrenomCongeTab.setCellValueFactory(f->f.getValue().last_name_emplProperty());
            FonctionTab.setCellValueFactory(f->f.getValue().fonction_emplProperty());
            PhoneTab.setCellValueFactory(f->f.getValue().phoneNumberProperty());
            DateRetourTab.setCellValueFactory(f->f.getValue().dateRetourProperty());
            NbrJourTab.setCellValueFactory(f->f.getValue().nbr_jourProperty());
            SoldeTab.setCellValueFactory(f->f.getValue().solde_congeProperty());
            ExeptionTab.setCellValueFactory(f->f.getValue().exceptionDateProperty());
        } catch (SQLException eex){
            Logger.getLogger(HelloController.class.getName()).log(Level.SEVERE, null, eex);
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(HelloController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        TableViewConges.setRowFactory(tv -> {
            TableRow<conger> myRow = new TableRow<>();
            myRow.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
                    myIndex = TableViewConges.getSelectionModel().getSelectedIndex();
                    id = Integer.parseInt(TableViewConges.getItems().get(myIndex).getId_conger());
                    IDText.setText(String.valueOf(TableViewConges.getItems().get(myIndex).getId_empl()));
                    // Récupérez l'employé sélectionné
                    conger selectedEmployee = TableViewConges.getItems().get(myIndex);

                    NomText.setText(TableViewConges.getItems().get(myIndex).getName_empl());
                    PrenomTextLab.setText(TableViewConges.getItems().get(myIndex).getName_empl());
                    PrenomCongeTab.setText(TableViewConges.getItems().get(myIndex).getLast_name_empl());
                    LocalDate DateDeb= LocalDate.parse(TableViewConges.getItems().get(myIndex).getDateDebConger());
                    DateRetour = LocalDate.parse(TableViewConges.getItems().get(myIndex).getDateRetour());
                    DateCongeText.setValue(DateDeb);
                    DateFinText.setValue(DateRetour);
                    FontionText.setText(TableViewConges.getItems().get(myIndex).getFonction_empl());
                    PhoneText.setText(TableViewConges.getItems().get(myIndex).getPhoneNumber());
                    NbrJour.setText(TableViewConges.getItems().get(myIndex).getNbr_jour());

                    // Chargez et affichez l'image de l'employé depuis la base de données
                    try {
                        InputStream imageStream = getImageFromDatabase(selectedEmployee.getId_empl());
                        if (imageStream != null) {
                            Image employeeImage = new Image(imageStream);
                            ImageEmpl.setImage(employeeImage);
                            ImageSimpleConge.setImage(employeeImage);
                            ImageEmployerConge.setImage(employeeImage);
                        } else {
                            // Si l'image n'est pas disponible, effacez l'ImageView
                            ImageEmployerConge.setImage(null);
                        }
                    } catch (Exception ex) {
                        // Gérez les exceptions ici
                    }
                }
            });
            return myRow;
        });
    }
    public void TableauPermission(){
        Connect();
        if (con == null) {
            System.out.println("La connexion à la base de données a échoué.");
            // Gérer l'erreur de connexion
            return;
        }

        ObservableList<PermissionClass> PermissionEmpl = FXCollections.observableArrayList();
        try{
            PreparedStatement pst = con.prepareStatement(" select * from permission");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                PermissionClass st = new PermissionClass();
                st.setId_permis(rs.getString("Id_permis"));
                st.setDateDebPermis(rs.getString("Date_permis"));
                st.setId_emplPermis(rs.getString("Id_empl"));
                st.setName_emplPermis(rs.getString("Name_empl"));
                st.setFonction_emplPermis(rs.getString("Function_second"));
                st.setPhoneNumberPermis(rs.getString("NumPhone_empl"));
                st.setDateRetourPermis(rs.getString("DateRetour"));
                st.setNbr_jourPermis(rs.getString("NbrJour_permis"));
                st.setSoldePermis(rs.getString("SoldeReste_permis"));
                st.setObservationPermis(rs.getString("Observation"));
                PermissionEmpl.add(st);
            }
            TableViewPermission.setItems(PermissionEmpl);
            IdPermisTab.setCellValueFactory(f->f.getValue().id_permisProperty());
            DatePermisTab.setCellValueFactory(f->f.getValue().dateDebPermisProperty());
            NomPermisTab.setCellValueFactory(f->f.getValue().name_emplPermisProperty());
            FonctPermisTab.setCellValueFactory(f->f.getValue().fonction_emplPermisProperty());
            PhonePermisTab.setCellValueFactory(f->f.getValue().phoneNumberPermisProperty());
            DateRetourPermisTab.setCellValueFactory(f->f.getValue().dateRetourPermisProperty());
            NbrJourPermisTab.setCellValueFactory(f->f.getValue().nbr_jourPermisProperty());
            SoldeRestePermisTab.setCellValueFactory(f->f.getValue().soldePermisProperty());
            ObservePermisTab.setCellValueFactory(f->f.getValue().observationPermisProperty());
        } catch (SQLException eex){
            Logger.getLogger(HelloController.class.getName()).log(Level.SEVERE, null, eex);
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(HelloController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        TableViewPermission.setRowFactory(tv -> {
            TableRow<PermissionClass> myRow = new TableRow<>();
            myRow.setOnMouseClicked(event -> {
                if (event.getClickCount() == 1 && (!myRow.isEmpty())) {
                    myIndex = TableViewPermission.getSelectionModel().getSelectedIndex();
                    id = Integer.parseInt(TableViewPermission.getItems().get(myIndex).getId_permis());
                    IDText.setText(String.valueOf(TableViewPermission.getItems().get(myIndex).getId_emplPermis()));
                    // Récupérez l'employé sélectionné
                    PermissionClass selectedEmployee = TableViewPermission.getItems().get(myIndex);

                    NomText.setText(TableViewPermission.getItems().get(myIndex).getName_emplPermis());
                    PrenomTextLab.setText(TableViewPermission.getItems().get(myIndex).getName_emplPermis());
                    LocalDate DateDeb= LocalDate.parse(TableViewPermission.getItems().get(myIndex).getDateDebPermis());
                    DateRetour = LocalDate.parse(TableViewPermission.getItems().get(myIndex).getDateRetourPermis());
                    DateCongeText.setValue(DateDeb);
                    DateFinText.setValue(DateRetour);
                    FontionText.setText(TableViewPermission.getItems().get(myIndex).getFonction_emplPermis());
                    PhoneText.setText(TableViewPermission.getItems().get(myIndex).getPhoneNumberPermis());
                    NbrJour.setText(TableViewPermission.getItems().get(myIndex).getNbr_jourPermis());

                    // Chargez et affichez l'image de l'employé depuis la base de données
                    try {
                        InputStream imageStream = getImageFromDatabase(selectedEmployee.getId_emplPermis());
                        if (imageStream != null) {
                            Image employeeImage = new Image(imageStream);
                            ImageEmpl.setImage(employeeImage);
                            ImageEmployerConge.setImage(employeeImage);
                            ImagePermis.setImage(employeeImage);
                        } else {
                            // Si l'image n'est pas disponible, effacez l'ImageView
                            ImageEmployerConge.setImage(null);
                        }
                    } catch (Exception ex) {
                        // Gérez les exceptions ici
                    }

                }
            });
            return myRow;
        });
    }

    // Fonction de recherche Employees principale
    public void recherchePrincipaleEmployes(String searchText) {
        ObservableList<Employes> filteredEmployees = FXCollections.observableArrayList();

        if (searchText.isEmpty()) {
            // Si le champ de recherche est vide, affichez tous les employés
            table();
            return;
        }

        for (Employes employee : TableListEmployes.getItems()) {
            if (employee.getID_Employes().toLowerCase().contains(searchText.toLowerCase()) || employee.getNomEmploye().toLowerCase().contains(searchText.toLowerCase()) ||
                    employee.getPrenomsEmp().toLowerCase().contains(searchText.toLowerCase()) ||
                    employee.getFonctionEmploye().toLowerCase().contains(searchText.toLowerCase()) ||
                    employee.getNumTelEmp().toLowerCase().contains(searchText.toLowerCase())) {
                filteredEmployees.add(employee);
            }
        }
        TableListEmployes.setItems(filteredEmployees);
    }

    // Fonction de recherche
    public void rechercheEmployes(String searchText) {
        ObservableList<Employes> filteredEmployees = FXCollections.observableArrayList();

        if (searchText.isEmpty()) {
            // Si le champ de recherche est vide, affichez tous les employés
            TableSabhatique();
            return;
        }

        for (Employes employee : TableauEmpMananaCongesSabathique.getItems()) {
            if (employee.getNomEmploye().toLowerCase().contains(searchText.toLowerCase()) ||
                    employee.getPrenomsEmp().toLowerCase().contains(searchText.toLowerCase()) ||
                    employee.getFonctionEmploye().toLowerCase().contains(searchText.toLowerCase()) ||
                    employee.getNumTelEmp().toLowerCase().contains(searchText.toLowerCase())) {
                filteredEmployees.add(employee);
            }
        }
        TableauEmpMananaCongesSabathique.setItems(filteredEmployees);
    }
    // Fonction de recherche 2
    public void rechercheEmplCongesSabataEnCours(String searchTextes) {
        ObservableList<CongesSAB> filteredEmployeesConges = FXCollections.observableArrayList();

        if (searchTextes.isEmpty()) {
            // Si le champ de recherche est vide, affichez tous les employés
            AfficherCongerSabataEnCours();
            return;
        }

        for (CongesSAB congesSabh : TableCongesSabhatique.getItems()) {
            if (congesSabh.getNomCongesSAB().toLowerCase().contains(searchTextes.toLowerCase()) ||
                    congesSabh.getPrenomCongesSAB().toLowerCase().contains(searchTextes.toLowerCase())) {
                filteredEmployeesConges.add(congesSabh);
            }
        }
        TableCongesSabhatique.setItems(filteredEmployeesConges);
    }

    private InputStream getImageFromDatabase(String employeeID) throws SQLException {
        String query = "SELECT Image_empl FROM employees WHERE Id_empl = ?";

        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, employeeID);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getBinaryStream("Image_Empl");
            }
        } catch (SQLException ex) {
            // Gérez les exceptions ici
            throw ex;
        }
        return null; // Retourne null si aucune image n'est trouvée
    }
    private InputStream getImageFromDatabasee(String employeeID) throws SQLException {
        String query = "SELECT Image_empl FROM employees WHERE Id_empl = ?";

        try (PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, employeeID);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getBinaryStream("Image_Empl");
            }
        } catch (SQLException ex) {
            // Gérez les exceptions ici
            throw ex;
        }

        return null; // Retourne null si aucune image n'est trouvée
    }

    //Bouton pour liste des employees
    @FXML
    protected void btnActionListEmployes() {
        Connect();
        table();

        RechercheChaqueEmployes.textProperty().addListener((observable, oldValue, newValue) -> {
            recherchePrincipaleEmployes(newValue);
        });

        paneconger.setVisible(false);
        PanelCongerEmpl.setVisible(false);
        PanelPourListerEmployeSabata.setVisible(false);
        PanelCongesSabhatique.setVisible(false);
        PanelMavoValidationCsabata.setVisible(false);
        menamena.setVisible(true);
        rechercheParDateDebut.setVisible(false);
        PanePermissionListe.setVisible(false);
        BtnDemiJour.setDisable(true);//////////////// CORRECTION 13
    }

    //bouton pour le panel conger
    @FXML
    protected void btnActionConger() {
        menamena.setVisible(true);
        paneconger.setVisible(true);
        PanelPourListerEmployeSabata.setVisible(false);
        PanelCongesSabhatique.setVisible(false);
        PanelCongerEmpl.setVisible(false);
        PanelMavoValidationCsabata.setVisible(false);
        PanePermissionListe.setVisible(false);
        rechercheParDateDebut.setVisible(false);
        BtnDemiJour.setDisable(true);//////CORRECTION 12
    }

    @FXML
    protected void btnActionPermissions() {
       menamena.setVisible(true);
       paneconger.setVisible(true);
       PanelCongerEmpl.setVisible(true);
       PanePermissionListe.setVisible(true);
       PanelCongesSabhatique.setVisible(false);
       PanelMavoValidationCsabata.setVisible(false);
       PanelPourListerEmployeSabata.setVisible(false);
       rechercheParDateDebut.setVisible(false);
       BtnDemiJour.setDisable(false);//////CORRECTION 11
    }

    //Bouton pour déconnecter
    @FXML
    void BtnActionDeconnecter(ActionEvent event) throws IOException {
        // Afficher la boîte de dialogue de confirmation
        boolean confirmation = afficherConfirmationBox();

        if (confirmation) {
            // L'utilisateur a confirmé la déconnexion
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("FormLogin.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Administrateur");
            stage.setScene(new Scene(root));

            // Fermer la fenêtre actuelle (Form2)
            Stage currentStage = (Stage) BoutonDeconnecter.getScene().getWindow();
            currentStage.close();

            // Afficher la nouvelle forme (FormLogin.fxml)
            stage.show();
        } else {
            // L'utilisateur a annulé la déconnexion
        }
    }
    // Méthode pour afficher la boîte de dialogue de confirmation et retourner true si l'utilisateur confirme, sinon false
    private boolean afficherConfirmationBox() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Voulez-vous vraiment vous déconnecter ?");

        ButtonType okButton = new ButtonType("Oui", ButtonBar.ButtonData.YES);
        ButtonType cancelButton = new ButtonType("Non", ButtonBar.ButtonData.NO);

        alert.getButtonTypes().setAll(okButton, cancelButton);

        Optional<ButtonType> result = alert.showAndWait();

        return result.isPresent() && result.get() == okButton;
    }

    @FXML
    void BtnValiderConger_click(ActionEvent event) {/////correction 5
        if (NomText.getText().isEmpty() || IDText.getText().isEmpty()
                || PhoneText.getText().isEmpty() ||
                DateCongeText.getValue()==null || DateFinText.getValue()==null) {
            // Si le champ de recherche est vide, afficher un message d'alerte
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("CASE VIDE");
            alert.setHeaderText("Il y a de champ vide");
            alert.setContentText("Veuillez bien remplir les champs.");
            alert.showAndWait();
            return;
        }
        Connect();
        int Id = Integer.parseInt(IDText.getText());
        LocalDate dateDebConges = DateCongeText.getValue();
        String NomEmp = NomText.getText();
        String PrenomEmpf = PrenomTextLab.getText();
        String Fonction = FontionText.getText();
        String Numero = PhoneText.getText();
        LocalDate DateFin = DateFinText.getValue();
        Double nombreJ = Double.parseDouble(NbrJour.getText());
        String AutreExcepte=ExceptionAutre.getText();
        if(nombreJ<0)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ERREUR");
            alert.setHeaderText("Le nombre du jours ne doit pas être négatif");
            alert.setContentText("Dépasse la limite");
            alert.showAndWait();
            return;
        }
        double soldeReste=getSoldeCongeRestant(Id);
        double SoldePermisRst=getSoldePermissionRestant(Id);
        Date dateRetour0 = getDateRetour(id);

        if (isDateRetourNull==false && "Courant".equals(ExceptionCongerAutoriser.getValue()) && IsPermision==false && IsEditPermis==false && IsEdit==false) {
            LocalDate dateRetour = dateRetour0.toLocalDate();
            //LocalDate dateRetour = getDateRetour(id).toLocalDate();
            LocalDate dateRetourPlus30Jours = dateRetour.plusDays(30);
            long daysDifference = ChronoUnit.DAYS.between(dateRetourPlus30Jours, dateDebConges);
            if (daysDifference <= 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("ERREUR");
                alert.setHeaderText("Chèr(e) "+NomEmp+", \nVotre prochain congé doit être après le " +dateRetourPlus30Jours+".");
                alert.setContentText("Erreur");
                alert.showAndWait();
                return;
            }
        }

        // Date DateRetourPermission = getDateRetourPermis(id);
//
//        if (isDateRetourPermisNull==false && IsPermision==true && IsEditPermis==false) {
//            LocalDate dateRetour = DateRetourPermission.toLocalDate();
//            LocalDate dateRetourPlus10Jours = dateRetour.plusDays(10);
//            long daysDifference = ChronoUnit.DAYS.between(dateRetourPlus10Jours, dateDebConges);
//            if (daysDifference <= 0) {
//                Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                alert.setTitle("ERREUR");
//                alert.setHeaderText("Chèr(e) "+NomEmp+", \nVotre prochain pérmission doit être après le " +dateRetourPlus10Jours+".");
//                alert.setContentText("Erreur");
//                alert.showAndWait();
//                return;
//            }
//        }
        Double Solde;
        Solde=nombreJ;
        String ExeceptionConger = ExceptionCongerAutoriser.getValue();
        if(IsPermision==false && IsEditPermis==false)
        {
            if ("Courant".equals(ExceptionCongerAutoriser.getValue()) || "Autre".equals(ExceptionCongerAutoriser.getValue()))
            {
                Solde=soldeReste-nombreJ;
            }
        }
        if (IsPermision==true || IsEditPermis==true)
        {
            Solde=SoldePermisRst-nombreJ;
        }
        if(Solde<0 && IsPermision==false)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ERREUR");
            alert.setHeaderText("Vous avez dépassé la limite du congé 30j \nVotre solde reste : "+soldeReste);
            alert.setContentText("Dépasse la limite");
            alert.showAndWait();
            return;
        }
        if (nombreJ>3 && IsPermision==true)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ERREUR");
            alert.setHeaderText("Vous avez dépassé la limite du permission 3j à chaque retrait. \nVotre solde reste : "+SoldePermisRst);
            alert.setContentText("Dépasse la limite");
            alert.showAndWait();
            return;
        }
        if (nombreJ==0)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ERREUR");
            alert.setHeaderText("Le nombre de jour ne doit pas égale à Zéro(0)");
            alert.setContentText(null);
            alert.showAndWait();
            return;
        }
        if (Solde<0 && IsPermision==true)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ERREUR");
            alert.setHeaderText("Vous avez dépassé la limite du permission 10j \nVotre solde reste : "+SoldePermisRst);
            alert.setContentText("Dépasse la limite");
            alert.showAndWait();
            return;
        }

        try {
            if (IsEdit==false && IsPermision==false && IsEditPermis==false)
            {
                pst = con.prepareStatement("INSERT INTO `conger`(`DateDeb`, `Id_empl`, `Name_empl`,`Prenom_empf`, Function_second, NumPhone_empl, `DateRetour`, `Nbr_jour`, Solde_conge, `ExceptionDate`,AutreException, Expiration) values(?,?,?,?,?,?,?,?,?,?,?,?)");
                pst.setDate(1, Date.valueOf(dateDebConges));
                pst.setInt(2,Id);
                pst.setString(3, NomEmp);
                pst.setString(4, PrenomEmpf);
                pst.setString(5, Fonction);
                pst.setString(6, Numero);
                pst.setDate(7, Date.valueOf(DateFin));
                pst.setDouble(8, nombreJ);
                if (ExceptionCongerAutoriser.getValue()=="Congé du maternité" || ExceptionCongerAutoriser.getValue()=="Congé du paternité")
                {
                    pst.setDouble(9, 00);
                }
                else
                {
                    pst.setDouble(9, Solde);
                }
                pst.setString(10, ExeceptionConger);
                pst.setString(11, AutreExcepte);
                pst.setString(12, "En cours");
                pst.executeUpdate();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Insertion dans la base");
                alert.setHeaderText("Enregistré");
                alert.setContentText("Enregistrement du congé avec succès");
                alert.showAndWait();
            }
            else if(IsPermision==true && IsEditPermis==false)
            {
                pst = con.prepareStatement("INSERT INTO `permission`(`Date_permis`, `Id_empl`, `Name_empl`, Function_second, NumPhone_empl, `DateRetour`, `NbrJour_permis`, SoldeReste_permis, `Observation`, Expiration) values(?,?,?,?,?,?,?,?,?,?)");
                pst.setDate(1, Date.valueOf(dateDebConges));
                pst.setInt(2,Id);
                pst.setString(3, NomEmp);
                pst.setString(4, Fonction);
                pst.setString(5, Numero);
                pst.setDate(6, Date.valueOf(DateFin));
                pst.setDouble(7, nombreJ);
                if (ExceptionCongerAutoriser.getValue()=="Congé du maternité" || ExceptionCongerAutoriser.getValue()=="Congé du paternité")
                {
                    pst.setDouble(8, 00);
                }
                else
                {
                    pst.setDouble(8, Solde);
                }
                pst.setString(9, ExeceptionConger);
                pst.setString(10, "En cours");
                pst.executeUpdate();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Insertion dans la base");
                alert.setHeaderText("Enregistré");
                alert.setContentText("Enregistrement du pérmission avec succès");
                alert.showAndWait();
            }
            else if (IsEditPermis==true)
            {
                pst = con.prepareStatement("update permission set Date_permis = ?, DateRetour = ?,NbrJour_permis = ?,SoldeReste_permis = ?, Observation=? where Id_permis = ?");
                pst.setDate(1, Date.valueOf(dateDebConges));
                pst.setDate(2, Date.valueOf(DateFin));
                pst.setDouble(3, nombreJ);
                if (ExceptionCongerAutoriser.getValue()=="Congé du maternité" || ExceptionCongerAutoriser.getValue()=="Congé du paternité")
                {
                    pst.setDouble(4, 00);
                }
                else
                {
                    pst.setDouble(4, Solde);
                }
                pst.setString(5, ExeceptionConger);
                pst.setInt(6, id);
                pst.executeUpdate();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Modification du pérmission");
                alert.setHeaderText("La modification de "+NomEmp+" a reussit avec succès");
                alert.setContentText("Modification avec succès");
                alert.showAndWait();
            }
            else
            {
                pst = con.prepareStatement("update conger set DateDeb = ?, DateRetour = ?,Nbr_jour = ?,Solde_conge = ?, ExceptionDate=?, AutreException=? where Id_conge = ?");
                pst.setDate(1, Date.valueOf(dateDebConges));
                pst.setDate(2, Date.valueOf(DateFin));
                pst.setDouble(3, nombreJ);
                if (ExceptionCongerAutoriser.getValue()=="Congé du maternité" || ExceptionCongerAutoriser.getValue()=="Congé du paternité")
                {
                    pst.setDouble(4, 00);
                }
                else
                {
                    pst.setDouble(4, Solde);
                }
                pst.setString(5, ExeceptionConger);
                pst.setString(6, AutreExcepte);
                pst.setInt(7, id);
                pst.executeUpdate();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Modification du congé");
                alert.setHeaderText("La modification de "+NomEmp+" a reussit avec succès");
                alert.setContentText("Modification avec succès!");
                alert.showAndWait();
            }

            table();
            if (IsPermision==true)
            {
                PanePermissionListe.setVisible(true);
                TableauPermission();
            }
            else if (IsEditPermis==true)
            {
                PanePermissionListe.setVisible(true);
                TableauPermission();
            }
            else
            {
                PanelCongerEmpl.setVisible(false);
                TableauConger();
            }
            DateCongeText.setValue(LocalDate.now());
            DateFinText.setValue(null);
            ExceptionCongerAutoriser.setValue(null);
            isDateRetourNull=false;
            ExceptionAutre.setDisable(false);///////////////////
            BtnDemiJour.setDisable(true);//////////
            IsPermision=false;
            IsEdit=false;
            IsEditPermis=false;
            NomText.requestFocus();

        } catch (SQLException ex) {
            Logger.getLogger(HelloController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void calculateDateDifference() {///////////////////////////
        LocalDate date1 = DateCongeText.getValue();
        LocalDate date2 = DateFinText.getValue();

        if (date1 != null && date2 != null) {
            long daysDifference = ChronoUnit.DAYS.between(date1, date2);
            NbrJour.setText(String.valueOf(daysDifference));
        } else {
            NbrJour.setText(""); // Efface le champ si l'une des dates est nulle.
        }
    }


    @FXML
    void DateFinText_click(ActionEvent event) {
        calculateDateDifference();
    }

    @FXML
    void DateCongeText_click(ActionEvent event) {
        calculateDateDifference();
    }

    @FXML
    void BtnCongerEmpl_click(ActionEvent event) {/////CORRECTION 4
        menamena.setVisible(true);
        paneconger.setVisible(true);
        PanelCongerEmpl.setVisible(true);
        PanelPourListerEmployeSabata.setVisible(false);
        PanelCongesSabhatique.setVisible(false);
        PanelMavoValidationCsabata.setVisible(false);
        PanePermissionListe.setVisible(false);
        IsPermision=false;

        IsEditPermis=false;
        IsEdit=false;
        ExceptionCongerAutoriser.getItems().clear();
        ExceptionCongerAutoriser.getItems().addAll("Congé du maternité", "Congé du paternité","Courant", "Autre");
    }
    //Bouton pour le congé sabhatique
    @FXML
    void BtnCongesSabhatique(ActionEvent event) {
        menamena.setVisible(true);
        paneconger.setVisible(true);
        PanelCongerEmpl.setVisible(true);
        PanelCongesSabhatique.setVisible(true);
        PanelPourListerEmployeSabata.setVisible(false);
        PanelMavoValidationCsabata.setVisible(false);
        PanePermissionListe.setVisible(true);
        AfficherCongerSabataEnCours();

        // Ajoutez un écouteur sur le champ de recherche pour appeler la fonction de recherche
        barreDeRecherche.textProperty().addListener((observable, oldValue, newValue) -> {
            rechercheEmployes(newValue);
        });
        rechercheEmpSabata.textProperty().addListener((observable, oldValue, newValue) -> {
            rechercheEmplCongesSabataEnCours(newValue);
        });
        rechercheParDateDebut.setVisible(true);
        motChercher.setVisible(true);
        bokotraRefresh.setVisible(true);
        BokotraAnnuler.setVisible(true);
        rechercheEmpSabata.setVisible(true);
        labelquiVarie.setVisible(true);
        labelquiVariee.setText("Gestion du conge sabbatique");
        bokotraImprimerCsabhatique.setVisible(true);
        imageSabata.setVisible(true);
    }

    @FXML
    void ActionDateSpecifique(ActionEvent event) {
        LocalDate selectedDate = rechercheParDateDebut.getValue(); // Obtenir la date sélectionnée dans le DatePicker
        updateTableWithDate(selectedDate);
    }

    //bouton pour lister les employes gagne de conger sabhatique
    @FXML
    void BtnActionListeCongesSabata(ActionEvent event) {
        Connect();
        TableSabhatique();
        menamena.setVisible(true);
        paneconger.setVisible(true);
        PanelCongerEmpl.setVisible(true);
        PanelPourListerEmployeSabata.setVisible(true);
        PanelCongesSabhatique.setVisible(true);
        PanelMavoValidationCsabata.setVisible(false);
        rechercheParDateDebut.setVisible(false);
        PanePermissionListe.setVisible(true);
        motChercher.setVisible(false);
        bokotraRefresh.setVisible(false);
        BokotraAnnuler.setVisible(false);
        rechercheEmpSabata.setVisible(false);

        bokotraImprimerCsabhatique.setVisible(false);
        imageSabata.setVisible(false);
    }
    public void DateVingtJourAutomatique() {
        // Récupérez la date actuelle
        LocalDate currentDate = DateDebCsabata.getValue();

        // Ajoutez 20 jours à la date actuelle
        LocalDate resultDate = currentDate.plusDays(20);

        // Affichez la date résultante dans le deuxième DatePicker
        DateFINCsabata.setValue(resultDate);
    }
    //Bouton pour la récupération du congé sabhatique
    @FXML
    void RecupererCongerSabata(ActionEvent event) {
        menamena.setVisible(true);
        paneconger.setVisible(true);
        PanelCongerEmpl.setVisible(true);
        PanelCongesSabhatique.setVisible(true);
        PanelPourListerEmployeSabata.setVisible(true);
        PanelMavoValidationCsabata.setVisible(true);
        PanePermissionListe.setVisible(true);
        // Assurez-vous que DateDebCsabata est initialisé avec une date
        DateDebCsabata.setValue(LocalDate.now());
        DateVingtJourAutomatique();
    }
    public void EnregistrementCongesSpecial() {
        // Récupérer les valeurs des TextField et des DatePicker
        String nom = TeFieldNomEmpCsabata.getText();
        String prenom = TextFieldPrenomCsabata.getText();
        Date dateDebut = java.sql.Date.valueOf(DateDebCsabata.getValue());
        Date dateFin = java.sql.Date.valueOf(DateFINCsabata.getValue());

        // Établir la connexion à la base de données
        String url = "jdbc:mysql://localhost:3306/basegrh";
        String utilisateur = "root";
        String motDePasse = "";
        try {
            Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse);

            // Vérifier si l'année et le nom existent déjà
            String verificationSql = "SELECT * FROM `conges_sabhatique` WHERE YEAR(`Datedeb_empSab`) = ? AND `Nom_empSab` = ?";
            PreparedStatement verificationStatement = connexion.prepareStatement(verificationSql);
            verificationStatement.setInt(1, dateDebut.toLocalDate().getYear());
            verificationStatement.setString(2, nom);

            ResultSet resultSet = verificationStatement.executeQuery();

            if (resultSet.next()) {
                // Si des données existent, afficher un message d'erreur
                System.out.println("Cette personne a déjà pris un congé sabhatique cette année.");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setHeaderText("Congé déjà existant");
                alert.setContentText("Cette personne a déjà pris un congé sabhatique cette année.");
                alert.showAndWait();
            } else {
                // Si les données n'existent pas, afficher la boîte de dialogue de confirmation
                Alert confirmationDialog = new Alert(Alert.AlertType.CONFIRMATION);
                confirmationDialog.setTitle("Confirmation");
                confirmationDialog.setHeaderText("Confirmation d'enregistrement");
                confirmationDialog.setContentText("Êtes-vous sûr de vouloir enregistrer ce congé ?");

                Optional<ButtonType> result = confirmationDialog.showAndWait();

                if (result.isPresent() && result.get() == ButtonType.OK) {
                    // Insérer les nouvelles données
                    String sql = "INSERT INTO `conges_sabhatique`(`Nom_empSab`, `Prenom_empSab`, `Datedeb_empSab`, `DateFin_empSab`) VALUES (?, ?, ?, ?)";
                    PreparedStatement preparedStatement = connexion.prepareStatement(sql);
                    preparedStatement.setString(1, nom);
                    preparedStatement.setString(2, prenom);
                    preparedStatement.setDate(3, dateDebut);
                    preparedStatement.setDate(4, dateFin);

                    int lignesModifiees = preparedStatement.executeUpdate();
                    if (lignesModifiees > 0) {
                        System.out.println("Congés enregistrés avec succès !");
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Enregistrement");
                        alert.setHeaderText("Congés Sabhatique");
                        alert.setContentText("Congés Sabhatique enregistrés avec succès");
                        alert.showAndWait();
                    } else {
                        System.out.println("Échec de l'enregistrement des congés.");
                    }

                    // Fermer la connexion
                    preparedStatement.close();
                } else {
                    System.out.println("L'enregistrement a été annulé.");
                }
            }

            resultSet.close();
            verificationStatement.close();
            connexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour mettre à jour les éléments de la TableView en fonction de la date sélectionnée
    private void updateTableWithDate(LocalDate selectedDate) {
        ObservableList<CongesSAB> EmployeesPresence = FXCollections.observableArrayList();
        try {
            // ... (même code que dans votre méthode tablepresences, sauf la requête SQL)
            PreparedStatement pst = con.prepareStatement("SELECT `ID_congesab`, `Nom_empSab`, `Prenom_empSab`, `Datedeb_empSab`, `DateFin_empSab` FROM `conges_sabhatique` WHERE `Datedeb_empSab` = ?");
            pst.setString(1, selectedDate.toString());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                CongesSAB st = new CongesSAB();
                st.setIdCongesSAB(rs.getString("ID_congesab"));
                st.setNomCongesSAB(rs.getString("Nom_empSab"));
                st.setPrenomCongesSAB(rs.getString("Prenom_empSab"));
                st.setDateCongesSAB(rs.getString("Datedeb_empSab"));
                st.setDateFinCongesSAB(rs.getString("DateFin_empSab"));
                EmployeesPresence.add(st);
            }
            TableCongesSabhatique.setItems(EmployeesPresence);
        } catch (SQLException eex) {
            Logger.getLogger(HelloController.class.getName()).log(Level.SEVERE, null, eex);
        } finally {
            // ...
        }
    }

    //Bouton pour valider le congé sabhatique
    @FXML
    void ActionBoutonValiderCongerSabata(ActionEvent event) {
        EnregistrementCongesSpecial();
    }
    @FXML
    void BoutonActionRafraichirTabSabata(ActionEvent event) {
        AfficherCongerSabataEnCours();
    }

    @FXML
    void BoutonAnnulerCsabata_click(ActionEvent event) {
        Connect();
        myIndex = TableCongesSabhatique.getSelectionModel().getSelectedIndex();
        id = Integer.parseInt(String.valueOf(TableCongesSabhatique.getItems().get(myIndex).getIdCongesSAB()));
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Validation");
            alert.setHeaderText("Voulez-vous vraiment Annuler ce congé sabhatique ?");
            alert.setContentText("Annulation");
            // Affiche la boîte de dialogue de confirmation et attend la réponse de l'utilisateur
            Optional<ButtonType> result = alert.showAndWait();
            if (((Optional<?>) result).isPresent() && result.get() == ButtonType.OK) {
                pst = con.prepareStatement("DELETE FROM `conges_sabhatique` WHERE ID_congesab = ?");
                pst.setInt(1, id);
                pst.executeUpdate();
                AfficherCongerSabataEnCours();
            } else {
                AfficherCongerSabataEnCours();
                System.out.println("Opération d'annulation");
            }

        } catch (Exception OJ) {
            Logger.getLogger(HelloController.class.getName()).log(Level.SEVERE, null, OJ);
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Gestion congé tsotra //CORRECTION 3
    @FXML
    void BtnModifieConger_click(ActionEvent event) {
        IsEdit=true;
        IsEditPermis=false;
        boolean IsExpr= ExpirerModSuppr();
        if (IsExpr==true)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Expirer");
            alert.setHeaderText("La période de la suppression a été terminer");
            alert.setContentText("Période dépasser");
            alert.showAndWait();
            return;
        }
        menamena.setVisible(true);
        paneconger.setVisible(true);
        PanelCongerEmpl.setVisible(true);
        PanelPourListerEmployeSabata.setVisible(false);
        PanelCongesSabhatique.setVisible(false);
        PanelMavoValidationCsabata.setVisible(false);
        PanePermissionListe.setVisible(false);
        ExceptionCongerAutoriser.getItems().clear();
        ExceptionCongerAutoriser.getItems().addAll("Congé du maternité", "Congé du paternité","Courant", "Autre");
    }

    @FXML
    void BtnSupprConger_click(ActionEvent event) {
        boolean IsExpr= ExpirerModSuppr();
        if (IsExpr==true)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Expirer");
            alert.setHeaderText("La période de la suppression a été terminer");
            alert.setContentText("Période dépasser");
            alert.showAndWait();
            return;
        }

        Connect();
        myIndex = TableViewConges.getSelectionModel().getSelectedIndex();
        id = Integer.parseInt(String.valueOf(TableViewConges.getItems().get(myIndex).getId_conger()));

        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Validation suppression");
            alert.setHeaderText("Voulez-vous vraiment supprimer ?");
            alert.setContentText("Supprimé");

            // Affiche la boîte de dialogue de confirmation et attend la réponse de l'utilisateur
            Optional<ButtonType> result = alert.showAndWait();

            if (((Optional<?>) result).isPresent() && result.get() == ButtonType.OK) {
                pst = con.prepareStatement("DELETE FROM `Conger` WHERE Id_conge = ?");
                pst.setInt(1, id);
                pst.executeUpdate();
                TableauConger();
            } else {
                TableauConger();
            }

        } catch (Exception OJ) {
            Logger.getLogger(HelloController.class.getName()).log(Level.SEVERE, null, OJ);
        }
    }
    //CORRECTION 2
    @FXML
    void BtnPermission_click(ActionEvent event) {
        IsPermision=true;
        IsEdit=false;
        IsEditPermis=false;
        menamena.setVisible(true);
        paneconger.setVisible(true);
        PanelCongerEmpl.setVisible(true);
        PanelPourListerEmployeSabata.setVisible(false);
        PanelCongesSabhatique.setVisible(false);
        PanelMavoValidationCsabata.setVisible(false);
        PanePermissionListe.setVisible(false);

        BtnDemiJour.setDisable(false);
        ExceptionCongerAutoriser.getItems().clear();
        ExceptionCongerAutoriser.getItems().addAll("Courant");
        labelquiVarie.setText("Gestion de permission");
    }
    //Gestion des permissions itambarana ////CORRECTION
    @FXML
    void BtnModifiePermis_click(ActionEvent event) {
        IsEditPermis=true;
        IsEdit=false;
        BtnDemiJour.setDisable(false);
        boolean IsExpr= ExpirerModSuppr();
        if (IsExpr==true)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Expirer");
            alert.setHeaderText("La période de la suppression a été terminer");
            alert.setContentText("La date de retour dépasse à la date aujourd'hui");
            alert.showAndWait();
            return;
        }
//        menamena.setVisible(true);
//        paneconger.setVisible(true);
//        PanelCongerEmpl.setVisible(true);
//        PanePermissionListe.setVisible(false);
        menamena.setVisible(true);
        paneconger.setVisible(true);
        PanelCongerEmpl.setVisible(true);
        PanelPourListerEmployeSabata.setVisible(false);
        PanelCongesSabhatique.setVisible(false);
        PanelMavoValidationCsabata.setVisible(false);
        PanePermissionListe.setVisible(false);
        ExceptionCongerAutoriser.getItems().clear();
        ExceptionCongerAutoriser.getItems().addAll("Courant");
    }
    @FXML
    void BtnSupprPermis_click(ActionEvent event) {
        boolean IsExpr= ExpirerModSuppr();
        if (IsExpr==true)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Expirer");
            alert.setHeaderText("La période de la suppression a été terminer");
            alert.setContentText("Période dépasser");
            alert.showAndWait();
            return;
        }

        Connect();
        myIndex = TableViewPermission.getSelectionModel().getSelectedIndex();
        id = Integer.parseInt(String.valueOf(TableViewPermission.getItems().get(myIndex).getId_permis()));

        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Validation suppression");
            alert.setHeaderText("Voulez-vous vraiment supprimer ?");
            alert.setContentText("Supprimé");

            // Affiche la boîte de dialogue de confirmation et attend la réponse de l'utilisateur
            Optional<ButtonType> result = alert.showAndWait();

            if (((Optional<?>) result).isPresent() && result.get() == ButtonType.OK) {
                pst = con.prepareStatement("DELETE FROM `permission` WHERE Id_permis = ?");
                pst.setInt(1, id);
                pst.executeUpdate();
                TableauPermission();
            } else {
                TableauPermission();
            }

        } catch (Exception OJ) {
            Logger.getLogger(HelloController.class.getName()).log(Level.SEVERE, null, OJ);
        }
    }
    //Barre de recherche Nel permission
    @FXML
    void TextRechercherPermis_click(ActionEvent event) {
        String recherche = TextRechercherPermis.getText();
        Connect();
        if (recherche.isEmpty()) {
            // Si le champ de recherche est vide
            TableauPermission();
        }
        ObservableList<PermissionClass> resultats = FXCollections.observableArrayList();
        try {
            PreparedStatement pst = con.prepareStatement("SELECT Id_permis, `Date_permis`, `Name_empl`, `Function_second`, `NumPhone_empl`, `DateRetour`, NbrJour_permis, SoldeReste_permis, Observation FROM `permission` " +
                    "WHERE Date_permis LIKE ? OR Name_empl LIKE ? OR Function_second LIKE ? OR NumPhone_empl LIKE ? OR DateRetour LIKE ? OR NbrJour_permis LIKE ? OR SoldeReste_permis LIKE ? OR Observation LIKE ?");
            pst.setString(1, "%" + recherche + "%");
            pst.setString(2, "%" + recherche + "%");
            pst.setString(3, "%" + recherche + "%");
            pst.setString(4, "%" + recherche + "%");
            pst.setString(5, "%" + recherche + "%");
            pst.setString(6, "%" + recherche + "%");
            pst.setString(7, "%" + recherche + "%");
            pst.setString(8, "%" + recherche + "%");
          ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                PermissionClass st = new PermissionClass();
                st.setId_permis(rs.getString("Id_permis"));
                st.setDateDebPermis(rs.getString("Date_permis"));
                st.setName_emplPermis(rs.getString("Name_empl"));
                st.setFonction_emplPermis(rs.getString("Function_second"));
                st.setPhoneNumberPermis(rs.getString("NumPhone_empl"));
                st.setDateRetourPermis(rs.getString("DateRetour"));
                st.setNbr_jourPermis(rs.getString("NbrJour_permis"));
                st.setSoldePermis(rs.getString("SoldeReste_permis"));
                st.setObservationPermis(rs.getString("Observation"));
                resultats.add(st);
            }
            TableViewPermission.setItems(resultats);
        } catch (SQLException e) {
            Logger.getLogger(HelloController.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(HelloController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    //Barre de recherche Nel congé  //RECHERCHE CONGE
    @FXML
    void RechercheCongerText_click(ActionEvent event) {
        String recherche = RechercheCongerText.getText();
        Connect();
        if (recherche.isEmpty()) {
            // Si le champ de recherche est vide
            TableauConger();
        }
        ObservableList<conger> resultats = FXCollections.observableArrayList();
        try {
            PreparedStatement pst = con.prepareStatement("SELECT Id_conge, `DateDeb`, `Name_empl`, `Function_second`, `NumPhone_empl`, `DateRetour`, Nbr_jour, Solde_conge, ExceptionDate FROM `conger` " +
                    "WHERE DateDeb LIKE ? OR Name_empl LIKE ? OR Function_second LIKE ? OR NumPhone_empl LIKE ? OR DateRetour LIKE ? OR Nbr_jour LIKE ? OR Solde_conge LIKE ? OR ExceptionDate LIKE ?");
            pst.setString(1, "%" + recherche + "%");
            pst.setString(2, "%" + recherche + "%");
            pst.setString(3, "%" + recherche + "%");
            pst.setString(4, "%" + recherche + "%");
            pst.setString(5, "%" + recherche + "%");
            pst.setString(6, "%" + recherche + "%");
            pst.setString(7, "%" + recherche + "%");
            pst.setString(8, "%" + recherche + "%");

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                conger st = new conger();
                st.setId_conger(rs.getString("Id_conge"));
                st.setDateDebConger(rs.getString("DateDeb"));
                st.setName_empl(rs.getString("Name_empl"));
                st.setFonction_empl(rs.getString("Function_second"));
                st.setPhoneNumber(rs.getString("NumPhone_empl"));
                st.setDateRetour(rs.getString("DateRetour"));
                st.setNbr_jour(rs.getString("Nbr_jour"));
                st.setSolde_conge(rs.getString("Solde_conge"));
                st.setExceptionDate(rs.getString("ExceptionDate"));
                resultats.add(st);
            }
            TableViewConges.setItems(resultats);
        } catch (SQLException e) {
            Logger.getLogger(HelloController.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(HelloController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public boolean ExpirerModSuppr() {
        LocalDate date1 = LocalDate.now();
        LocalDate date2 = DateRetour;

        long daysDifference = ChronoUnit.DAYS.between(date1, date2);
        if (daysDifference<0)
        {
            return true;
        }
        else
        {
            return  false;
        }
    }
    public double getSoldeCongeRestant(int idEmploye) {// CORRECTION 10
        int soldeCongeRestant = 0;
        Connect();
        try {
            if (IsEdit==true)
            {
                String query = "SELECT Solde_conge FROM conger WHERE Expiration='En cours' and ExceptionDate NOT like 'Congé%' and Id_empl = ? ORDER BY DateRetour DESC LIMIT 1 OFFSET 1";
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.setInt(1, idEmploye);

                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    soldeCongeRestant = resultSet.getInt("Solde_conge");
                }
                else
                {
                    soldeCongeRestant=30;
                }
            }
            else
            {
                String query = "SELECT Solde_conge FROM conger WHERE Expiration='En cours' and ExceptionDate NOT like 'Congé%' and Id_empl = ? ORDER BY DateRetour DESC LIMIT 1";
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.setInt(1, idEmploye);

                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    soldeCongeRestant = resultSet.getInt("Solde_conge");
                }
                else
                {
                    soldeCongeRestant=30;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return soldeCongeRestant;
    }
    public Double getSoldePermissionRestant(int idEmploye) {////CORRECTION 9
        Double soldePermisRestant = 0.0;
        Connect();
        try {
            if (IsEditPermis==true)
            {
                String query = "SELECT SoldeReste_permis FROM permission WHERE Expiration='En cours' and Id_empl = ? ORDER BY DateRetour DESC LIMIT 1 OFFSET 1";
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.setInt(1, idEmploye);

                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    soldePermisRestant = resultSet.getDouble("SoldeReste_permis");
                }
                else
                {
                    soldePermisRestant= 10.0;
                }
            }
            else
            {
                String query = "SELECT SoldeReste_permis FROM permission WHERE Expiration='En cours' and Id_empl = ? ORDER BY DateRetour DESC LIMIT 1";
                PreparedStatement preparedStatement = con.prepareStatement(query);
                preparedStatement.setInt(1, idEmploye);

                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    soldePermisRestant = resultSet.getDouble("SoldeReste_permis");
                }
                else
                {
                    soldePermisRestant=10.0;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return soldePermisRestant;
    }
    private boolean isDateRetourNull;
    public Date getDateRetour(int idEmploye) {//CORRECTION 8
        Date dateFinConger = null;
        Connect();

        try  {
            String query = "SELECT DateRetour FROM conger WHERE Expiration='En cours' and ExceptionDate NOT like 'Congé%' and Id_empl = ? ORDER BY DateDeb DESC LIMIT 1";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, idEmploye);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    dateFinConger = resultSet.getDate("DateRetour");
                    isDateRetourNull = false;
                } else {
                    isDateRetourNull = true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dateFinConger;
    }
    private boolean isDateRetourPermisNull;//////
    public Date getDateRetourPermis(int idEmploye) {//////
        Date dateFinPermis = null;
        Connect();

        try  {
            String query = "SELECT DateRetour FROM permission WHERE Expiration='En cours' and Id_empl = ? ORDER BY Date_permis DESC LIMIT 1";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, idEmploye);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    dateFinPermis = resultSet.getDate("DateRetour");
                    isDateRetourPermisNull = false;
                } else {
                    isDateRetourPermisNull = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dateFinPermis;
    }
    //Fonction imprimer le congé
    @FXML
    void FonctionImpressionCongerTsotra(ActionEvent event) {
        try {
            // Créer un nouveau document Word
            XWPFDocument document = new XWPFDocument();

            // Créer une police Times New Roman
           // XWPFFont timesNewRomanFont = document.createFont();
           // timesNewRomanFont.setFamily("Times New Roman");

            // Créer un paragraphe pour le titre "CONGE" et le formater
            XWPFParagraph titleParagraph = document.createParagraph();
            titleParagraph.setAlignment(ParagraphAlignment.CENTER);

            // Créer une zone de texte pour le titre
            XWPFRun titleRun = titleParagraph.createRun();
            titleRun.setText("CONGE");
            titleRun.setFontSize(25); // Augmentez la taille de la police ici

            // Mettre en gras le mot "CONGE"
            titleRun.setBold(true);

            //Modifier le font family
            titleRun.setFontFamily("Times New Roman");

            // Insérer une ligne vide après le titre
            document.createParagraph().createRun();

            // Récupérer les données de votre TableViewConges (qui devrait déjà être remplie depuis la base de données)
            ObservableList<conger> itemsList = TableViewConges.getItems();

            // Itérer sur les éléments de TableViewConges et ajouter leurs données au document Word
            for (conger item : itemsList) {
                XWPFParagraph paragraph = document.createParagraph();
                XWPFRun run = paragraph.createRun();

                // Utiliser la police Times New Roman pour les éléments du TableView
                run.setFontFamily("Times New Roman");

                // Augmenter la taille de police pour les éléments du TableView
                run.setFontSize(20); // Augmentez la taille de la police ici

                // Remplacez les propriétés suivantes par les propriétés de votre modèle conger
                run.setText(item.getName_empl() +", "+ item.getLast_name_empl()+", "  + item.getDateDebConger() + ", " + item.getDateRetour() + ", " + item.getNbr_jour());
            }

            // Ajuster le contenu au format de page Word (peut nécessiter un ajustement manuel)
            // Utilisez les méthodes d'Apache POI pour formater le document comme vous le souhaitez

            // Demander à l'utilisateur de spécifier le chemin de sauvegarde du document
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Enregistrer le document Word");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Fichiers Word (*.docx)", "*.docx"));
            File file = fileChooser.showSaveDialog(new Stage());

            if (file != null) {
                // Enregistrer le document Word au chemin spécifié par l'utilisateur
                FileOutputStream out = new FileOutputStream(file);
                document.write(out);
                out.close();

                // Ouvrir le document Word avec Microsoft Word
                Runtime.getRuntime().exec("cmd /c start winword \"" + file.getAbsolutePath() + "\"");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Fonction pour imprimer le congé sabhatique
    @FXML
    void FonctionImprimerCONGEsabhatique(ActionEvent event) {
        try {
            // Créer un nouveau document Word
            XWPFDocument document = new XWPFDocument();

            // Créer un paragraphe pour le titre "CONGE" et le formater
            XWPFParagraph titleParagraph = document.createParagraph();
            titleParagraph.setAlignment(ParagraphAlignment.CENTER);

            // Créer une zone de texte pour le titre
            XWPFRun titleRun = titleParagraph.createRun();
            titleRun.setText("CONGE SABBATIQUE");
            titleRun.setFontSize(26); // Augmentez la taille de la police ici

            // Mettre en gras le mot "CONGE"
            titleRun.setBold(true);

            //Modifier le font family
            titleRun.setFontFamily("Times New Roman");

            // Insérer une ligne vide après le titre
            document.createParagraph().createRun();

            // Récupérer les données de votre TableViewConges (qui devrait déjà être remplie depuis la base de données)
            ObservableList<CongesSAB> itemsList = TableCongesSabhatique.getItems();

            // Itérer sur les éléments de TableViewConges et ajouter leurs données au document Word
            for (CongesSAB item : itemsList) {
                XWPFParagraph paragraph = document.createParagraph();
                XWPFRun run = paragraph.createRun();

                // Utiliser la police Times New Roman pour les éléments du TableView
                run.setFontFamily("Times New Roman");

                // Augmenter la taille de police pour les éléments du TableView
                run.setFontSize(20); // Augmentez la taille de la police ici

                // Remplacez les propriétés suivantes par les propriétés de votre modèle conger
                run.setText(item.getNomCongesSAB() +",     "  + item.getPrenomCongesSAB() + ",   " + item.getDateCongesSAB() + ",   " + item.getDateFinCongesSAB());
            }

            // Ajuster le contenu au format de page Word (peut nécessiter un ajustement manuel)
            // Utilisez les méthodes d'Apache POI pour formater le document comme vous le souhaitez

            // Demander à l'utilisateur de spécifier le chemin de sauvegarde du document
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Enregistrer le document Word");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Fichiers Word (*.docx)", "*.docx"));
            File file = fileChooser.showSaveDialog(new Stage());

            if (file != null) {
                // Enregistrer le document Word au chemin spécifié par l'utilisateur
                FileOutputStream out = new FileOutputStream(file);
                document.write(out);
                out.close();

                // Ouvrir le document Word avec Microsoft Word
                Runtime.getRuntime().exec("cmd /c start winword \"" + file.getAbsolutePath() + "\"");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Fonction pour gérer le demi-journée //CORRECTION 6
    @FXML
    void BtnDemiJour_click(ActionEvent event) {
        if ("00".equals(NbrJour.getText()) || "".equals(NbrJour.getText()))
        {
            // Obtenez la date actuelle
            LocalDate currentDate =  DateCongeText.getValue();
            // Ajoutez démi-journée à la date debut du congé
            DateFinText.setValue(currentDate.plus((long) 0.5, ChronoUnit.DAYS));
            NbrJour.setText("0.5");
        }
        else
        {
            // Obtenez la date fin
            LocalDate currentDateDeb =  DateCongeText.getValue();
            double NbrDuJour= Double.parseDouble((NbrJour.getText()));
            double SommeDuJour=NbrDuJour+0.5;
            NbrJour.setText(String.valueOf(SommeDuJour));
            LocalDate dateRetourPlusJours = currentDateDeb.plusDays((long) SommeDuJour);
            DateFinText.setValue(dateRetourPlusJours);
        }
    }
    void SelectionComboxAutre()//CORRECTION 7
    {
        // Ajoutez un écouteur de changement de sélection au ComboBox
        ExceptionCongerAutoriser.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                // Vérifiez si "Autre" est sélectionné
                if ("Autre".equals(newValue)) {
                    // Activez le TextField
                    ExceptionAutre.setDisable(false);
                }
                else {
                    // Désactivez le TextField
                    ExceptionAutre.setDisable(true);
                    ExceptionAutre.setText("");
                }
            }
        });
    }

    @FXML
    void bouttonApropos_Click(ActionEvent event) {
        afficherMessageBoxInformationTrave("Dévéllopées par:\n\n \tOnjaniaina Mampionona,\n\tMarion Brunel,\n\tElie Donacien \n\nEmail:\n\n\tonjaniainamapionona@gmail.com\n\trazafimaharavomarion@gmail.com\n\telierandrianantenaina301@gmail.com");
    }
    private void afficherMessageBoxInformationTrave(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Logiciel");
        alert.setHeaderText("A propos");
        alert.setContentText(message);
        alert.showAndWait();
    }

}