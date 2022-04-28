package com.example.flightsystem.boundary;

import com.example.flightsystem.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ui4Controller {

    @FXML
    private Button exit;

    @FXML
    private Button help;

    @FXML
    private Button back;

    @FXML
    private Button next;

    @FXML
    void gotoback(ActionEvent event) {
        Main.jumpTo("ui2.fxml",1280,720,"wer");
    }

    @FXML
    void gotoexit(ActionEvent event) {

    }

    @FXML
    void gotohelp(ActionEvent event) {

    }

    @FXML
    void gotonext(ActionEvent event) {
        Main.jumpTo("ui5.fxml",1280,720,"wer");
    }

}
