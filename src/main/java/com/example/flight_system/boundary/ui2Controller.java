package com.example.flight_system.boundary;

import com.example.flight_system.Main;
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

        Main.jumpTo("ui3.fxml",1280,720,"Flight System");
    }

    @FXML
    void jumptonameinput(ActionEvent event) {
        Main.jumpTo("ui4.fxml",1280,720,"Flight System");
    }

    @FXML
    void toexit(ActionEvent event) {
        Main.jumpTo("ui1.fxml",1280,720,"Flight System");
    }

    @FXML
    void tohelp(ActionEvent event) {

    }

}

