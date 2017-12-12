/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lahotel;

import Class.*;
import java.awt.Button;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author terkg
 */
public class HistoryController implements Initializable {
       
    
    private TableView<Booking> table = new TableView<Booking>();
    private ObservableList<Booking> data;
    private DataService _dataService = new DataService();
    
     @FXML
    private VBox vbox;
     
       @FXML
    private AnchorPane backpane;
      
    String username;

     @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//          List<Booking> report = _dataService.getAllBooking();
//        System.out.println(report);
//        data = FXCollections.observableArrayList(report);

        
        TableColumn idCol = new TableColumn("ID");
        idCol.setMinWidth(45);
        idCol.setCellValueFactory(
                new PropertyValueFactory<Booking, String>("id"));

        TableColumn nameCol = new TableColumn("Name");
        nameCol.setMinWidth(315);
        nameCol.setCellValueFactory(
                new PropertyValueFactory<Booking, String>("name"));

        TableColumn roomtypeCol = new TableColumn("Roomtype");
        roomtypeCol.setMinWidth(175);
        roomtypeCol.setCellValueFactory(
                new PropertyValueFactory<Booking, String>("roomtype"));

        TableColumn startdateCol = new TableColumn("Startdate");
        startdateCol.setMinWidth(165);
        startdateCol.setCellValueFactory(
                new PropertyValueFactory<Booking, String>("startdate"));
        
        TableColumn enddateCOl = new TableColumn("Enddate");
        enddateCOl.setMinWidth(165);
        enddateCOl.setCellValueFactory(
                new PropertyValueFactory<Booking, String>("enddate"));
        
          
        TableColumn isBedCol = new TableColumn("AddBed");
        isBedCol.setMinWidth(20);
        isBedCol.setCellValueFactory(
                new PropertyValueFactory<Booking, String>("isBed"));
        
        TableColumn isWifiCol = new TableColumn("Wifi");
        isWifiCol.setMinWidth(20);
        isWifiCol.setCellValueFactory(
                new PropertyValueFactory<Booking, String>("isWifi"));
           
        TableColumn statusCol = new TableColumn("Status");
        statusCol.setMinWidth(20);
        statusCol.setCellValueFactory(
                new PropertyValueFactory<Booking, String>("status"));
           
        TableColumn isCheckinCol = new TableColumn("Checkin");
        isCheckinCol.setMinWidth(20);
        isCheckinCol.setCellValueFactory(
                new PropertyValueFactory<Booking, String>("isCheckin"));

        table.setItems(data);
        table.getColumns().addAll(idCol,nameCol,roomtypeCol,startdateCol,enddateCOl,isBedCol,isWifiCol,statusCol,isCheckinCol);

        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll( table);
        
    }
     @FXML
    void Mainmenu(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        HomeController controller = fxmlLoader.<HomeController>getController();
        fxmlLoader.setController(controller);
        controller.getAccount(username);
        backpane.getChildren().setAll(root);
    }
    
    public void setAccount(String username){
        this.username=username;
    }
}