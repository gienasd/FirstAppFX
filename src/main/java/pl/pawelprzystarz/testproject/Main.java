package pl.pawelprzystarz.testproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("loginView.fxml"));
        primaryStage.setTitle("Lista kontaktów");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.setAlwaysOnTop(false);
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.UNIFIED);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
