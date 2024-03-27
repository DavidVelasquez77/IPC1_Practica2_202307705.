package org.openjfx;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        // Carga el archivo FXML para SecundaryController
        FXMLLoader secundaryLoader = new FXMLLoader(getClass().getResource("/org/openjfx/secundary.fxml"));
        Parent secundaryRoot = secundaryLoader.load();
        
        // Obtiene la instancia de SecundaryController
        SecundaryController secundaryController = secundaryLoader.getController();

        // Carga el archivo FXML para PrimaryController
        FXMLLoader primaryLoader = new FXMLLoader(getClass().getResource("/org/openjfx/primary.fxml"));
        Parent primaryRoot = primaryLoader.load();
        
        // Obtiene la instancia de PrimaryController
        PrimaryController primaryController = primaryLoader.getController();
        
        // Establece secundaryController en primaryController
        primaryController.setSecundaryController(secundaryController);

        // Configura la escena con el root de PrimaryController
        scene = new Scene(primaryRoot);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}