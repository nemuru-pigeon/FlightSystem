package com.example.flight_system.boundary;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import com.example.flight_system.Main;
import com.example.flight_system.control.MainControl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ui13Controller {
    private MainControl mainControl1= new MainControl();
    public MainControl getControllers() {
        return Main.controllers.get("controller");
    }
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button next;

    @FXML
    private Button back;

    @FXML
    private Button help;
    @FXML
    private Button exit;
    @FXML
    private Label mytime;
    @FXML
    void toback(ActionEvent event) {
        Main.jumpTo("ui11.fxml",1280,720,"Flight System");
    }
    @FXML
    void toexit(ActionEvent event) {
        boolean a = mainControl1.exitCheckIn();
        Main.jumpTo("ui1.fxml",1280,720,"Flight System");
    }
    @FXML
    void tonext(ActionEvent event) {
        Main.jumpTo("ui14.fxml",1280,720,"Flight System");
    }

    @FXML
    void helpact(ActionEvent event) {
        Main.helppage();
    }
    @FXML
    void initialize() {
        mainControl1 = getControllers();
        DateFormat df = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
        mytime.setText(df.format(new Date()));
        Main.showtime(mytime);

    }
}
