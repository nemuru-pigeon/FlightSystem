package com.example.flight_system.boundary;

import com.example.flight_system.Main;
import com.example.flight_system.control.MainControl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ui4Controller {
    private MainControl mainControl= new MainControl();
    @FXML
    private Button exit;

    @FXML
    private Button help;

    @FXML
    private Button back;

    @FXML
    private Button next;

    @FXML
    private TextField SURNAME;

    @FXML
    private TextField IDNUMBER;

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
        String surname = SURNAME.getText().toString();
        String idnumber = IDNUMBER.getText().toString();
        boolean ju = mainControl.loginBySurnameAndId(surname,idnumber);
        if(ju == true)
        {
            Main.jumpTo("ui5.fxml",1280,720,"wer");
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("ERROR OCCURRED");
            alert.setContentText("A WRONG ID OR SURNAME, CHECK AND TRY AGAIN");
            alert.show();
        }

    }

}
