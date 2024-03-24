package org.openjfx;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.stage.FileChooser;




public class PrimaryController implements Initializable {
    @FXML
    private SecundaryController secundaryController;

    public void setSecundaryController(SecundaryController secundaryController) {
        this.secundaryController = secundaryController;
    }

    public PrimaryController() {
        
    }

    @FXML
    private Button btn_RutasenCurso;
    @FXML
    private void RutasenCursoButtton(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/openjfx/Viaje.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            
            // Obtén una instancia del controlador ViajeController
            ViajeController viajeController = fxmlLoader.getController();
            
            // Obtén los viajes de SecundaryController
            List<Viaje> viajes = secundaryController.getViajes();

            // Imprime los viajes en la consola
            System.out.println("Viajes en PrimaryController: " + viajes);
            
            // Pasa los viajes a ViajeController
            viajeController.setViajes(viajes);
            
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
            stage.setScene(scene);  
            stage.show();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

//------------------------------------ GENERAR UN VIAJE ------------------------------------------------------------------
    @FXML
    private Button btn_GenerarViaje;
@FXML
private void GenerarViajeButton(ActionEvent event) {
    try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/openjfx/secundary.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        SecundaryController secundaryController = fxmlLoader.getController();
        secundaryController.setRecorridos(recorridos);
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);  
        stage.show();
    } catch(IOException e) {
        e.printStackTrace();
    }
}


//------------------------------------ HISTORIAL ------------------------------------------------------------------

    @FXML
    private Button btn_historial;

    @FXML
    private void historialButton(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/openjfx/historial.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
            stage.setScene(scene);  
            stage.show();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
//------------------------------------ CARGAR RUTAS ------------------------------------------------------------------
@FXML
private Button btn_CargarRutas;

@FXML
    private void handleButtonAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV files", "*.csv"));
        File file = fileChooser.showOpenDialog(null);  
        if (file != null) {
            rutaArchivo = file.getPath();
            loadTableData(file);
        }
    }

    @FXML
    public TableView<Recorrido> tbl_Recorridos;

    @FXML
    private TableColumn<Recorrido, String> idColumna;

    @FXML
    public ObservableList<Recorrido> recorridos;    

    @FXML
    private TableColumn<Recorrido, String> inicioColumna;

    @FXML
    private TableColumn<Recorrido, String> finColumna;

    @FXML
    private TableColumn<Recorrido, String> distanciaColumna;
    
    private String rutaArchivo;

    @FXML
    private void loadTableData(File file) {
        recorridos = FXCollections.observableArrayList();
        try (CSVReader reader = new CSVReader(new FileReader(file))) {
            reader.readNext(); // Ignora la primera línea
            
            String[] line;
            int contador = 1;
            while ((line = reader.readNext()) != null) {
                String id = String.format("%03d", contador++);                    
                recorridos.add(new Recorrido(id, line[0], line[1], line[2]));
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error al cargar los datos");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
        idColumna.setCellValueFactory(new PropertyValueFactory<>("id"));
        inicioColumna.setCellValueFactory(new PropertyValueFactory<>("inicio"));
        finColumna.setCellValueFactory(new PropertyValueFactory<>("fin"));
        distanciaColumna.setCellValueFactory(new PropertyValueFactory<>("distancia"));  
        
        // Paso 4: Asigna la ObservableList a la tabla
        tbl_Recorridos.setItems(recorridos);
    }

    public void actualizarTabla(){
        tbl_Recorridos.refresh();
    }

    public void actualizarDistanciaEnCSV(String id, String nuevaDistancia) {
        Path path = Paths.get(rutaArchivo);
        List<String[]> lineas = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(rutaArchivo))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                if (nextLine[0].equals(id)) {
                    nextLine[2] = nuevaDistancia;
                    // Actualizar la distancia en la lista recorridos
                    for (Recorrido recorrido : recorridos) {
                        if (recorrido.getId().equals(id)) {
                            recorrido.setDistancia(nuevaDistancia);
                            break;
                        }
                    }
                }
                lineas.add(nextLine);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    
        try (CSVWriter writer = new CSVWriter(new FileWriter(rutaArchivo))) {
            writer.writeAll(lineas);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Button btn_EditarDistancias;

    @FXML
    private void handleEditarDistancia(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/openjfx/editarDistancias.fxml"));
            Parent root = loader.load();
            EditarDistanciaController controller = loader.getController();
            controller.setRecorridosController(this);
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
            stage.setScene(scene); // establece la escena solo una vez
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        recorridos = FXCollections.observableArrayList();
    }
}