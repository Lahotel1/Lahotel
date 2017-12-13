/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lahotel;

import Class.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author terkg
 */
public class ReserveController implements Initializable {

    @FXML
    private AnchorPane backpane;

    @FXML
    private DatePicker enddate;

    @FXML
    private DatePicker startdate;

    @FXML
    private Button checkavailable;

    @FXML
    private Label singleroom_text;

    @FXML
    private Label duoroom_text;

    @FXML
    private Label familyroom_text;

    @FXML
    private Label grouproom_text;

    @FXML
    private ComboBox single_selector;

    @FXML
    private ComboBox duo_selector;

    @FXML
    private ComboBox family_selector;

    @FXML
    private ComboBox group_selector;

    @FXML
    private Button confirm;

    @FXML
    private CheckBox wifi_check;

    @FXML
    private CheckBox bed_check;

    @FXML
    private TextField person;

    DataService _dataService = new DataService();
    List<List<Room>> room = new ArrayList<List<Room>>();
    List<Room> booking = new ArrayList<Room>();
    String username;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    public void setAccount(String username) {
        this.username = username;
    }

    @FXML
    void checkAvalable(ActionEvent event) {
        
        Boolean canCal = false;
        single_selector.getItems().clear();
        duo_selector.getItems().clear();
        family_selector.getItems().clear();
        group_selector.getItems().clear();
        room.clear();
        List<Room> temp = new ArrayList<Room>();
        for (Room room1 : temp) {
            System.out.println(room1.getName());
        }
        if (startdate.getValue() != null && startdate.getValue() != null) {
            if (enddate.getValue().getYear() > startdate.getValue().getYear()) {
                canCal = true;
            } else if (enddate.getValue().getYear() == startdate.getValue().getYear()) {
                if (enddate.getValue().getDayOfYear() >= startdate.getValue().getDayOfYear()) {
                    canCal = true;
                }
            }
        }
        if (canCal == true) {
            int max = 0;
            if (enddate.getValue().getMonth() == startdate.getValue().getMonth()) {
                for (int i = startdate.getValue().getDayOfMonth(); i <= enddate.getValue().getDayOfMonth(); i++) {
                    temp = _dataService.getRoomFormDay(String.valueOf(i), String.valueOf(startdate.getValue().getMonthValue()), String.valueOf(startdate.getValue().getYear()));
                    room.add(temp);
                }
            } else {

                if (startdate.getValue().getMonthValue() == 1 || startdate.getValue().getMonthValue() == 3 || startdate.getValue().getMonthValue() == 5 || startdate.getValue().getMonthValue() == 7 || startdate.getValue().getMonthValue() == 8 | startdate.getValue().getMonthValue() == 10 || startdate.getValue().getMonthValue() == 12) {
                    max = 31;
                } else if (startdate.getValue().getMonthValue() == 2) {
                    max = 28;
                } else {
                    max = 30;
                }
                for (int i = startdate.getValue().getDayOfMonth(); i <= max; i++) {
                    temp = _dataService.getRoomFormDay(String.valueOf(i), String.valueOf(startdate.getValue().getMonthValue()), String.valueOf(startdate.getValue().getYear()));
                    room.add(temp);
                }
                for (int i = 1; i <= enddate.getValue().getDayOfMonth(); i++) {
                    temp = _dataService.getRoomFormDay(String.valueOf(i), String.valueOf(enddate.getValue().getMonthValue()), String.valueOf(enddate.getValue().getYear()));
                    room.add(temp);
                }
            }

            for (int i = room.get(0).size() - 1; i >= 0; i--) {
                Boolean full = false;
                for (List<Room> list : room) {
                    if (list.get(i).getIsBook() == true) {
                        full = true;
                        break;
                    }
                }
                if (full == true) {
                    for (List<Room> list : room) {
                        list.remove(list.get(i));
                    }
                }
            }
            int single_room = 0;
            int duo_room = 0;
            int family_room = 0;
            int group_room = 0;

            for (Room room1 : room.get(0)) {
                if (room1.getName().equals("SingleRoom")) {
                    single_room++;
                } else if (room1.getName().equals("DuoRoom")) {
                    duo_room++;
                } else if (room1.getName().equals("FamilyRoom")) {
                    family_room++;
                } else {
                    group_room++;
                }
            }
            for (int i = 0; i <= single_room; i++) {
                single_selector.getItems().add(String.valueOf(i));
            }
            for (int i = 0; i <= duo_room; i++) {
                duo_selector.getItems().add(String.valueOf(i));
            }
            for (int i = 0; i <= family_room; i++) {
                family_selector.getItems().add(String.valueOf(i));
            }
            for (int i = 0; i <= group_room; i++) {
                group_selector.getItems().add(String.valueOf(i));
            }
            single_selector.getSelectionModel().selectFirst();
            duo_selector.getSelectionModel().selectFirst();
            family_selector.getSelectionModel().selectFirst();
            group_selector.getSelectionModel().selectFirst();
            singleroom_text.setText(single_room + " Rooms");
            duoroom_text.setText(duo_room + " Rooms");
            familyroom_text.setText(family_room + " Rooms");
            grouproom_text.setText(group_room + " Rooms");
        } else {
            singleroom_text.setText("");
            duoroom_text.setText("");
            familyroom_text.setText("");
            grouproom_text.setText("");
        }
    }

    public void showDialog() throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm your payment.");
        Account account = _dataService.getAccount(username);
        List<Room> temp = new ArrayList<Room>();
        for (Room room1 : booking) {
            Boolean canAdd = false;
            for (Room room2 : temp) {
                if (room1.getRoom_id().equals(room2.getRoom_id())) {
                    canAdd = true;
                    break;
                }
            }
            if(canAdd == false)
            {
             temp.add(room1);
            }
        }
        int total = 0;
        String cost ="";
        for (Room room1 : booking) {
            total += room1.getCost();
        }
        for (Room room1 : temp) {
            cost = cost.concat(String.format("Room_ID: %-5s Type : %-10s Cost : %d PERDAY\n",room1.getRoom_id(),room1.getName(),room1.getCost()));
            
        }
        cost = cost.concat(String.format("Member : %s   ",person.getText() ));
        cost = cost.concat(String.format("COST : %d", total));
        alert.setContentText(cost);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            _dataService.transactionBegin();
            for (Room room1 : booking) {
                room1.setIsBook(true);
            }
            account.addBooking(new Booking(account, booking,Integer.parseInt(person.getText()),total));
            for (Room room1 : booking) {
                account.getBooking().get(account.getBooking().size()-1).addRoom(room1);
            }
            _dataService.transactionCommit();
            success();

        }
    }

    public void confirm() throws IOException {
        booking.clear();
        if (!singleroom_text.getText().equals("") && !person.getText().equals("")) {

            for (List<Room> list : room) {
                for (int i =0 ;i<list.size()-1;i++) {
                    if (list.get(i).getName().equals("SingleRoom")) {
                        for (int j = 0; j < Integer.parseInt(single_selector.getValue()+""); j++) {
                            booking.add(list.get(j+i));
                        }
                        break;
                    }
                }
            }
            for (List<Room> list : room) {
                for (int i =0 ;i<list.size()-1;i++) {
                    if (list.get(i).getName().equals("DuoRoom")) {
                        for (int j = 0; j < Integer.parseInt(duo_selector.getValue()+""); j++) {
                            booking.add(list.get(j+i));
                        }
                        break;
                    }
                }
            }
            for (List<Room> list : room) {
                for (int i =0 ;i<list.size()-1;i++) {
                    if (list.get(i).getName().equals("FamilyRoom")) {
                        for (int j = 0; j < Integer.parseInt(family_selector.getValue()+""); j++) {
                            booking.add(list.get(j+i));
                        }
                        break;
                    }
                }
            }
            for (List<Room> list : room) {
                for (int i =0 ;i<list.size()-1;i++) {
                    if (list.get(i).getName().equals("GroupRoom")) {
                        for (int j = 0; j < Integer.parseInt(group_selector.getValue()+""); j++) {
                            booking.add(list.get(j+i));
                        }
                        break;
                    }
                }
            }
            
            if(bed_check.isSelected()==true)
            {
                for (Room room1 : booking) {
                    room1.setIsAddBed(true);
                }
            }
            if(wifi_check.isSelected()==true)
            {
                for (Room room1 : booking) {
                    room1.setIsAddWifi(true);
                }
            }
            showDialog();
        } 
    }

    @FXML
    void Back(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        HomeController controller = fxmlLoader.<HomeController>getController();
        fxmlLoader.setController(controller);
        controller.setAccount(username);
        backpane.getChildren().setAll(root);
    }
    
   
    public void success() throws IOException  {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        HomeController controller = fxmlLoader.<HomeController>getController();
        fxmlLoader.setController(controller);
        controller.setAccount(username);
        backpane.getChildren().setAll(root);
    }
}
