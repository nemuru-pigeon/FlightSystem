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

    opens com.example.flight_system to javafx.fxml;
    exports com.example.flight_system;
    exports com.example.flight_system.boundary;
    opens com.example.flight_system.boundary to javafx.fxml;
}