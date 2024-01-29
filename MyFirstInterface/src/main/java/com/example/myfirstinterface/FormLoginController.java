package com.example.myfirstinterface;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.Optional;

public class FormLoginController {
    @FXML
    private AnchorPane pane1;
    @FXML
    private Button BtnSeConnect;
    @FXML
    private PasswordField passwordFieldMotDePasse;

    @FXML
    private TextField textFieldNomUtilisateur;
    Connection con;
    PreparedStatement pst;

    //Fonction pour le bouton Se connecter
    @FXML
    void ActionPourConnecter(ActionEvent event) throws IOException {
        String nomUtilisateur = textFieldNomUtilisateur.getText();
        String motDePasse = passwordFieldMotDePasse.getText();

        if (nomUtilisateur.isEmpty() || motDePasse.isEmpty()) {
            afficherMessageBoxAttention("Vous devez remplir tous les champs.");
        } else {
            boolean confirmation = verifierIdentifiants(nomUtilisateur, motDePasse);

            if (confirmation) {
                afficherMessageBoxInformation("Bienvenue!");
                ouvrirFormulaireGestion();
            } else {
                afficherMessageBox("Nom d'utilisateur ou mot de passe incorrect.");
            }
        }
    }


    public void initialize() {

    }

    //////////////////////////////////////////////////////////////////////////////////////////
    private void ouvrirFormulaireGestion() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Gestion");
        stage.setScene(new Scene(root));

        // Fermez la fenêtre précédente (Form1)
        Stage currentStage = (Stage) BtnSeConnect.getScene().getWindow();
        currentStage.close();

        // Affichez le formulaire hello-view.fxml
        stage.show();
    }
    private void afficherMessageBox(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    private void afficherMessageBoxAttention(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    private void afficherMessageBoxInformation(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private boolean verifierIdentifiants(String nomUtilisateur, String motDePasse) {
        // URL de connexion à la base de données
        String url = "jdbc:mysql://localhost:3306/basegrh";
        String utilisateurBDD = "root";
        String motDePasseBDD = "";

        try {
            // Établir une connexion à la base de données
            Connection con = DriverManager.getConnection(url, utilisateurBDD, motDePasseBDD);

            // Requête SQL pour rechercher l'utilisateur dans la table "login"
            String sql = "SELECT * FROM login WHERE Nom_log = ? AND PassWords = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, nomUtilisateur);
            statement.setString(2, motDePasse);

            ResultSet resultSet = statement.executeQuery();

            // Si une ligne correspondante est trouvée, les informations d'identification sont correctes
            if (resultSet.next()) {
                return true;
            }

            // Fermer la connexion à la base de données
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}