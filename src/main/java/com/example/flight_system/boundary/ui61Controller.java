package com.example.flight_system.boundary;

import com.example.flight_system.Main;
import com.example.flight_system.control.MainControl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ui61Controller {
    private MainControl mainControl1;
    public MainControl getControllers() {
        return Main.controllers.get("controller");
    }
    int i =0;
    int location =0;
    @FXML
    private Button exit;

    @FXML
    private Button help;

    @FXML
    private Button back;

    @FXML
    private Button next;

    @FXML
    private Text sseat;

    @FXML
    private Button a1;

    @FXML
    private Button a2;

    @FXML
    private Button a3;

    @FXML
    private Button a4;

    @FXML
    private Button a5;

    @FXML
    private Button a6;

    @FXML
    private Button a7;

    @FXML
    private Button a8;

    @FXML
    private AnchorPane background;

    @FXML
    private Label flighid;

    @FXML
    private Label des;

    @FXML
    private Label boardertime;
    @FXML
    void BackP6(ActionEvent event) {
        boolean a = mainControl1.exitCheckIn();
        Main.jumpTo("ui5.fxml",1280,720,"Flight System");
    }

    @FXML
    void ExitP6(ActionEvent event) {
        boolean a = mainControl1.exitCheckIn();
        Main.jumpTo("ui1.fxml",1280,720,"Flight System");
    }

    @FXML
    void HelpP6(ActionEvent event) {
        Main.helppage();
    }

    @FXML
    void chose(ActionEvent event) {
        location =0;
        for(i=0;i<8;i++){
            Button scoreImageView = (Button) background.lookup("#a"+(i+1));
            scoreImageView.setStyle("-fx-background-color:#464646;");
        }
        Button btn = (Button) event.getSource();
        String id = btn.getId();
        btn.setStyle("-fx-background-color:red;");
        String regEx="[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(id);
        String s;
        System.out.println( s = m.replaceAll("").trim());
        location = Integer.parseInt(s);
        System.out.println(location);

    }

    @FXML
    void nextP6(ActionEvent event) {
        if(location == 0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("ERROR OCCURRED");
                alert.setContentText("YOU MUST CHOSE ONE SEAT");
            alert.show();
        }
        else {
            mainControl1.selectSeat("first",location);
            Main.jumpTo("ui7.fxml",1280,720,"Flight System");
        }


    }
    public void initialize(){
        mainControl1 = getControllers();
        ui5Controller controllerx = (ui5Controller) Main.controllers1.get("ui5Controller");
        flighid.setText(controllerx.getFlight1());
        boardertime.setText(controllerx.getBorderTime1());
        des.setText(controllerx.getDestination1());
        System.out.println(controllerx.row1);
        boolean[] change = mainControl1.showSeat().getFirst();
        for (i = 0; i<change.length; i++){
            boolean temp = change[i];
            Button scoreImageView = (Button) background.lookup("#a"+(i+1));
            if(temp){
                scoreImageView.setStyle("-fx-background-color:#464646;");
                scoreImageView.setDisable(true);
            }
            else {
                scoreImageView.setStyle("-fx-background-color:#FCF9EC;");
                scoreImageView.setDisable(false);
            }
        }
    }

}
