package com.example.flight_system.boundary;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import com.example.flight_system.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ui15Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button helpP15;
    @FXML
    private Label mytime;
    @FXML
    void HelpP15(ActionEvent event) {
        Main.helppage();
    }

    @FXML
    void initialize() {
        DateFormat df = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
        mytime.setText(df.format(new Date()));
        Main.showtime(mytime);
        assert helpP15 != null : "fx:id=\"helpP15\" was not injected: check your FXML file 'ui15.fxml'.";

    }
}
