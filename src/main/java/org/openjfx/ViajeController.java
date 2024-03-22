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
    private ImageView imagemoto;

    @FXML
private void IniciarViaje1Button(ActionEvent event) {
    TranslateTransition transition = new TranslateTransition();
    transition.setDuration(Duration.seconds(5)); // Duración de la animación
    transition.setNode(imagemoto); // Nodo a mover
    transition.setToX(460 - 30); // Movimiento en el eje X
    transition.setToY(0); // Movimiento en el eje Y
    transition.play(); // Iniciar la animación
}
}