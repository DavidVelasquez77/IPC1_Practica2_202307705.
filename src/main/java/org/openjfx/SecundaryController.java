package org.openjfx;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javafx.collections.FXCollections;

public class SecundaryController {   
    private static List<Viaje> viajes = new ArrayList<>();

    public SecundaryController(PrimaryController primaryController) {        
        
    }
    
    private ObservableList<Recorrido> recorridos = FXCollections.observableArrayList();

    @FXML
    private ComboBox<String> ComboBox_PuntoInicial;
    
    @FXML
    private ComboBox<String> ComboBox_PuntoFinal;
    
    @FXML
    private ComboBox<String> ComboBox_TipodeTransporte;

    private List<String> transportesSeleccionados = new ArrayList<>();

    

    public void setViajes(List<Viaje> viajes) {
        SecundaryController.viajes = viajes;
    }

    @FXML
    private void initialize() {
        lbl_nopilotos.setVisible(false);

        ComboBox_PuntoInicial.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                updatePuntoFinalComboBox(newSelection);
            }
        });
    }

    private void updatePuntoFinalComboBox(String puntoInicial) {
        ComboBox_PuntoFinal.getItems().clear();

        for (Recorrido recorrido : recorridos) {
            if (recorrido.getInicio().equals(puntoInicial)) {
                ComboBox_PuntoFinal.getItems().add(recorrido.getFin());
            } else if (recorrido.getFin().equals(puntoInicial)) {
                ComboBox_PuntoFinal.getItems().add(recorrido.getInicio());
            }
        }
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
            
            updateTransporteComboBox();
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

        // Añade el transporte seleccionado a la lista
        transportesSeleccionados.add(tipoTransporte);

        // Actualiza el ComboBox de transporte
        updateTransporteComboBox();

        // Crea un nuevo Viaje y añádelo a la lista
        Viaje viaje = new Viaje(
            ComboBox_PuntoInicial.getValue(),
            ComboBox_PuntoFinal.getValue(),
            tipoTransporte
        );
        viajes.add(viaje);

        // Imprime los viajes en la consola
        System.out.println("Viajes en SecundaryController: " + viajes);
    }

    private void updateTransporteComboBox() {
        List<String> transportes = Arrays.asList(
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

        ComboBox_TipodeTransporte.getItems().clear();

        for (String transporte : transportes) {
            if (!transportesSeleccionados.contains(transporte)) {
                ComboBox_TipodeTransporte.getItems().add(transporte);
            }
        }
    }

    public SecundaryController() {
        
    }

    public List<Viaje> getViajes(){
        return SecundaryController.viajes;
    }    

    public void addViaje(Viaje viaje) {
        // Añade el viaje a la lista
        SecundaryController.viajes.add(viaje);
    }
}