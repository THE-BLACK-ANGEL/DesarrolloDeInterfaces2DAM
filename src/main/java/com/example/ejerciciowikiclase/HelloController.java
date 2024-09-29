package com.example.ejerciciowikiclase;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;

import java.awt.event.ActionEvent;
import java.io.File;
import java.util.List;


public class HelloController {
    /*Objeto de tipo boton para abrir archivo que luego lo referenciaremos con un boton en el documento fxml*/
    @FXML
    private Button openFileButton;
    @FXML
    /*Metodo para que el boton nos despliegue la ventana para abrir el archivo que selecciones*/
    private void openFile(javafx.event.ActionEvent event)
    {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        File selectedFile = fileChooser.showOpenDialog(openFileButton.getScene().getWindow());
        if (selectedFile != null) {
            System.out.println("Archivo seleccionado: " + selectedFile.getAbsolutePath());
        }
    }

    @FXML
    /*Objeto de tipo boton para guardar un archivo que luego lo referenciaremos con un boton en el documento fxml*/
    private Button saveFileButton;

    @FXML
    /*Metodo para que el boton nos despliegue la ventana para guardar el archivo donde deseemos*/
    private void saveFile(javafx.event.ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        File selectedFile = fileChooser.showSaveDialog(saveFileButton.getScene().getWindow());
        if (selectedFile != null) {
            System.out.println("Archivo seleccionado: " + selectedFile.getAbsolutePath());
        }
    }

    @FXML
    /*Objeto de tipo boton para abrir varios archivos que luego lo referenciaremos con un boton en el documento fxml*/
    private Button openMultipleFilesButton;

    @FXML
    /*Metodo para que el boton nos despliegue la ventana para abrir varios archivos*/
    private void openMultipleFiles(javafx.event.ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        List<File> selectedFiles = fileChooser.showOpenMultipleDialog(openMultipleFilesButton.getScene().getWindow());
        if (selectedFiles != null) {
            for (File file : selectedFiles) {
                System.out.println("Archivo seleccionado: " + file.getAbsolutePath());
            }
        }
    }


}