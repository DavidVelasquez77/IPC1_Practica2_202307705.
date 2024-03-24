package org.openjfx;

import javafx.fxml.FXML;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ViajeController {

    private List<Viaje> viajes;

    @FXML
    private Button btn_IniciarViaje1;
    @FXML
    private Button btn_IniciarViaje2;
    @FXML
    private Button btn_IniciarViaje3;
    @FXML
    private Button btn_recargar1;
    @FXML
    private Button btn_recargar2;
    @FXML
    private Button btn_recargar3;
    @FXML
    private Button btn_IniciarTodolosViajes;
    @FXML
    private HBox HBox1;
    @FXML
    private HBox HBox2;
    @FXML
    private HBox HBox3;

    @FXML
    private void IniciarViaje1Button(ActionEvent event) {
        iniciarViaje(0);
    }

    @FXML
    private void IniciarViaje2Button(ActionEvent event) {
        iniciarViaje(1);
    }

    @FXML
    private void IniciarViaje3Button(ActionEvent event) {
        iniciarViaje(2);
    }

    private void iniciarViaje(int index) {
        if (index < viajes.size()) {
            Viaje viaje = viajes.get(index);
            System.out.println("Iniciando viaje: " + viaje);
            // Aquí iría el código para iniciar el viaje
        } else {
            System.out.println("No hay viaje para iniciar");
        }
    }

    @FXML
    private void Regresar1(ActionEvent event) {
        System.out.println("Regresar 1");
    }

    @FXML
    private void Regresar2(ActionEvent event) {
        System.out.println("Regresar 2");
    }

    @FXML
    private void Regresar3(ActionEvent event) {
        System.out.println("Regresar 3");
    }

    @FXML
    private void IniciarTodolosViajesButton(ActionEvent event) {
        System.out.println("Iniciar Todos los Viajes");
    }

    public void setViajes(List<Viaje> viajes) {
        // Imprime el número de viajes que se están transfiriendo
        System.out.println("Transfiriendo " + viajes.size() + " viajes.");

        // Imprime los detalles de cada viaje
        for (Viaje viaje : viajes) {
            System.out.println(viaje);
        }

        // Asigna una imagen a cada viaje, si existe
        if (viajes.size() > 0) {
            setImageForViaje(viajes.get(0), HBox1);
        }
        if (viajes.size() > 1) {
            setImageForViaje(viajes.get(1), HBox2);
        }
        if (viajes.size() > 2) {
            setImageForViaje(viajes.get(2), HBox3);
        }

    }

    private void setImageForViaje(Viaje viaje, HBox hbox) {
        String transporte = viaje.getTransporte();
        
    
        // Determina la imagen basada en el transporte
        String imagePath;
        if (transporte.startsWith("Motocicleta")) {
            imagePath = getClass().getResource("/org/openjfx/images/moto.png").toExternalForm();
        } else if (transporte.startsWith("Vehículo estándar")) {
            imagePath = getClass().getResource("/org/openjfx/images/vehiculoestandar.png").toExternalForm();
            
        } else if (transporte.startsWith("Vehículo premium")) {
            imagePath = getClass().getResource("/org/openjfx/images/vehiculopremium.png").toExternalForm();
        } else {
            throw new IllegalArgumentException("Transporte desconocido: " + transporte);
        }
    
        // Crea una ImageView y añádela al pane
        Image image = new Image(imagePath);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(80);
        imageView.setPreserveRatio(true);
        hbox.getChildren().add(imageView);
    }
}