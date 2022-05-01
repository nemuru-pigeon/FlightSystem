package com.example.flightsystem.boundary;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.flightsystem.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ui14Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button next;

    @FXML
    private Button back;

    @FXML
    void toback(ActionEvent event) {
        Main.jumpTo("ui13.fxml",1280,720,"wer");
    }

    @FXML
    void tonext(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert next != null : "fx:id=\"next\" was not injected: check your FXML file 'ui14.fxml'.";
        assert back != null : "fx:id=\"back\" was not injected: check your FXML file 'ui14.fxml'.";

    }
}
