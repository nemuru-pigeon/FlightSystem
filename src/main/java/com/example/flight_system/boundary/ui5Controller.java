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
        import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;
import org.w3c.dom.events.MouseEvent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ui5Controller {
    private MainControl mainControl1;
    private String OrderNumber;

    public MainControl getControllers() {
        return Main.controllers.get("controller");
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
    void toback(ActionEvent event) {
        Main.jumpTo("ui2.fxml",1280,720,"wer");
    }

    @FXML
    void toselect(ActionEvent event) {
        mainControl1 = getControllers();
        System.out.println(mainControl1);
        mainControl1.selectOrder(OrderNumber);
        Main.jumpTo("ui6.fxml",1280,720,"wer");
    }


    @FXML
    void initialize() {
        mainControl1 = getControllers();
        System.out.println(mainControl1);
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

        Table1.setRowFactory( tv -> {
            TableRow row = new TableRow();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    Object rowData = row.getItem();
                    String[] as=rowData.toString().split(",");
                    String num=as[1].substring(as[1].indexOf("r")+2);
                    OrderNumber=num;
                    System.out.println(num);
                }
            });
            return row ;
        });
    }
}
