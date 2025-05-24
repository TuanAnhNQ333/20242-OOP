package hust.soict.hedspi.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.io.IOException;

public class Painter extends Application {

    private static final String FXML_FILE = "Painter.fxml";
    private static final String WINDOW_TITLE = "Painter";

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(FXML_FILE));
            Parent root = loader.load();
            primaryStage.setScene(new Scene(root));
            primaryStage.setTitle(WINDOW_TITLE);
            primaryStage.show();
        } catch (IOException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Application Error");
            alert.setContentText("Could not load FXML file: " + e.getMessage());
            alert.showAndWait();
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}