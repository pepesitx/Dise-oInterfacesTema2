module com.example.tema2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires atlantafx.base;
    requires java.desktop;

    opens com.example.tema2 to javafx.fxml;
    exports com.example.tema2;
}