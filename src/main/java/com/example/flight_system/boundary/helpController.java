package com.example.flight_system.boundary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class helpController {

    @FXML
    private Button OK;

    @FXML
    void OkAction(ActionEvent event) {
        Stage stage = (Stage)OK.getScene().getWindow();
        stage.close();
    }

}