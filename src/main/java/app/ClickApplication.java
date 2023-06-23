package app;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ClickApplication  extends Application {
    
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("secondary"), 600,400);
        stage.setScene(scene);
        stage.setTitle("HCI");
        stage.show();
    }

    //FXMLLoader will automatically inject values defined in the FXML documents into corresponding references in the controller class.
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ClickApplication.class.getResource("/secondary.fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}
