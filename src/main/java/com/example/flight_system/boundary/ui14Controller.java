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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ui14Controller {
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
    private Label mytime;
    @FXML
    void toback(ActionEvent event) {
        Main.jumpTo("ui13.fxml",1280,720,"Flight System");
    }

    @FXML
    void tonext(ActionEvent event) {
        if (mainControl1.updateDate()) {
            Main.jumpTo("ui15.fxml",1280,720,"Flight System");
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Error occurred");
            alert.setContentText("Unable to record data, please contact service personnel.");
            alert.show();
        }
    }

    @FXML
    void initialize() {
        mainControl1 = getControllers();
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
