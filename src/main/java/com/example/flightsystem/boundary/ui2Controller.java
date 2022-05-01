package com.example.flightsystem.boundary;

import com.example.flightsystem.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ui2Controller {

    @FXML
    private Button exit;

    @FXML
    private Button help;

    @FXML
    private Button tobooking;

    @FXML
    private Button tonameinput;

    @FXML
    void jumptobookinginput(ActionEvent event) {
        Main.jumpTo("ui3.fxml",1280,720,"wer");
    }

    @FXML
    void jumptonameinput(ActionEvent event) {
        Main.jumpTo("ui4.fxml",1280,720,"wer");
    }

    @FXML
    void toexit(ActionEvent event) {

    }

    @FXML
    void tohelp(ActionEvent event) {

    }

}

