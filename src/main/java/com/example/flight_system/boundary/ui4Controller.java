package com.example.flight_system.boundary;

import com.example.flight_system.Main;
import com.example.flight_system.control.MainControl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ui4Controller {
    private MainControl mainControl= new MainControl();

    public void setControllers(MainControl controllers) {
        Main.controllers.put("controller",controllers);
    }

    public String BookNumber = "";

    @FXML
    private Button exit;

    @FXML
    private Button help;

    @FXML
    private Button back;

    @FXML
    private Button next;

    @FXML
    private TextField SURNAME;

    @FXML
    private TextField IDNUMBER;

    @FXML
    private Label mytime1;

    @FXML
    void gotoback(ActionEvent event) {

        Main.jumpTo("ui2.fxml",1280,720,"Flight System");
    }

    @FXML
    void gotoexit(ActionEvent event) {
        boolean a = mainControl.exitCheckIn();
        Main.jumpTo("ui1.fxml",1280,720,"Flight System");
    }

    @FXML
    void gotohelp(ActionEvent event) {
        Main.helppage();
    }

    @FXML
    void gotonext(ActionEvent event) {
        String surname = SURNAME.getText().toString();
        String idnumber = IDNUMBER.getText().toString();
        boolean ju = mainControl.loginBySurnameAndId(surname,idnumber);
        if(ju == true)
        {
            Main.controllers1.put(this.getClass().getSimpleName(), this);
            Main.jumpTo("ui5.fxml",1280,720,"wer");
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("ERROR OCCURRED");
            alert.setContentText("A WRONG ID OR SURNAME, CHECK AND TRY AGAIN");
            alert.show();
        }
    }
    public void initialize(){
        DateFormat df = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
        mytime1.setText(df.format(new Date()));
        Main.showtime(mytime1);
        setControllers(mainControl);
    }

}
