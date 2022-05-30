package com.example.flight_system.boundary;
import com.example.flight_system.Main;
import com.example.flight_system.VO.PaymentInformation;
import com.example.flight_system.control.MainControl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
        import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ui10Controller {
    private float price = 0;
    private MainControl mainControl1= new MainControl();
    public MainControl getControllers() {
        return Main.controllers.get("controller");
    }
    @FXML
    private Button back;

    @FXML
    private Button pay;

    @FXML
    private Button exit;

    @FXML
    private Button help;
    @FXML
    private TextField card;

    @FXML
    private TextField pass;

    @FXML
    private Label mytime;

    @FXML
    private Label checkcard;

    @FXML
    private Label checkvcc2;
    @FXML
    void toback(ActionEvent event) {
        Main.jumpTo("ui9.fxml",1280,720,"Flight System");
    }
    @FXML
    void toexit(ActionEvent event) {
        boolean a = mainControl1.exitCheckIn();
        Main.jumpTo("ui1.fxml",1280,720,"Flight System");
    }

    @FXML
    void tohelp(ActionEvent event) {
        Main.helppage();
    }
    @FXML
    void topay(ActionEvent event) {
        String Card = card.getText().toString();
        String Pass = pass.getText().toString();
        int pass = 1;
        if(Card.length()>=13 && Card.length()<=19 && Card.matches("[0-9]+")){
            checkcard.setText("");
        }
        else{
            pass = 0;
            checkcard.setText("THIS LENGTH SHOULD BE 12");
        }
        if(Pass.length() == 3 && Pass.matches("[0-9]+")){
            checkvcc2.setText("");
        }
        else {
            pass = 0;
            checkvcc2.setText("THIS LENGTH SHOULD BE 3");
        }
        if(pass == 1)
        {
            int Pass1;
            Pass1 = Integer.parseInt(Pass);
            System.out.println(Pass1);
            mainControl1.pay(Card,Pass1,price);
            Main.jumpTo("ui11.fxml",1280,720,"Flight System");
        }
    }

    public void initialize(){
        mainControl1 = getControllers();
        System.out.println(mainControl1);
        List<PaymentInformation> table1 = mainControl1.showPayment();
        price = table1.get(0).getPrice();
        DateFormat df = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
        mytime.setText(df.format(new Date()));
        Main.showtime(mytime);
    }
}
