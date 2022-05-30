package com.example.flight_system.boundary;

import com.example.flight_system.Main;
import com.example.flight_system.control.MainControl;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ui3Controller{
    private MainControl mainControl= new MainControl();
    DateFormat df = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
    public String BookNumber = "";

    public void setControllers(MainControl controllers) {
        Main.controllers.put("controller",controllers);
    }

    @FXML
    private Button back;

    @FXML
    private Button next;

    @FXML
    private TextField inputid;

    @FXML
    private Button help;

    @FXML
    private Label mytime;

    @FXML
    private Label check;

    @FXML
    private Button exit;

    @FXML
    void showhelp(ActionEvent event) {
        Main.helppage();
    }
    @FXML
    void toback(ActionEvent event) {
            Main.jumpTo("ui2.fxml",1280,720,"Flight System");
    }

    @FXML
    void tonext(ActionEvent event) {
        String bookingnum = inputid.getText().toString();
        boolean ju = mainControl.loginByBookingNo(bookingnum);
        if(bookingnum.length() == 10 && bookingnum.matches("[0-9]+")){
            if(ju)
            {
                BookNumber=inputid.getText().toString();
                System.out.println("successful"+BookNumber);
                Main.controllers1.put(this.getClass().getSimpleName(), this);
                Main.jumpTo("ui5.fxml",1280,720,"Flight System");
            }
            else{
                check.setText("CHECK!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText("ERROR OCCURRED");
                alert.setContentText("A WRONG ID, CHECK AND TRY AGAIN");
                alert.show();
            }
        }
        else{
            check.setText("WRONG FORMAT");
        }
    }

    @FXML
    void toexit(ActionEvent event) {
        boolean a = mainControl.exitCheckIn();
        Main.jumpTo("ui1.fxml",1280,720,"Flight System");
    }
    public void initialize(){
        mytime.setText(df.format(new Date()));
        Main.showtime(mytime);
        setControllers(mainControl);
    }
}
