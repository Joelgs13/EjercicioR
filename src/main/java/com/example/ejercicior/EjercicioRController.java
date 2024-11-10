package com.example.ejercicior;

import com.example.ejercicioq.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class EjercicioRController implements Initializable {

    @FXML // fx:id="temporizador"
    private Temp temporizador;

    @FXML
    private Button btEnviar;

    @FXML
    private Button btEnviar2;

    @FXML
    void enviar(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (temporizador.setTiempo(90)) {
            temporizador.iniciar(); // Inicia el temporizador
            temporizador.finProperty().addListener(new ChangeListener<Object>() {
                @Override
                public void changed(ObservableValue<? extends Object> arg0, Object arg1, Object arg2) {
                    //código con las instrucciones a realizar
                    deshabilitarBotones();
                }
            });
        } else {
            deshabilitarBotones();
            showAlert("No se ha podido iniciar el temporizador");
        }
    }

    public void deshabilitarBotones() {
        btEnviar.setDisable(true);
        btEnviar2.setDisable(true);
    }

    public void showAlert(String texto) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setHeaderText(null);
        alerta.setTitle("Error");
        alerta.setContentText(texto);
        alerta.showAndWait();
    }
}
