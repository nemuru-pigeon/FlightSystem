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

public class ui8Controller {
    private MainControl mainControl= new MainControl();
    private boolean chose = false;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button exitP8;

    @FXML
    private Button helpP8;

    @FXML
    private Button nextP8;

    @FXML
    private Button backP8;
    @FXML
    private Button sushi;

    @FXML
    private Button beefsteak;

    @FXML
    private Label mytime;
    @FXML
    private Button spaghtti;

    @FXML
    private Button hamburger;

    @FXML
    private Button chinesefood;

    @FXML
    private Button icecream;
    @FXML
    private Label name;

    @FXML
    private Label price;
    @FXML
    void ExitP8(ActionEvent event) {

        Main.jumpTo("ui1.fxml",1280,720,"Flight System");
    }

    @FXML
    void HelpP8(ActionEvent event) {Main.helppage();
    }

    @FXML
    void BackP8(ActionEvent event) {
        Main.jumpTo("ui7.fxml",1280,720,"Flight System");
    }

    @FXML
    void NextP8(ActionEvent event) {
        if(chose)
        {
            Main.jumpTo("ui9.fxml",1280,720,"wer");
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("ERROR OCCURRED");
            alert.setContentText("YOU MUST CHOSE ONE KIND OF MEAL");
            alert.show();
        }
    }
    @FXML
    void beefsteakact(ActionEvent event) {
        chose = mainControl.selectMeal("7");
        name.setText("Beefsteak");
        price.setText("25");
    }

    @FXML
    void chinesefoodact(ActionEvent event) {
        chose = mainControl.selectMeal("10");
        name.setText("Chinese food");
        price.setText("15");
    }

    @FXML
    void hamburgeract(ActionEvent event) {
        chose = mainControl.selectMeal("9");
        name.setText("Hamburger");
        price.setText("20");
    }

    @FXML
    void icecreamact(ActionEvent event) {
        chose = mainControl.selectMeal("5");
        name.setText("Ice cream");
        price.setText("10");
    }

    @FXML
    void spaghttiact(ActionEvent event) {
        chose = mainControl.selectMeal("8");
        name.setText("Spaghetti");
        price.setText("20");
    }

    @FXML
    void sushiact(ActionEvent event) {
        chose = mainControl.selectMeal("6");
        name.setText("Sushi");
        price.setText("30");
    }
    @FXML
    void initialize() {
            DateFormat df = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
            mytime.setText(df.format(new Date()));
            Main.showtime(mytime);
        assert exitP8 != null : "fx:id=\"exitP8\" was not injected: check your FXML file 'ui8.fxml'.";
        assert helpP8 != null : "fx:id=\"helpP8\" was not injected: check your FXML file 'ui8.fxml'.";
        assert nextP8 != null : "fx:id=\"nextP8\" was not injected: check your FXML file 'ui8.fxml'.";
        assert backP8 != null : "fx:id=\"backP8\" was not injected: check your FXML file 'ui8.fxml'.";

    }
}
