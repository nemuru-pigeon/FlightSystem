package com.example.flight_system.boundary;

import com.example.flight_system.Main;
import com.example.flight_system.VO.PaymentInformation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ui12Controller {

                @FXML
                private Button exit;

                @FXML
                private Button help;

                @FXML
                private Button back;

                @FXML
                private Label mytime;
                @FXML
                void back(ActionEvent event) {
                        Main.jumpTo("ui10.fxml",1280,720,"Flight System");
                }

                @FXML
                void exitact(ActionEvent event) {

                }

                @FXML
                void helpact(ActionEvent event) {
                        Main.helppage();
                }

        public void initialize(){


                DateFormat df = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
                mytime.setText(df.format(new Date()));
                Main.showtime(mytime);
        }
}
