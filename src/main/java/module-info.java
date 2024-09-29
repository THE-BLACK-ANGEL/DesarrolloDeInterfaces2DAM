module com.example.ejerciciowikiclase {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.ejerciciowikiclase to javafx.fxml;
    exports com.example.ejerciciowikiclase;
}