package org.openjfx;

import javafx.fxml.FXML;

import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
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
    private Label LabelRecorrido1;
    @FXML
    private Label LabelRecorrido2;
    @FXML
    private Label LabelRecorrido3;
    @FXML
    private Label LabelGasolina1;
    @FXML
    private Label LabelGasolina2;
    @FXML
    private Label LabelGasolina3;


    @FXML
    private void IniciarViaje1Button(ActionEvent event) {
        moverImagen(imageView1, btn_recargar1,LabelRecorrido1, Recorrido1, LabelGasolina1, Gasolina1, Distancia1, 460 - 40, viajes.get(0));
    }
    @FXML
    private void IniciarViaje2Button(ActionEvent event) {
        moverImagen(imageView2, btn_recargar2, LabelRecorrido2, Recorrido2, LabelGasolina2, Gasolina2, Distancia2, 460 - 40, viajes.get(1));
    }

    @FXML
    private void IniciarViaje3Button(ActionEvent event) {
        moverImagen(imageView3, btn_recargar3, LabelRecorrido3, Recorrido3, LabelGasolina3, Gasolina3, Distancia3, 460 - 40, viajes.get(2));
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
        moverImagen(imageView1, btn_recargar1, LabelRecorrido1, Recorrido1, LabelGasolina1, Gasolina1, Distancia1, 0, viajes.get(0));
    }

    @FXML
    private void Regresar2(ActionEvent event) {
        moverImagen(imageView2, btn_recargar2, LabelRecorrido2, Recorrido2, LabelGasolina2, Gasolina2, Distancia2, 0, viajes.get(1));
    }

    @FXML
    private void Regresar3(ActionEvent event) {
        moverImagen(imageView3, btn_recargar3, LabelRecorrido3, Recorrido3, LabelGasolina3, Gasolina3, Distancia3, 0, viajes.get(2));
    }

    @FXML
    private void IniciarTodolosViajesButton(ActionEvent event) {
        moverImagen(imageView1, btn_recargar1,LabelRecorrido1, Recorrido1, LabelGasolina1, Gasolina1, Distancia1, 460 - 40, viajes.get(0));
        moverImagen(imageView2, btn_recargar2, LabelRecorrido2, Recorrido2, LabelGasolina2, Gasolina2, Distancia2, 460 - 40, viajes.get(1));
        moverImagen(imageView3, btn_recargar3, LabelRecorrido3, Recorrido3, LabelGasolina3, Gasolina3, Distancia3, 460 - 40, viajes.get(2));
    }

    @FXML
    private void Recargar1Button(ActionEvent event) {
        System.out.println("Recargando gasolina para el viaje 1");
    }
    @FXML
    private void Recargar2Button(ActionEvent event) {
        System.out.println("Recargando gasolina para el viaje 2");
    }
    @FXML
    private void Recargar3Button(ActionEvent event) {
      System.out.println("Recargando gasolina para el viaje 3");
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

        // Asegúrate de que actualizarDistancia() se ejecute después de que se hayan actualizado los puntos iniciales y finales
        Platform.runLater(() -> actualizarDistancia());
    }

    

    private ImageView setImageForViaje(Viaje viaje, HBox hbox) {
        String transporte = viaje.getTransporte();
        
    
        // Determina la imagen basada en el transporte
        String imagePath;
        if (transporte.startsWith("Motocicleta")) {
            imagePath = getClass().getResource("/org/openjfx/images/moto.png").toExternalForm();
            viaje.setCapacidadGasolina(6.0);
            viaje.setConsumoGasolina(0.1);
        } else if (transporte.startsWith("Vehículo estándar")) {
            imagePath = getClass().getResource("/org/openjfx/images/vehiculoestandar.png").toExternalForm();
            viaje.setCapacidadGasolina(10.0);
            viaje.setConsumoGasolina(0.3);
        } else if (transporte.startsWith("Vehículo premium")) {
            imagePath = getClass().getResource("/org/openjfx/images/vehiculopremium.png").toExternalForm();
            viaje.setCapacidadGasolina(12.0);
            viaje.setConsumoGasolina(0.45);
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

    private PrimaryController primaryController;

    public void setPrimaryController(PrimaryController primaryController) {
        this.primaryController = primaryController;
    }

    public void actualizarDistancia() {
        Label[][] puntos = {
            {PuntoInicial1, PuntoFinal1, Distancia1},
            {PuntoInicial2, PuntoFinal2, Distancia2},
            {PuntoInicial3, PuntoFinal3, Distancia3}
        };

        for (Label[] punto : puntos) {
            String puntoInicial = punto[0].getText();
            String puntoFinal = punto[1].getText();

            System.out.println("Punto inicial: " + puntoInicial);
            System.out.println("Punto final: " + puntoFinal);

            boolean coincidenciaEncontrada = false;

            // Busca el recorrido que coincide con los puntos inicial y final
            for (Recorrido recorrido : primaryController.getRecorridos()) {
                if ((recorrido.getInicio().equals(puntoInicial) && recorrido.getFin().equals(puntoFinal)) ||
                    (recorrido.getInicio().equals(puntoFinal) && recorrido.getFin().equals(puntoInicial))) {
                    // Si encuentra una coincidencia, establece la distancia en el label correspondiente
                    System.out.println("Distancia antes de establecerla: " + punto[2].getText());
                    punto[2].setText(recorrido.getDistancia());
                    System.out.println("Distancia después de establecerla: " + punto[2].getText());
                    coincidenciaEncontrada = true;
                    break;
                }
            }

            if (!coincidenciaEncontrada) {
                System.out.println("No se encontró ninguna coincidencia para los puntos inicial y final: " + puntoInicial + ", " + puntoFinal);
            }
        }
    }
    private double recorridoTotal1 = 0;
private double recorridoTotal2 = 0;
private double recorridoTotal3 = 0;
    private void moverImagen(ImageView imagen, Button boton,Label labelrecorrido, Label recorrido, Label labelgasolina,Label gasolina, Label distancia, int posicionX, Viaje viaje) {
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

    // Mover el labelrecorrido junto con la imagen
    TranslateTransition transitionlabelrecorrido = new TranslateTransition();
    transitionlabelrecorrido.setDuration(Duration.seconds(5)); // Duración de la animación
    transitionlabelrecorrido.setNode(labelrecorrido); // Nodo a mover
    transitionlabelrecorrido.setToX(posicionX); // Movimiento en el eje X
    transitionlabelrecorrido.setToY(0); // Movimiento en el eje Y
    transitionlabelrecorrido.play(); // Iniciar la animación

    TranslateTransition transitionrecorrido = new TranslateTransition();
    transitionrecorrido.setDuration(Duration.seconds(5)); // Duración de la animación
    transitionrecorrido.setNode( recorrido); // Nodo a mover
    transitionrecorrido.setToX(posicionX); // Movimiento en el eje X
    transitionrecorrido.setToY(0); // Movimiento en el eje Y
    transitionrecorrido.play(); // Iniciar la animación

        // Mover el labelrecorrido junto con la imagen
        TranslateTransition transitionlabelgasolina = new TranslateTransition();
        transitionlabelgasolina.setDuration(Duration.seconds(5)); // Duración de la animación
        transitionlabelgasolina.setNode(labelgasolina); // Nodo a mover
        transitionlabelgasolina.setToX(posicionX); // Movimiento en el eje X
        transitionlabelgasolina.setToY(0); // Movimiento en el eje Y
        transitionlabelgasolina.play(); // Iniciar la animación
    
        TranslateTransition transitiongasolina = new TranslateTransition();
        transitiongasolina.setDuration(Duration.seconds(5)); // Duración de la animación
        transitiongasolina.setNode( gasolina); // Nodo a mover
        transitiongasolina.setToX(posicionX); // Movimiento en el eje X
        transitiongasolina.setToY(0); // Movimiento en el eje Y
        transitiongasolina.play(); // Iniciar la animación
    
// Actualizar el recorrido a medida que la imagen se mueve
Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.1), event -> {
    double progress = Math.abs(imagen.getTranslateX()) / 420; // 420 es la distancia total que se mueve la imagen
    double totalDistancia = Double.parseDouble(distancia.getText());
    double recorridoActual = progress * totalDistancia; // No redondear hacia arriba

    // Solo actualizar el recorrido si la imagen no está en la posición inicial
    if (posicionX != 0) {
        recorrido.setText(String.format("%.2f", recorridoActual));
    }

    // Actualizar recorridoTotal con la distancia recorrida
    if (imagen == imageView1) {
        recorridoTotal1 += 8.5730 * totalDistancia / 420;
        Recorrido1.setText(String.format("%.2f", recorridoTotal1));
    } else if (imagen == imageView2) {
        recorridoTotal2 += 8.5730 * totalDistancia / 420;
        Recorrido2.setText(String.format("%.2f", recorridoTotal2));
    } else if (imagen == imageView3) {
        recorridoTotal3 += 8.5730 * totalDistancia / 420;
        Recorrido3.setText(String.format("%.2f", recorridoTotal3));
    }
}));
    timeline.setCycleCount(Timeline.INDEFINITE);
    timeline.play();

    // Actualizar la gasolina a medida que la imagen se mueve
    Timeline timelineGasolina = new Timeline(new KeyFrame(Duration.seconds(0.1), event -> {
        double progress = Math.abs(imagen.getTranslateX()) / 420; // 420 es la distancia total que se mueve la imagen
        double totalGasolina = viaje.getCapacidadGasolina();
        double consumoGasolina = viaje.getConsumoGasolina();
        double gasolinaConsumida = progress * consumoGasolina;
        double gasolinaActual = totalGasolina - gasolinaConsumida;
        gasolina.setText(String.format("%.2f", gasolinaActual));
    }));
    timelineGasolina.setCycleCount(Timeline.INDEFINITE);
    timelineGasolina.play();

    transitionImagen.setOnFinished(event -> {
        timeline.stop();
        timelineGasolina.stop();
    });
    
}
}