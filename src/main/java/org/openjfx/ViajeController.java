package org.openjfx;

import javafx.fxml.FXML;

import java.util.List;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class ViajeController {

    private List<Viaje> viajes;
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;

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
    private Button btn_regresar1;
    @FXML
    private Button btn_regresar2;
    @FXML
    private Button btn_regresar3;
    @FXML
    private Button btn_IniciarTodolosViajes;
    @FXML
    private HBox HBox1;
    @FXML
    private HBox HBox2;
    @FXML
    private HBox HBox3;
    @FXML
    private Label Recorrido1;
    @FXML
    private Label Recorrido2;
    @FXML
    private Label Recorrido3;
    @FXML
    private Label Gasolina1;
    @FXML
    private Label Gasolina2;
    @FXML
    private Label Gasolina3;
    @FXML
    private Label PuntoInicial1;
    @FXML
    private Label PuntoInicial2;
    @FXML
    private Label PuntoInicial3;
    @FXML
    private Label PuntoFinal1;
    @FXML
    private Label PuntoFinal2;
    @FXML
    private Label PuntoFinal3;
    @FXML
    private Label Transporte1;
    @FXML
    private Label Transporte2;
    @FXML
    private Label Transporte3;
    @FXML
    private Label Distancia1;
    @FXML
    private Label Distancia2;
    @FXML
    private Label Distancia3;

    @FXML
    private void IniciarViaje1Button(ActionEvent event) {
        moverImagen(imageView1,btn_recargar1,Recorrido1,Gasolina1, 460 - 40);
    }

    @FXML
    private void IniciarViaje2Button(ActionEvent event) {
        moverImagen(imageView2,btn_recargar2,Recorrido2,Gasolina2, 460 - 40);
    }

    @FXML
    private void IniciarViaje3Button(ActionEvent event) {
        moverImagen(imageView3,btn_recargar3,Recorrido3, Gasolina3,460 - 40);
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
        moverImagen(imageView1,btn_recargar1,Recorrido1,Gasolina1, 0);
    }
    

    @FXML
    private void Regresar2(ActionEvent event) {
        moverImagen(imageView2,btn_recargar2,Recorrido2,Gasolina2, 0);
    }

    @FXML
    private void Regresar3(ActionEvent event) {
        moverImagen(imageView3,btn_recargar3,Recorrido3, Gasolina3,0);
    }

    @FXML
    private void IniciarTodolosViajesButton(ActionEvent event) {
        moverImagen(imageView1,btn_recargar1,Recorrido1,Gasolina1, 460 - 40);
        moverImagen(imageView2,btn_recargar2,Recorrido2,Gasolina2, 460 - 40);
        moverImagen(imageView3,btn_recargar3,Recorrido3, Gasolina3,460 - 40);
    }

    public void setViajes(List<Viaje> viajes) {
        this.viajes = viajes;
        // Imprime el número de viajes que se están transfiriendo
        System.out.println("Transfiriendo " + viajes.size() + " viajes.");

        // Imprime los detalles de cada viaje
        for (Viaje viaje : viajes) {
            System.out.println(viaje);
        }

        // Asigna una imagen a cada viaje, si existe
        if (viajes.size() > 0) {
            imageView1 = setImageForViaje(viajes.get(0), HBox1);
        }
        if (viajes.size() > 1) {
            imageView2 = setImageForViaje(viajes.get(1), HBox2);
        }
        if (viajes.size() > 2) {
            imageView3 = setImageForViaje(viajes.get(2), HBox3);
        }
        actualizarPuntosIniciales();
        actualizarPuntosFinales();
        actualizarTransporte();

    }

    private ImageView setImageForViaje(Viaje viaje, HBox hbox) {
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

        return imageView;
    }

    public void actualizarPuntosIniciales(){
        Label[] puntosIniciales = {PuntoInicial1, PuntoInicial2, PuntoInicial3};
        for (int i = 0; i < viajes.size() & i < puntosIniciales.length; i++) {
            String puntoInicial = viajes.get(i).getPuntoInicial();  
            puntosIniciales[i].setText(puntoInicial);
        }
    }
    public void actualizarPuntosFinales(){
        Label[] puntosFinales = {PuntoFinal1, PuntoFinal2, PuntoFinal3};
        for (int i = 0; i < viajes.size() & i < puntosFinales.length; i++) {
            String puntoFinal = viajes.get(i).getPuntoFinal();  
            puntosFinales[i].setText(puntoFinal);
        }
    }
    public void actualizarTransporte(){
        Label[] transporte = {Transporte1, Transporte2, Transporte3};
        for (int i = 0; i < viajes.size() & i < transporte.length; i++) {
            String tipotransporte = viajes.get(i).getTransporte();  
            transporte[i].setText(tipotransporte);
        }
    }
    public void actualizarDistancia(){
        Label[] distancia = {Distancia1, Distancia2, Distancia3};   

        }
    

    
    private void moverImagen(ImageView imagen,Button boton, Label label, Label label2,  int posicionX) {
        TranslateTransition transitionImagen = new TranslateTransition();
        transitionImagen.setDuration(Duration.seconds(5)); // Duración de la animación
        transitionImagen.setNode(imagen); // Nodo a mover
        transitionImagen.setToX(posicionX); // Movimiento en el eje X
        transitionImagen.setToY(0); // Movimiento en el eje Y

        // Voltea la imagen si está regresando
        if (posicionX == 0) {
            imagen.setScaleX(-1);
        } else {
            imagen.setScaleX(1);
        }

        transitionImagen.play(); // Iniciar la animación

        // Mover el botón junto con la imagen
        TranslateTransition transitionBoton = new TranslateTransition();
        transitionBoton.setDuration(Duration.seconds(5)); // Duración de la animación
        transitionBoton.setNode(boton); // Nodo a mover
        transitionBoton.setToX(posicionX); // Movimiento en el eje X
        transitionBoton.setToY(0); // Movimiento en el eje Y
        transitionBoton.play(); // Iniciar la animación

        TranslateTransition transitionLabel = new TranslateTransition();
        transitionLabel.setDuration(Duration.seconds(5)); // Duración de la animación
        transitionLabel.setNode(label); // Nodo a mover
        transitionLabel.setToX(posicionX); // Movimiento en el eje X
        transitionLabel.setToY(0); // Movimiento en el eje Y
        transitionLabel.play(); // Iniciar la animación

        TranslateTransition transitionLabel2 = new TranslateTransition();
        transitionLabel2.setDuration(Duration.seconds(5)); // Duración de la animación
        transitionLabel2.setNode(label2); // Nodo a mover
        transitionLabel2.setToX(posicionX); // Movimiento en el eje X
        transitionLabel2.setToY(0); // Movimiento en el eje Y
        transitionLabel2.play(); // Iniciar la animación
    }


    
}