package com.example.flight_system.boundary;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import com.example.flight_system.Main;
import com.example.flight_system.control.MainControl;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;


public class ui15Controller {
    private MainControl mainControl1= new MainControl();
    public MainControl getControllers() {
        return Main.controllers.get("controller");
    }

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
        mainControl1 = getControllers();
        DateFormat df = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
        mytime.setText(df.format(new Date()));
        Main.showtime(mytime);
        EventHandler<ActionEvent> eventHandler = e -> {
            Main.jumpTo("ui16.fxml",1280,720,"Flight System");
        };

        if (mainControl1.print()) {
            Timeline animation = new Timeline(new KeyFrame(Duration.millis(3000), eventHandler));
            animation.play();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Error occurred");
            alert.setContentText("Unable to print, please contact service personnel.");
            alert.show();
        }
    }
}