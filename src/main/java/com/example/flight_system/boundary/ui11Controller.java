package com.example.flight_system.boundary;


import com.example.flight_system.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ui11Controller {

    @FXML
    private Button exit;

    @FXML
    private Button next;

    @FXML
    private Button help11;
    @FXML
    private Label mytime;

    @FXML
    void toexit(ActionEvent event) {

    }
    @FXML
    void help11page(ActionEvent event) {
        Main.helppage();
    }
    @FXML
    void tonext(ActionEvent event) {
        Main.jumpTo("ui13.fxml",1280,720,"Flight System");
    }

    public void initialize(){
        DateFormat df = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
        mytime.setText(df.format(new Date()));
        Main.showtime(mytime);
    }
}
