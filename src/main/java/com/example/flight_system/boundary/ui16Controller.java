package com.example.flight_system.boundary;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ui16Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button exitP16;

    @FXML
    void ExitP16(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert exitP16 != null : "fx:id=\"exitP16\" was not injected: check your FXML file 'ui16.fxml'.";

    }
}
