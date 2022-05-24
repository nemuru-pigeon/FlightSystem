package com.example.flight_system.boundary;


import com.example.flight_system.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ui11Controller {

    @FXML
    private Button exit;

    @FXML
    private Button next;

    @FXML
    private Button help11;

    @FXML
    void toexit(ActionEvent event) {

    }
    @FXML
    void help11page(ActionEvent event) {
        Main.helppage();
    }
    @FXML
    void tonext(ActionEvent event) {
        Main.jumpTo("ui13.fxml",1280,720,"Flight System");
    }

}
