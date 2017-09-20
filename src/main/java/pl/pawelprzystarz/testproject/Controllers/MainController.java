package pl.pawelprzystarz.testproject.Controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import pl.pawelprzystarz.testproject.Models.MySqlConnector;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    // dorobić widok logowania login / hasło i odpowiednia tabela
    // Podgląd kontaktów w mainView i dodawanie nowych kontaktów


    public void initialize(URL location, ResourceBundle resources) {
        MySqlConnector.getInstance();
    }

}
