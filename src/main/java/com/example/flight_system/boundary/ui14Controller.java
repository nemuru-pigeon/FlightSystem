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

public class ui14Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button next;

    @FXML
    private Button back;

    @FXML
    private Label mytime;
    @FXML
    void toback(ActionEvent event) {
        Main.jumpTo("ui13.fxml",1280,720,"Flight System");
    }

    @FXML
    void tonext(ActionEvent event) {
        Main.jumpTo("ui15.fxml",1280,720,"Flight System");
    }

    @FXML
    void initialize() {
        DateFormat df = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
        mytime.setText(df.format(new Date()));
        Main.showtime(mytime);
        assert next != null : "fx:id=\"next\" was not injected: check your FXML file 'ui14.fxml'.";
        assert back != null : "fx:id=\"back\" was not injected: check your FXML file 'ui14.fxml'.";

    }
    @FXML
    void helpact(ActionEvent actionEvent) {
        Main.helppage();
    }
}
