module com.example.memorygame {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.memorygame to javafx.fxml;
    exports com.example.memorygame;
}