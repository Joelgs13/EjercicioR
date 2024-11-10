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

/**
 * Controlador para la interfaz de usuario de EjercicioR.
 * Maneja eventos de los botones y gestiona un temporizador.
 */
public class EjercicioRController implements Initializable {

    @FXML
    private Temp temporizador;

    @FXML
    private Button btEnviar;

    @FXML
    private Button btEnviar2;

    /**
     * Acción ejecutada al presionar el botón "Enviar".
     * Detiene el temporizador, deshabilita los botones y muestra una confirmación.
     *
     * @param event el evento de acción del botón
     */
    @FXML
    void enviar(ActionEvent event) {
        temporizador.detener();
        deshabilitarBotones();
        mostrarConfirmacion("Formulario completado exitosamente");
    }

    /**
     * Inicializa el controlador después de cargar sus elementos FXML.
     *
     * @param url URL para la ubicación del FXML (puede ser nulo si no se requiere).
     * @param resourceBundle Recursos asociados a la localización (puede ser nulo si no se requiere).
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        configurarTemporizador(90);
    }

    /**
     * Configura el temporizador con el tiempo especificado y establece un listener
     * para manejar la finalización del tiempo.
     *
     * @param tiempo el tiempo en segundos para configurar el temporizador
     */
    private void configurarTemporizador(int tiempo) {
        if (temporizador.setTiempo(tiempo)) {
            iniciarTemporizador();
            configurarListenerFin();
        } else {
            manejarErrorDeInicio();
        }
    }

    /**
     * Inicia el temporizador.
     */
    private void iniciarTemporizador() {
        temporizador.iniciar();
    }

    /**
     * Configura un listener para la propiedad de finalización del temporizador,
     * que deshabilita los botones y muestra una alerta al completar el tiempo.
     */
    private void configurarListenerFin() {
        temporizador.finProperty().addListener((observable, oldValue, newValue) -> {
            deshabilitarBotones();
            mostrarAlerta("El tiempo ha finalizado automáticamente");
        });
    }

    /**
     * Maneja el error de inicio del temporizador. Deshabilita los botones
     * y muestra una alerta de error.
     */
    private void manejarErrorDeInicio() {
        deshabilitarBotones();
        mostrarAlerta("Error al iniciar el temporizador");
    }

    /**
     * Deshabilita los botones de la interfaz, impidiendo más interacciones.
     */
    public void deshabilitarBotones() {
        btEnviar.setDisable(true);
        btEnviar2.setDisable(true);
    }

    /**
     * Muestra una alerta de error con el mensaje especificado.
     *
     * @param mensaje el mensaje de error a mostrar en la alerta
     */
    public void mostrarAlerta(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Error");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    /**
     * Muestra una alerta de confirmación con el mensaje especificado.
     *
     * @param mensaje el mensaje de confirmación a mostrar en la alerta
     */
    public void mostrarConfirmacion(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Confirmación");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
