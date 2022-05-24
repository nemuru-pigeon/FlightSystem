package com.example.flight_system.boundary;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.flight_system.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ui8Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button exitP8;

    @FXML
    private Button helpP8;

    @FXML
    private Button nextP8;

    @FXML
    private Button backP8;

    @FXML
    void ExitP8(ActionEvent event) {
        Main.jumpTo("ui1.fxml",1280,720,"Flight System");
    }

    @FXML
    void HelpP8(ActionEvent event) {Main.helppage();
    }

    @FXML
    void BackP8(ActionEvent event) {
        Main.jumpTo("ui7.fxml",1280,720,"wer");
    }

    @FXML
    void NextP8(ActionEvent event) {
        Main.jumpTo("ui9.fxml",1280,720,"wer");
    }

    @FXML
    void initialize() {
        assert exitP8 != null : "fx:id=\"exitP8\" was not injected: check your FXML file 'ui8.fxml'.";
        assert helpP8 != null : "fx:id=\"helpP8\" was not injected: check your FXML file 'ui8.fxml'.";
        assert nextP8 != null : "fx:id=\"nextP8\" was not injected: check your FXML file 'ui8.fxml'.";
        assert backP8 != null : "fx:id=\"backP8\" was not injected: check your FXML file 'ui8.fxml'.";

    }
}
