package sample;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private JFXTextField userName;

    @FXML
    private JFXListView<Room> rooms;

    @FXML
    private JFXDatePicker startDate;

    @FXML
    private JFXTimePicker startTime;

    @FXML
    private JFXDatePicker endDate;

    @FXML
    private JFXTimePicker endTime;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        startTime.setIs24HourView(true);
        endTime.setIs24HourView(true);
    }



}
