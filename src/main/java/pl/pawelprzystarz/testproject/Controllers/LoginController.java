package pl.pawelprzystarz.testproject.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import pl.pawelprzystarz.testproject.Models.UserSession;
import pl.pawelprzystarz.testproject.Models.Utils;
import pl.pawelprzystarz.testproject.Models.dao.UserDao;
import pl.pawelprzystarz.testproject.Models.dao.impl.UserDaoImpl;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable{

    @FXML
    TextField textLogin, textLoginR;

    @FXML
    PasswordField textPassword, textPasswordR, textPasswordRR;

    @FXML
    Button buttonLogin, buttonRegister;

    private UserSession userSession = UserSession.getInstance();
    private UserDao userDao = new UserDaoImpl();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buttonLogin.setOnMouseClicked(e -> tryLogin());
        buttonRegister.setOnMouseClicked(e -> tryRegister());

    }

    private boolean checkRegisterData(){
        String login = textLoginR.getText();
        String password = textPasswordR.getText();
        String password2 = textPasswordRR.getText();

        if (login.isEmpty() || password.isEmpty() || password2.isEmpty()) {
            Utils.createSimpleDialog("Rejestrowanie", "", "Pola nie mogą być puste!");
            return false;
        }

        if (login.length() <= 3 || password.length() <= 5){
            Utils.createSimpleDialog("Logowanie", "", "Login i hasło powinny mieć odpowiednio minimum 3 i 5 znaków");
            return false;
        }

        if (!password.equals(password2)){
            Utils.createSimpleDialog("Logowanie", "", "Obydwa hasła muszą być indentyczne!");
            return false;
        }
        return true;
    }


    private void tryRegister() {
        String login = textLoginR.getText();
        String password = textPasswordR.getText();

        if(!checkRegisterData()){
            return;
        }

        if(userDao.register(login, password)){
            Utils.createSimpleDialog("Rejestrowanie...", "", "Udało się zarejestrować!");
        }else{
            Utils.createSimpleDialog("Rejestrowanie...", "", "Błędne dane!");
        }
    }

    private boolean checkLoginData(){
        String login = textLogin.getText();
        String password = textPassword.getText();

        if (login.isEmpty() || password.isEmpty()){
            Utils.createSimpleDialog("Logowanie", "", "Pola nie mogą być puste!");
            return false;
        }

        if(login.length() <=3 || password.length() <= 5){
           Utils.createSimpleDialog("Logowanie", "", "Login i hasło powinny mieć odpowiednio minimum 3 i 5 znaków");
           return false;
        }

        return true;
    }

    private void tryLogin() {
        String login = textLogin.getText();
        String password = textPassword.getText();

        if(!checkLoginData()){
            return;
        }

        if(userDao.login(login, password)){

            userSession.setUsername(login);
            userSession.setLogedIn(true);

            Utils.createSimpleDialog("Logowanie...", "", "Udało się zalogować!");
        }else{
            Utils.createSimpleDialog("Logowanie...", "", "Masz błąd w danych!");
        }
    }
}
