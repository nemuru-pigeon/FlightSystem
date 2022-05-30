package com.example.flight_system.boundary;
import com.example.flight_system.Main;
import com.example.flight_system.VO.OrderInformation;
import com.example.flight_system.VO.PaymentInformation;
import com.example.flight_system.control.MainControl;
import com.example.flight_system.entity.Passenger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.MapValueFactory;
import org.w3c.dom.events.MouseEvent;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ui5Controller {
    private MainControl mainControl1;
    private String OrderNumber;
    private String type1;
    private String Flight1;
    private String Destination1;
    private String BorderTime1;
    Object row1 = new Object();
    DateFormat df = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
    public MainControl getControllers() {
        return Main.controllers.get("controller");
    }

    public MainControl getMainControl1() {
        return mainControl1;
    }

    public String getFlight1() {
        return Flight1;
    }

    public String getDestination1() {
        return Destination1;
    }

    public String getBorderTime1() {
        return BorderTime1;
    }

    @FXML
    private Button back;

    @FXML
    private Button select;

    @FXML
    private TableView Table1;

    @FXML
    private TableColumn IdName;

    @FXML
    private TableColumn DepartureTime;

    @FXML
    private TableColumn BoradingTime;

    @FXML
    private TableColumn FullName;

    @FXML
    private TableColumn DestinationS;

    @FXML
    private TableColumn Class;

    @FXML
    private TableColumn FlighrtNumber;

    @FXML
    private TableColumn BoolkingNumber;

    @FXML
    private TableColumn Date;

    @FXML
    private Label mytime;

    @FXML
    private Button exit;
    @FXML
    void toback(ActionEvent event) {
        Main.controllers1.clear();
        Main.jumpTo("ui2.fxml",1280,720,"wer");
    }
    @FXML
    void toexit(ActionEvent event) {
        boolean a = mainControl1.exitCheckIn();
        Main.jumpTo("ui1.fxml",1280,720,"Flight System");
    }
    @FXML
    void toselect(ActionEvent event) {
        mainControl1 = getControllers();
        System.out.println(mainControl1);
        mainControl1.selectOrder(OrderNumber);
        Main.controllers1.put(this.getClass().getSimpleName(), this);
        System.out.println(type1);
        if(type1.equals("F"))
            Main.jumpTo("ui61.fxml",1280,720,"wer");
        if(type1.equals("B"))
            Main.jumpTo("ui62.fxml",1280,720,"wer");
        if(type1.equals("E") || type1.equals("C"))
            Main.jumpTo("ui63.fxml",1280,720,"wer");
    }


    @FXML
    void initialize() {
        mytime.setText(df.format(new Date()));
        Main.showtime(mytime);
        mainControl1 = getControllers();
        System.out.println(mainControl1);
        System.out.print(Main.controllers1.keySet());
        List<OrderInformation> table1 = mainControl1.showOrders();
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat dateformat1 = new SimpleDateFormat("HH:mm:ss");
        IdName.setCellValueFactory(new MapValueFactory<String>("Id Name"));
        FullName.setCellValueFactory(new MapValueFactory<String>("Full Name"));
        DestinationS.setCellValueFactory(new MapValueFactory<String>("Destination"));
        Class.setCellValueFactory(new MapValueFactory<String>("Class"));
        FlighrtNumber.setCellValueFactory(new MapValueFactory<String>("Flight Number"));
        BoolkingNumber.setCellValueFactory(new MapValueFactory<String>("Booking Number"));
        DepartureTime.setCellValueFactory(new MapValueFactory<Date>("Departure Time"));
        BoradingTime.setCellValueFactory(new MapValueFactory<Date>("Boarding Time"));
        Date.setCellValueFactory(new MapValueFactory<Date>("Date"));
        ObservableList<Map<String, Object>> list = FXCollections.observableArrayList();
        for (int i = 0; i < table1.size(); i++) {
            HashMap<String, Object> hashMap = new HashMap<>();
            String time = dateformat.format(table1.get(i).getDate());
            String time1 = dateformat1.format(table1.get(i).getBoardingTime());
            String time2 = dateformat1.format(table1.get(i).getDepartureTime());
            hashMap.put("Id Name", table1.get(i).getPassengerId());
            hashMap.put("Full Name", table1.get(i).getPassengerName());
            hashMap.put("Destination", table1.get(i).getDestination());
            hashMap.put("Class", table1.get(i).getSeatClass());
            hashMap.put("Flight Number", table1.get(i).getFlightNo());
            hashMap.put("Booking Number", table1.get(i).getBookingNo());
            hashMap.put("Departure Time", time2);
            hashMap.put("Boarding Time", time1);
            hashMap.put("Date", time);
            list.add(hashMap);
            Table1.setItems(list);
        }
        ui3Controller controller3 = (ui3Controller) Main.controllers1.get("ui3Controller");
        System.out.println(controller3);
        for (String key:Main.controllers1.keySet()){
            System.out.println(key);
            if(key.equals("ui3Controller")){
                System.out.println("1");
                OrderNumber=controller3.BookNumber;
                System.out.println(OrderNumber);
            }
            else if(key.equals("ui4Controller")){
                Table1.setRowFactory( tv -> {
                    TableRow row = new TableRow();
                    row.setOnMouseClicked(event -> {
                        if (event.getClickCount() == 1 && (! row.isEmpty()) ) {
                            Object rowData = row.getItem();
                            String[] as=rowData.toString().split(",");
                            String num=as[1].substring(as[1].indexOf("r")+2);
                            String type=as[5].substring(as[5].indexOf("s")+3);
                            String Boarding=as[0].substring(as[0].indexOf("r")+2);
                            String Destionantion=as[2].substring(as[2].indexOf("n")+7);
                            String BoarderTime=as[7].substring(as[7].indexOf("e")+2);
                            Flight1=Boarding;
                            Destination1=Destionantion;
                            BorderTime1=BoarderTime;
                            OrderNumber=num;
                            type1=type;
                            row1 = rowData;
                            System.out.println(num);
                        }
                    });
                    return row;
                });
            }else{
                //System.out.println("nooooooooooooooooooooooooooooooo!");
            }
        }
    }

    public void HelpP15(ActionEvent actionEvent) {
        Main.helppage();
    }
}
