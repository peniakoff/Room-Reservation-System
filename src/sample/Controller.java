package sample;

import com.jfoenix.controls.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.input.MouseEvent;
import javafx.util.StringConverter;

import java.net.URL;
import java.sql.Connection;
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
    private JFXComboBox<Room> rooms;

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

        ObservableList<Room> items = loadRooms();
        rooms.setItems(items);

        rooms.setCellFactory((JFXComboBox) -> {
            return new ListCell<Room>() {
                @Override
                protected void updateItem(Room item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setText(null);
                    } else {
                        setText(item.getRoom_number());
                    }
                }
            };
        });

        rooms.setConverter(new StringConverter<Room>() {
            @Override
            public String toString(Room object) {
                if (object == null) {
                    return null;
                } else  {
                    return object.getRoom_number();
                }
            }

            @Override
            public Room fromString(String string) {
                return null;
            }
        });

//        reservations.setOnMouseClicked((event) -> {
//            loadReservation((int)reservations.getSelectionModel().getSelectedItem());
//        });

    }

    private ObservableList<Room> loadRooms() {
        ObservableList<Room> items = FXCollections.observableArrayList();
        Statement statement = MySqlConnector.getInstance().getNewStatement();
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery("SELECT * FROM `rr_rooms` ORDER BY `room_number` ASC");
            while (resultSet.next()) {
                items.add(new Room(
                        resultSet.getInt("id"),
                        resultSet.getString("room_number"),
                        resultSet.getInt("room_seats"),
                        resultSet.getInt("type")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    private void loadReservation(int reservationID) {
        Statement statement = MySqlConnector.getInstance().getNewStatement();
        try {
            String sql = "SELECT * FROM `rr_reservation` WHERE `id`='" + reservationID + "' LIMIT 1";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                userName.setText(String.valueOf(resultSet.getInt("user_id")));
//                rooms.getSelectionModel().select();
//                dataArray[2] = String.valueOf(resultSet.getDate("start_time"));
//                dataArray[3] = String.valueOf(resultSet.getDate("end_time"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
