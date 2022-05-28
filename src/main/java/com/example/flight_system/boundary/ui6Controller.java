package com.example.flight_system.boundary;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import com.example.flight_system.Main;
import com.example.flight_system.VO.SeatSituation;
import com.example.flight_system.control.MainControl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class ui6Controller {
    private MainControl mainControl1= new MainControl();

    public MainControl getControllers() {
        return Main.controllers.get("controller");
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button next;

    @FXML
    private Button exit;

    @FXML
    private Button help;

    @FXML
    private Text sseat;

    @FXML
    private Button back;

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
    private AnchorPane background;

    @FXML
    private ImageView image1;

    @FXML
    private ImageView image2;

    @FXML
    private ImageView image3;

    @FXML
    private ImageView image4;

    @FXML
    private ImageView image5;

    @FXML
    private ImageView image6;

    @FXML
    private ImageView image7;

    @FXML
    private ImageView image8;

    @FXML
    private ImageView image9;

    @FXML
    private ImageView image10;

    @FXML
    private ImageView image11;

    @FXML
    private ImageView image12;

    @FXML
    void ExitP6(ActionEvent event) {

    }

    @FXML
    void HelpP6(ActionEvent event) {

    }

    @FXML
    void BackP6(ActionEvent event) {
        Main.jumpTo("ui5.fxml",1280,720,"wer");
    }

    @FXML
    void nextP6(ActionEvent event) {
        Main.jumpTo("ui7.fxml",1280,720,"wer");
    }

    @FXML
    void testaction(ActionEvent event) {
        //test.setVisible(false);

    }

    @FXML
    void initialize() {
        int[][] change;
        mainControl1 = getControllers();
        System.out.println(mainControl1);
        change=mainControl1.showSeat().getStructure();
        for(int i=0;i<=mainControl1.showSeat().getStructure()[1].length-1;i++){
            if(change[1][i]==48){
                Button scoreImageView = (Button) background.lookup("#a"+(i+1));
                scoreImageView.setVisible(false);
            }
            if(change[1][i]==49){
                Button scoreImageView = (Button) background.lookup("#a"+(i+1));
                scoreImageView.setVisible(true);
            }
            System.out.println(mainControl1.showSeat().getStructure()[1][i]);
        }
    }

    void changeImage(Image image,String type,ImageView imag1){
        switch(type){
            case "Extra":
                image=new Image("D:\\Program\\github\\Flight System\\FlightSystem\\src\\main\\resources\\com\\example\\flight_system\\images\\Extra.png");
                image1.setImage(image);
                break;
            case "Occupied":
                image=new Image("D:\\Program\\github\\Flight System\\FlightSystem\\src\\main\\resources\\com\\example\\flight_system\\images\\Occupied.png");
                image1.setImage(image);
                break;
            case "Selected":
                image=new Image("D:\\Program\\github\\Flight System\\FlightSystem\\src\\main\\resources\\com\\example\\flight_system\\images\\Selected.png");
                image1.setImage(image);
                break;
        }
    }
}
