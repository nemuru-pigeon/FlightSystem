package com.example.flightsystem.boundary;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.flightsystem.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class ui6Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button next;

    @FXML
    private Button exit;

    @FXML
    private Button help;

    @FXML
    private Text sseat;

    @FXML
    private Button back;

    @FXML
    void ExitP6(ActionEvent event) {

    }

    @FXML
    void HelpP6(ActionEvent event) {

    }

    @FXML
    void BackP6(ActionEvent event) {
        Main.jumpTo("ui5.fxml",1280,720,"wer");
    }

    @FXML
    void nextP6(ActionEvent event) {
        Main.jumpTo("ui7.fxml",1280,720,"wer");
    }

    @FXML
    void initialize() {
        assert next != null : "fx:id=\"next\" was not injected: check your FXML file 'ui6.fxml'.";
        assert exit != null : "fx:id=\"exit\" was not injected: check your FXML file 'ui6.fxml'.";
        assert help != null : "fx:id=\"help\" was not injected: check your FXML file 'ui6.fxml'.";
        assert sseat != null : "fx:id=\"sseat\" was not injected: check your FXML file 'ui6.fxml'.";
        assert back != null : "fx:id=\"back\" was not injected: check your FXML file 'ui6.fxml'.";

    }
}
