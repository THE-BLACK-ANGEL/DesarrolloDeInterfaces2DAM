package com.example.ejerciciowikiclase;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.scene.control.TextArea;

import java.io.*;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;


public class HelloController {
    /*Objeto de tipo boton para abrir archivo que luego lo referenciaremos con un boton en el documento fxml*/
    @FXML
    private Button openFileButton;
    @FXML
    /*Objeto Label que hara referencia al label que en el fx:id tenga el mismo nombre que este*/
    private Label LabelAbrir;
    @FXML
    // Objeto textArea que hara referencia al textArea con el mismo nombre en el fx:id
    private TextArea TextAreaAbrir;
    @FXML
    private void openFile()
    {
        //Declaramos un selector de archivo que nos permitira seleccionar un archivo y guardarlo de forma temoral en esta variable
        FileChooser fileChooser = new FileChooser();
        /*Determinamos que tipo de archivo queremos seleccionar */
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Mamahuevo (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        //Seleccionamos el archivo que queremos usar abriendo una ventana a la hora de pulsar en el boton referenciado al objeto
        File selectedFile = fileChooser.showOpenDialog(openFileButton.getScene().getWindow());
        /*Si se ha seleccionado un archivo se mostrará el nombre del archivo y en caso de que no se seleccione saldra que no se ha seleccionado ningun archivo*/
        if (selectedFile != null) {
            LabelAbrir.setText("Archivo seleccionado: " + selectedFile.getName());
            try (BufferedReader br = new BufferedReader(new FileReader(selectedFile))) {
                while (br.ready()) {
                    String line = br.readLine()+"\n";
                    TextAreaAbrir.appendText(line);

                }
            } catch (IOException ex) {
                LabelAbrir.setText("Error al abrir el archivo "+selectedFile.getName());
            }
        }
        else{
            LabelAbrir.setText("Archivo no seleccionado");
        }
    }

    @FXML
    /*Objeto de tipo boton para guardar un archivo que luego lo referenciaremos con un boton en el documento fxml*/
    private Button saveFileButton;
    @FXML
    private Label LabelGuardar;
    /*Metodo para que el boton nos despliegue la ventana para guardar el archivo donde deseemos*/
    @FXML
    private void saveFile() {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Mamayema (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        File selectedFile = fileChooser.showSaveDialog(saveFileButton.getScene().getWindow());
        if (selectedFile != null) {
            LabelGuardar.setText("Archivo guardado: " + selectedFile.getName());
        }
        else{
            LabelGuardar.setText("Archivo no guardado");
        }
    }

    @FXML
    /*Objeto de tipo boton para abrir varios archivos que luego lo referenciaremos con un boton en el documento fxml*/
    private Button openMultipleFilesButton;
    @FXML
    private Label LabelMulti;
    @FXML
    /*Metodo para que el boton nos despliegue la ventana para abrir varios archivos*/
    private void openMultipleFiles() {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        //Declaramos un arrayList en el que almacenamos los archivos que seleccionemos porque en este caso no es una seleccion unica, sino multiple
        List<File> selectedFiles = fileChooser.showOpenMultipleDialog(openMultipleFilesButton.getScene().getWindow());
        /*En caso de que haya archivos seleccionados se mostrará todos los archivos seleccionados y en caso contrario "Archivo/s no seleccionado/s"*/
        if (selectedFiles != null) {
            for (File file : selectedFiles) {
                LabelMulti.setText("Archivo/s Seleccionado/s"+file.getName());

            }
        }
        else {
            LabelMulti.setText("Archivo/s no Seleccionado/s");
        }
    }
    


}