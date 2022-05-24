package com.example.flight_system.boundary;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import com.example.flight_system.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ui1Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button test;

    @FXML
    void teston(ActionEvent event) {

        Main.jumpTo("ui2.fxml",1280,720,"Flight System");
    }
}
