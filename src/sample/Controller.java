package sample;

import com.jfoenix.controls.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private JFXListView reservations;

    @FXML
    private JFXTextField userName;

    @FXML
    private JFXComboBox rooms;

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

        ObservableList<String> items = loadRooms();
        rooms.setItems(items);
        reservations.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
//                String[] reservationData = loadReservation((int)reservations.getSelectionModel().getSelectedItem());
//                userName.setText(reservationData[0]);

            }
        });

    }

    private ObservableList<String> loadRooms() {

        ObservableList<String> items = FXCollections.observableArrayList();
//        Statement statement = MySqlConnector.getInstance().getNewStatement();
        ResultSet resultSet = null;
//        try {
//            resultSet = statement.executeQuery("SELECT * FROM `rr_rooms` ORDER BY `room_number` ASC");
//            while (resultSet.next()) {
//                items.add(resultSet.getString("room_number"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return items;
    }

/*    private String[] loadReservation(int reservationID) {
        Statement statement = MySqlConnector.getInstance().getNewStatement();
        String[] dataArray = new String[4];
        try {
            String sql = "";
            ResultSet resultSet = statement.executeQuery("");
            while (resultSet.next()) {
                dataArray[0] = String.valueOf(resultSet.getInt("user_id"));
                dataArray[1] = String.valueOf(resultSet.getInt("room_id"));
                dataArray[2] = String.valueOf(resultSet.getDate("start_time"));
                dataArray[3] = String.valueOf(resultSet.getDate("end_time"));
                return dataArray;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }*/

}
