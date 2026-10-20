package com.mycompany.ejercicio3punto1;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML private TextField txtNumero;
    @FXML private Button btnContar;
    @FXML private Button btnEsperar;
    @FXML private ProgressBar prgTiempo;

    private int contador = 0;

    @FXML
    private void btnContar_click() {
        contador++;
        txtNumero.setText(String.valueOf(contador));
    }

    @FXML
    private void btnEsperar_click() {
        btnEsperar.setDisable(true); 
        prgTiempo.setProgress(0);

        Thread hilo = new Thread(() -> {
            for (int i = 1; i <= 100; i++) {
                try {
                    Thread.sleep(100); 
                } catch (InterruptedException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                
                final double progreso = i / 100.0;
               
                Platform.runLater(() -> prgTiempo.setProgress(progreso));
            }
            
            Platform.runLater(() -> btnEsperar.setDisable(false));
        });
        
        hilo.start();
    }
}