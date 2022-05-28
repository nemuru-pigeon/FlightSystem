package com.example.flight_system.boundary;
import com.example.flight_system.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
        import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ui10Controller {

    @FXML
    private Button back;

    @FXML
    private Button pay;

    @FXML
    private Label mytime;
    @FXML
    void toback(ActionEvent event) {

    }

    @FXML
    void topay(ActionEvent event) {
        Main.jumpTo("ui11.fxml",1280,720,"Flight System");
    }

    public void initialize(){
        DateFormat df = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
        mytime.setText(df.format(new Date()));
        Main.showtime(mytime);
    }
}
