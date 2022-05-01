package com.example.flight_system.boundary;

import com.example.flight_system.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ui3Controller {

    @FXML
    private Button back;

    @FXML
    private Button next;

    @FXML
    void toback(ActionEvent event) {
        Main.jumpTo("ui2.fxml",1280,720,"wer");
    }

    @FXML
    void tonext(ActionEvent event) {
        Main.jumpTo("ui5.fxml",1280,720,"wer");
    }

}
