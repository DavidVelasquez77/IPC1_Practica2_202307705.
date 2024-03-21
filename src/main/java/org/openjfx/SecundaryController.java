package org.openjfx;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.util.HashSet;
import javafx.beans.property.SimpleStringProperty;
import java.util.Set;
import javafx.collections.FXCollections;

public class SecundaryController {
    
    private ObservableList<Recorrido> recorridos = FXCollections.observableArrayList();

    @FXML
    private ComboBox<String> ComboBox_PuntoInicial;
    
    @FXML
    private ComboBox<String> ComboBox_PuntoFinal;
    
    @FXML
    private ComboBox<String> ComboBox_TipodeTransporte;

    @FXML
    private void initialize() {
        lbl_nopilotos.setVisible(false);
    }
    
    public void setRecorridos(ObservableList<Recorrido> recorridos) {
        if (recorridos != null) {
            this.recorridos = recorridos;
            
            Set<String> puntos = new HashSet<>();
            for (Recorrido recorrido : recorridos) {
                puntos.add(recorrido.getInicio());
                puntos.add(recorrido.getFin());
            }
            ComboBox_PuntoInicial.getItems().addAll(puntos);
            ComboBox_PuntoFinal.getItems().addAll(puntos);
            
            ComboBox_TipodeTransporte.getItems().addAll(
                "Motocicleta 1",
                "Motocicleta 2",
                "Motocicleta 3",
                "Vehículo estándar 1",
                "Vehículo estándar 2",
                "Vehículo estándar 3",
                "Vehículo premium 1",
                "Vehículo premium 2",
                "Vehículo premium 3"
            );
        } else {
            // Opción 1: Lanzar una excepción
            throw new IllegalArgumentException("Recorridos no puede ser null");
        }
    }

    private int contadorViajes = 0;
    @FXML
    private Button btn_generarviaje;
    @FXML
    private Label lbl_nopilotos;

    @FXML
    private void GenerarButton(ActionEvent event) {
        String puntoInicial = ComboBox_PuntoInicial.getValue();
        String puntoFinal = ComboBox_PuntoFinal.getValue();
        String tipoTransporte = ComboBox_TipodeTransporte.getValue();

        System.out.println("Punto inicial: " + puntoInicial);
        System.out.println("Punto final: " + puntoFinal);
        System.out.println("Tipo de transporte: " + tipoTransporte);

        // Incrementar el contador de viajes
        contadorViajes++;

        // Verificar si se han generado 3 viajes
        if (contadorViajes >= 3) {
            // Deshabilitar el botón y mostrar el label
            btn_generarviaje.setDisable(true);
            lbl_nopilotos.setVisible(true);
        }

        // El resto de tu código...
    }
}