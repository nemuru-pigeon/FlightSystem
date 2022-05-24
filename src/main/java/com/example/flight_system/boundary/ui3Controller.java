package com.example.flight_system.boundary;

import com.example.flight_system.Main;
import com.example.flight_system.control.MainControl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ui3Controller {
    private MainControl mainControl= new MainControl();
    @FXML
    private Button back;

    @FXML
    private Button next;
    @FXML
    private TextField inputid;
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

    }

}
