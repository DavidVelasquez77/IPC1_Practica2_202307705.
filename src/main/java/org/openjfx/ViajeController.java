package org.openjfx;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import java.util.List;
import java.util.ArrayList;

public class ViajeController {

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
    private ImageView imagemoto;
    @FXML
    private ImageView imagemoto2;
    @FXML
    private ImageView imagemoto3;
    @FXML
    private ImageView imagecarroestandar;
    @FXML
    private ImageView imagecarroestandar2;
    @FXML
    private ImageView imagecarroestandar3;
    @FXML
    private ImageView imagecarropremium;
    @FXML
    private ImageView imagecarropremium2;
    @FXML
    private ImageView imagecarropremium3;
    
    

    @FXML
    private void IniciarViaje1Button(ActionEvent event) {
        List<String> tiposTransporte = Transporte.getTipos();
        String ultimoTipoTransporte = tiposTransporte.get(tiposTransporte.size() - 1);


        switch (ultimoTipoTransporte) {
            case "Motocicleta 1":
            case "Motocicleta 2":
            case "Motocicleta 3":
                // Muestra y mueve la imagen correspondiente
                imagemoto.setVisible(true);
                moverImagen(imagemoto, btn_recargar1, 460 - 30);
                break;
            case "Vehículo estándar 1":
            case "Vehículo estándar 2":
            case "Vehículo estándar 3":
                // Muestra y mueve la imagen correspondiente
                imagecarroestandar.setVisible(true);
                moverImagen(imagecarroestandar, btn_recargar1, 460 - 30);
                break;
            case "Vehículo premium 1":
            case "Vehículo premium 2":
            case "Vehículo premium 3":
                // Muestra y mueve la imagen correspondiente
                imagecarropremium.setVisible(true);
                moverImagen(imagecarropremium, btn_recargar1, 460 - 30);
                break;
        }
    }
    @FXML
    private void IniciarViaje2Button(ActionEvent event) {
        moverImagen(imagemoto2, btn_recargar2, 460 - 30);
    }

    @FXML
    private void IniciarViaje3Button(ActionEvent event) {
        moverImagen(imagemoto3, btn_recargar3, 460 - 30);
    }

    @FXML
    private void IniciarTodolosViajesButton(ActionEvent event) {
        moverImagen(imagemoto, btn_recargar1, 460 - 30);
        moverImagen(imagemoto2, btn_recargar2, 460 - 30);
        moverImagen(imagemoto3, btn_recargar3, 460 - 30);
    }

    @FXML
    private void Regresar1(ActionEvent event) {
        List<String> tiposTransporte = Transporte.getTipos();
        String ultimoTipoTransporte = tiposTransporte.get(tiposTransporte.size() - 1);

        switch (ultimoTipoTransporte) {
            case "Motocicleta 1":
            case "Motocicleta 2":
            case "Motocicleta 3":
                moverImagen(imagemoto, btn_recargar1, 0);
                break;
            case "Vehículo estándar 1":
            case "Vehículo estándar 2":
            case "Vehículo estándar 3":
                moverImagen(imagecarroestandar, btn_recargar1, 0);
                break;
            case "Vehículo premium 1":
            case "Vehículo premium 2":
            case "Vehículo premium 3":
                moverImagen(imagecarropremium, btn_recargar1, 0);
                break;
        }
    }
    @FXML
    private void Regresar2(ActionEvent event) {
        moverImagen(imagemoto2, btn_recargar2, 0);
    }

    @FXML
    private void Regresar3(ActionEvent event) {
        moverImagen(imagemoto3, btn_recargar3, 0);
    }

    private void moverImagen(ImageView imagen, Button boton, int posicionX) {
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
    }

    @FXML
    public void initialize() {
        // Oculta todas las imágenes al inicio
        imagemoto.setVisible(false);
        imagecarroestandar.setVisible(false);
        imagecarropremium.setVisible(false);
    }


}