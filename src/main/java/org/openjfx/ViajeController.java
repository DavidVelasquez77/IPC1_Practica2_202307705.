package org.openjfx;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

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
    private void IniciarViaje1Button(ActionEvent event) {
        moverImagen(imagemoto, btn_recargar1, 460 - 30);
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
        moverImagen(imagemoto, btn_recargar1, 0);
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
}