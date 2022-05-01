package com.example.flight_system.boundary;
import com.example.flight_system.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
        import javafx.scene.control.Button;

public class ui5Controller {

    @FXML
    private Button back;

    @FXML
    private Button select;

    @FXML
    void toback(ActionEvent event) {
        Main.jumpTo("ui2.fxml",1280,720,"wer");
    }

    @FXML
    void toselect(ActionEvent event) {
        Main.jumpTo("ui6.fxml",1280,720,"wer");
    }

}
