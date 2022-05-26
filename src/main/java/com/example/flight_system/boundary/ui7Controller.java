package com.example.flight_system.boundary;

import java.net.URL;
import java.util.ResourceBundle;
import com.example.flight_system.Main;
import com.example.flight_system.control.MainControl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class ui7Controller {
    private MainControl mainControl= new MainControl();
    @FXML
    private ResourceBundle resources;
    private boolean chose = false;
    @FXML
    private URL location;

    @FXML
    private Button exitp7;

    @FXML
    private Button standard;

    @FXML
    private Button vegetarin;

    @FXML
    private Button helpp7;

    @FXML
    private Button menup7;

    @FXML
    private Button nextp7;

    @FXML
    private Button halal;

    @FXML
    private Button xxx;

    @FXML
    private Button backp7;

    @FXML
    void ExitP7(ActionEvent event) {
        Main.jumpTo("ui1.fxml",1280,720,"Flight System");
    }

    @FXML
    void HelpP7(ActionEvent event) {
        Main.helppage();
    }

    @FXML
    void BackP7(ActionEvent event) {
        Main.jumpTo("ui6.fxml",1280,720,"Flight System");
    }

    @FXML
    void NextP7(ActionEvent event) {
        if(chose)
        {
            Main.jumpTo("ui9.fxml",1280,720,"wer");
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("ERROR OCCURRED");
            alert.setContentText("YOU MUST CHOSE ONE KIND OF MEAL OR CHOSE FROM OTHER PAGE");
            alert.show();
        }
    }

    @FXML
    void menuP7(ActionEvent event) {
        Main.jumpTo("ui8.fxml",1280,720,"Flight System");
    }

    @FXML
    void StandardP7(ActionEvent event) {
        chose = mainControl.selectMeal("1");
    }

    @FXML
    void VegetarinP7(ActionEvent event) {
        chose = mainControl.selectMeal("2");
    }

    @FXML
    void HalalP7(ActionEvent event) {
        chose = mainControl.selectMeal("3");
    }

    @FXML
    void XxxP7(ActionEvent event) {
        chose = mainControl.selectMeal("4");
    }

    @FXML
    void initialize() {
        assert exitp7 != null : "fx:id=\"exitp7\" was not injected: check your FXML file 'ui7.fxml'.";
        assert standard != null : "fx:id=\"standard\" was not injected: check your FXML file 'ui7.fxml'.";
        assert vegetarin != null : "fx:id=\"vegetarin\" was not injected: check your FXML file 'ui7.fxml'.";
        assert helpp7 != null : "fx:id=\"helpp7\" was not injected: check your FXML file 'ui7.fxml'.";
        assert menup7 != null : "fx:id=\"menup7\" was not injected: check your FXML file 'ui7.fxml'.";
        assert nextp7 != null : "fx:id=\"nextp7\" was not injected: check your FXML file 'ui7.fxml'.";
        assert halal != null : "fx:id=\"halal\" was not injected: check your FXML file 'ui7.fxml'.";
        assert xxx != null : "fx:id=\"xxx\" was not injected: check your FXML file 'ui7.fxml'.";
        assert backp7 != null : "fx:id=\"backp7\" was not injected: check your FXML file 'ui7.fxml'.";

    }
}
