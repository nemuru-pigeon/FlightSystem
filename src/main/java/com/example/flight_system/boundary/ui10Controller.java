package com.example.flight_system.boundary;
import com.example.flight_system.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
        import javafx.scene.control.Button;

public class ui10Controller {

    @FXML
    private Button back;

    @FXML
    private Button pay;

    @FXML
    void toback(ActionEvent event) {

    }

    @FXML
    void topay(ActionEvent event) {
        Main.jumpTo("ui11.fxml",1280,720,"wer");
    }

}
