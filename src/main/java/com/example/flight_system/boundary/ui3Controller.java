package com.example.flight_system.boundary;

import com.example.flight_system.Main;
import com.example.flight_system.control.MainControl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ui3Controller {
    private MainControl mainControl= new MainControl();
    @FXML
    private Button back;

    @FXML
    private Button next;

    @FXML
    private TextField inputid;

    @FXML
    private Button help;

    @FXML
    void showhelp(ActionEvent event) {
        Main.helppage();
    }
    @FXML
    void toback(ActionEvent event) {
            Main.jumpTo("ui2.fxml",1280,720,"wer");
    }

    @FXML
    void tonext(ActionEvent event) {
        String bookingnum = inputid.getText().toString();
        boolean ju = mainControl.loginByBookingNo(bookingnum);
        System.out.println(ju);
        if(ju == true)
        {
            Main.jumpTo("ui5.fxml",1280,720,"wer");
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("ERROR OCCURRED");
            alert.setContentText("A WRONG ID, CHECK AND TRY AGAIN");
            alert.show();
        }

    }

}
