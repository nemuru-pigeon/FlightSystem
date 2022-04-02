module com.example.flightsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens com.example.flightsystem to javafx.fxml;
    exports com.example.flightsystem;
    exports com.example.flightsystem.boundary;
    opens com.example.flightsystem.boundary to javafx.fxml;
}