package org.openjfx;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.Node;

public class EditarDistanciaController {
    @FXML
    private TextField idField;
    @FXML
    private TextField distanciaField;

    private PrimaryController recorridosController;

    public EditarDistanciaController() {
        
    }

    public void setRecorridosController(PrimaryController recorridosController) {
        this.recorridosController = recorridosController;
    }

    @FXML
    private void guardarCambios(ActionEvent event) {
        String id = idField.getText();
        String nuevaDistancia = distanciaField.getText();
        
        // Buscar el recorrido con el id dado y actualizar su distancia
        for (Recorrido recorrido : recorridosController.recorridos) {
            if (recorrido.getId().equals(id)) {
                recorrido.setDistancia(nuevaDistancia);
                recorridosController.actualizarTabla();
                break;
            }
        }

        // Cerrar la ventana                
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    
}