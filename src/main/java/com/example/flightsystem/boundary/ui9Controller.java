package com.example.flightsystem.boundary;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.flightsystem.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ui9Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button helpP9;

    @FXML
    private Button next;

    @FXML
    private Button exitP9;

    @FXML
    private Button back;

    @FXML
    void ExitP9(ActionEvent event) {

    }

    @FXML
    void HelpP9(ActionEvent event) {

    }

    @FXML
    void BackP9(ActionEvent event) {
        Main.jumpTo("ui7.fxml",1280,720,"wer");
    }

    @FXML
    void NextP9(ActionEvent event) {
        Main.jumpTo("ui10.fxml",1280,720,"wer");
    }

    @FXML
    void initialize() {
        assert helpP9 != null : "fx:id=\"helpP9\" was not injected: check your FXML file 'ui9.fxml'.";
        assert next != null : "fx:id=\"next\" was not injected: check your FXML file 'ui9.fxml'.";
        assert exitP9 != null : "fx:id=\"exitP9\" was not injected: check your FXML file 'ui9.fxml'.";
        assert back != null : "fx:id=\"back\" was not injected: check your FXML file 'ui9.fxml'.";

    }
}
