package pl.pawelprzystarz.testproject.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import pl.pawelprzystarz.testproject.Models.UserSession;
import pl.pawelprzystarz.testproject.Models.dao.ContactDao;
import pl.pawelprzystarz.testproject.Models.dao.impl.ContactDaoImpl;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    ListView listContacts;

    @FXML
    Label labelName, labelNumber;

    private UserSession session = UserSession.getInstance();
    private ContactDao contactsDao = new ContactDaoImpl();

    public void initialize(URL location, ResourceBundle resources) {

    }
}
