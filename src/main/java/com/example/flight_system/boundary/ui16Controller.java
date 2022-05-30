package com.example.flight_system.boundary;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.flight_system.Main;
import com.example.flight_system.control.MainControl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ui16Controller {
    private MainControl mainControl1= new MainControl();
    public MainControl getControllers() {
        return Main.controllers.get("controller");
    }
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button exitP16;

    @FXML
    void ExitP16(ActionEvent event) {
        Main.jumpTo("ui1.fxml",1280,720,"Flight System");
    }

    @FXML
    void initialize() {
        mainControl1 = getControllers();
        //assert exitP16 != null : "fx:id=\"exitP16\" was not injected: check your FXML file 'ui16.fxml'.";

    }
}
