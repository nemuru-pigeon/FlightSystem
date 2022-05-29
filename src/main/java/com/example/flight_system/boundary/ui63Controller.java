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

public class ui63Controller {
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
    private Button a9;

    @FXML
    private Button a10;

    @FXML
    private Button a11;

    @FXML
    private Button a12;

    @FXML
    private Button a13;

    @FXML
    private Button a14;

    @FXML
    private Button a15;

    @FXML
    private Button a16;

    @FXML
    private Button a17;

    @FXML
    private Button a18;

    @FXML
    private Button a19;

    @FXML
    private Button a20;

    @FXML
    private Button a21;

    @FXML
    private Button a22;

    @FXML
    private Button a23;

    @FXML
    private Button a24;

    @FXML
    private Button a25;

    @FXML
    private Button a26;

    @FXML
    private Button a27;

    @FXML
    private Button a28;

    @FXML
    private Button a29;

    @FXML
    private Button a30;

    @FXML
    private Button a31;

    @FXML
    private Button a32;

    @FXML
    private Button a33;

    @FXML
    private Button a34;

    @FXML
    private Button a35;

    @FXML
    private Button a36;

    @FXML
    private Button a37;

    @FXML
    private Button a38;

    @FXML
    private Button a39;

    @FXML
    private Button a40;

    @FXML
    private Button a41;

    @FXML
    private Button a42;

    @FXML
    private Button a43;

    @FXML
    private Button a44;

    @FXML
    private Button a45;

    @FXML
    private Button a46;

    @FXML
    private Button a47;

    @FXML
    private Button a48;

    @FXML
    private Button a49;

    @FXML
    private Button a50;

    @FXML
    private Button a51;

    @FXML
    private Button a52;

    @FXML
    private Button a53;

    @FXML
    private Button a54;

    @FXML
    private Button a55;

    @FXML
    private Button a56;

    @FXML
    private Button a57;

    @FXML
    private Button a58;

    @FXML
    private Button a59;

    @FXML
    private Button a60;

    @FXML
    private Button a61;

    @FXML
    private Button a62;

    @FXML
    private Button a63;

    @FXML
    private Button a64;

    @FXML
    private Button a65;

    @FXML
    private Button a66;

    @FXML
    private AnchorPane background;

    @FXML
    private Label price1;

    @FXML
    private Label flightid;

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
        for(i=0;i<66;i++){
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
        if(location<=6){
            price1.setText("Extra 5$");
        }else{
            price1.setText(" ");
        }
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
            if(location<=6){
                mainControl1.selectSeat("costlyEconomy",location);

            }else{
                mainControl1.selectSeat("economy",location-6);
            }
            Main.jumpTo("ui7.fxml",1280,720,"Flight System");
        }


    }
    public void initialize(){
        mainControl1 = getControllers();
        ui5Controller controllerx = (ui5Controller) Main.controllers1.get("ui5Controller");
        System.out.println(controllerx.row1);
        flightid.setText(controllerx.getFlight1());
        boardertime.setText(controllerx.getBorderTime1());
        des.setText(controllerx.getDestination1());
        boolean[] change = mainControl1.showSeat().getEconomy();
        boolean[] change1 = mainControl1.showSeat().getCostlyEconomy();
        for (i = 0; i<change1.length; i++){
            boolean temp = change1[i];
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
        for (i = 0; i<change.length; i++){
            boolean temp = change[i];
            Button scoreImageView = (Button) background.lookup("#a"+(i+7));
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

