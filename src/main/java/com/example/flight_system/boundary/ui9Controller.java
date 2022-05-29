package com.example.flight_system.boundary;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import com.example.flight_system.Main;
import com.example.flight_system.VO.OrderInformation;
import com.example.flight_system.VO.PaymentInformation;
import com.example.flight_system.control.MainControl;
import com.example.flight_system.control.impl.MainControlImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.MapValueFactory;

public class ui9Controller{
    private MainControl mainControl1= new MainControl();
    public MainControl getControllers() {
        return Main.controllers.get("controller");
    }
    private boolean a = false;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button helpP9;

    @FXML
    private Button next;

    @FXML
    private Button exitP9;

    @FXML
    private Label mytime;

    @FXML
    private Button back;

    @FXML
    private TableView<Map<String, Object>> Table;

    @FXML
    private TableColumn<Map, String> PaymentContent;

    @FXML
    private TableColumn<Map, String> OrderTime;

    @FXML
    private TableColumn<Map, String> Price;

    @FXML
    private TableColumn<Map, String> OrderNumber;

    @FXML
    private TableColumn<Map, Date> Date1;


    @FXML
    void ExitP9(ActionEvent event) {
        boolean a = mainControl1.exitCheckIn();
        Main.jumpTo("ui1.fxml",1280,720,"Flight System");
    }

    @FXML
    void HelpP9(ActionEvent event) {
        Main.helppage();
    }

    @FXML
    void BackP9(ActionEvent event) {

        Main.jumpTo("ui7.fxml",1280,720,"Flight System");
    }

    @FXML
    void NextP9(ActionEvent event) {
        if(a){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("CONFIRM");
            alert.setHeaderText("ATTENTION");
            alert.setContentText("You dont have extra pay, confirm to get your ticket");
            alert.show();
            Button ok = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
            ok.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Main.jumpTo("ui13.fxml",1280,720,"Flight System");
                }
            });
        }
        else {
            Main.jumpTo("ui10.fxml",1280,720,"Flight System");
        }
    }

    @FXML
    void initialize(){
        Table.setPlaceholder(new Label("no extra pay"));
        DateFormat df = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
        mytime.setText(df.format(new Date()));
        Main.showtime(mytime);
        mainControl1 = getControllers();
        System.out.println(mainControl1);
        List<PaymentInformation> table1 = mainControl1.showPayment();
        a = table1.isEmpty();
        System.out.println(table1.size());
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat dateformat1 = new SimpleDateFormat("HH:mm:ss");
        PaymentContent.setCellValueFactory(new MapValueFactory<String>("PaymentContent"));
        OrderTime.setCellValueFactory(new MapValueFactory<String>("OrderTime"));
        Price.setCellValueFactory(new MapValueFactory<String>("Price"));
        OrderNumber.setCellValueFactory(new MapValueFactory<String>("OrderNumber"));
        Date1.setCellValueFactory(new MapValueFactory<Date>("Date1"));
        ObservableList<Map<String, Object>> list = FXCollections.observableArrayList();
        for(int i=0;i<table1.size();i++){
            HashMap<String, Object> hashMap = new HashMap<>();
            String time = dateformat.format(table1.get(i).getDate());
            String time1 = dateformat1.format(table1.get(i).getDate());
            hashMap.put("PaymentContent",table1.get(i).getDetail());
            hashMap.put("OrderTime",time1);
            hashMap.put("Price",table1.get(i).getPrice());
            hashMap.put("OrderNumber",table1.get(i).getId());
            hashMap.put("Date1",time);
            list.add(hashMap);
            Table.setItems(list);
        }
        table1.clear();
    }
}
