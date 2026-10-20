package com.mycompany.ejercicio3punto2;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class PrimaryController {

    @FXML private ProgressBar barraLiebre;
    @FXML private ProgressBar barraTortuga;
    @FXML private Label lblEstadoLiebre;
    @FXML private Label lblEstadoTortuga;
    @FXML private Button btnIniciar;

    @FXML
    private void iniciarCarrera() {
        btnIniciar.setDisable(true);
        barraLiebre.setProgress(0);
        barraTortuga.setProgress(0);

        Thread tortuga = new Thread(() -> {
            Platform.runLater(() -> lblEstadoTortuga.setText("La Tortuga, Está corriendo si se puede!"));
            for (int i = 1; i <= 100; i++) {
                try { Thread.sleep(80); } catch (Exception e) {}
                final double progreso = i / 100.0;
                Platform.runLater(() -> barraTortuga.setProgress(progreso));
            }
        });

        Thread liebre = new Thread(() -> {
            Platform.runLater(() -> lblEstadoLiebre.setText("La Liebre Está corriendo"));
            for (int i = 1; i <= 100; i++) {
                if (i == 50) {
                    Platform.runLater(() -> lblEstadoLiebre.setText("La Liebre Se durmió ZZZzzz "));
                    try { Thread.sleep(6000); } catch (Exception e) {}
                    Platform.runLater(() -> lblEstadoLiebre.setText("La Liebre Está corriendo"));
                }
                try { Thread.sleep(20); } catch (Exception e) {}
                final double progreso = i / 100.0;
                Platform.runLater(() -> barraLiebre.setProgress(progreso));
            }
        });

        tortuga.start();
        liebre.start();
    }
}