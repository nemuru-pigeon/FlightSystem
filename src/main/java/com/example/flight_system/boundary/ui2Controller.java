package com.example.flight_system.boundary;

import com.example.flight_system.Main;
import com.example.flight_system.control.MainControl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ui2Controller {
    private MainControl mainControl1;
    public MainControl getControllers() {
        return Main.controllers.get("controller");
    }
    DateFormat df = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
    @FXML
    private Button exit;

    @FXML
    private Button help;

    @FXML
    private Button tobooking;

    @FXML
    private Button tonameinput;
    @FXML
    private Label mytime;

    @FXML
    void jumptobookinginput(ActionEvent event) {

        Main.jumpTo("ui3.fxml",1280,720,"Flight System");
    }

    @FXML
    void jumptonameinput(ActionEvent event) {
        Main.jumpTo("ui4.fxml",1280,720,"Flight System");
    }

    @FXML
    void toexit(ActionEvent event) {
        boolean a = mainControl1.exitCheckIn();
        Main.jumpTo("ui1.fxml",1280,720,"Flight System");
    }

    @FXML
    void tohelp(ActionEvent event) {
        Main.helppage();
    }
    public void initialize(){
        mainControl1 = getControllers();
        mytime.setText(df.format(new Date()));
        Main.showtime(mytime);
    }
}

