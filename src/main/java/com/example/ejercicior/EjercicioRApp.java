package com.example.ejercicior;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Clase principal para iniciar la aplicación de JavaFX.
 * Carga el archivo FXML y configura la escena principal.
 */
public class EjercicioRApp extends Application {

    /**
     * Metodo de inicio de la aplicación JavaFX.
     * Carga el archivo FXML, configura la escena y muestra la ventana principal.
     *
     * @param stage La ventana principal de la aplicación.
     * @throws IOException si el archivo FXML no se encuentra o no se puede cargar.
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(EjercicioRApp.class.getResource("ejercicioR.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Formulario!");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Metodo principal que lanza la aplicación JavaFX.
     *
     * @param args Argumentos de línea de comandos (no se utilizan en esta aplicación).
     */
    public static void main(String[] args) {
        launch();
    }
}
