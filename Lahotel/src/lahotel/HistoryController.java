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
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
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

    private String username;
    @FXML
    private VBox vbox;

    @FXML
    private AnchorPane backpane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    public void show(String username) {
        Account account = _dataService.getAccount(username);
        List<Booking> report = account.getBooking();
        data = FXCollections.observableArrayList(report);

        TableColumn idCol = new TableColumn("ID");
        idCol.setMinWidth(45);
        idCol.setCellValueFactory(
                new PropertyValueFactory<Booking, String>("id"));

        TableColumn nameCol = new TableColumn("Name");
        nameCol.setMinWidth(225);
        nameCol.setCellValueFactory(
                new PropertyValueFactory<Booking, String>("name"));

        TableColumn personCol = new TableColumn("Person");
        personCol.setMinWidth(45);
        personCol.setCellValueFactory(
                new PropertyValueFactory<Booking, String>("person"));

        TableColumn roomtypeCol = new TableColumn("Roomtype");
        roomtypeCol.setMinWidth(200);
        roomtypeCol.setCellValueFactory(
                new PropertyValueFactory<Booking, String>("roomtype"));

        TableColumn startdateCol = new TableColumn("Startdate");
        startdateCol.setMinWidth(200);
        startdateCol.setCellValueFactory(
                new PropertyValueFactory<Booking, String>("startdate"));

        TableColumn enddateCOl = new TableColumn("Enddate");
        enddateCOl.setMinWidth(200);
        enddateCOl.setCellValueFactory(
                new PropertyValueFactory<Booking, String>("enddate"));

        TableColumn isBedCol = new TableColumn("AddBed");
        isBedCol.setMinWidth(20);
        isBedCol.setCellValueFactory(
                new PropertyValueFactory<Booking, String>("isBed"));

        TableColumn isWifiCol = new TableColumn("Wifi");
        isWifiCol.setMinWidth(30);
        isWifiCol.setCellValueFactory(
                new PropertyValueFactory<Booking, String>("isWifi"));

        TableColumn statusCol = new TableColumn("Status");
        statusCol.setMinWidth(40);
        statusCol.setCellValueFactory(
                new PropertyValueFactory<Booking, String>("status"));

        TableColumn costCol = new TableColumn("Total");
        costCol.setMinWidth(65);
        costCol.setCellValueFactory(
                new PropertyValueFactory<Booking, String>("cost"));
        table.setItems(data);
        table.getColumns().addAll(idCol, personCol, nameCol, roomtypeCol, startdateCol, enddateCOl, isBedCol, isWifiCol, statusCol, costCol);
        table.setRowFactory(tv -> {
            TableRow<Booking> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getButton() == MouseButton.PRIMARY
                        && event.getClickCount() == 1) {

                    Booking clickedRow = row.getItem();
                    //System.out.println(clickedRow.getId());
                }
            });
            return row;
        });
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(table);

    }

    @FXML
    void Mainmenu(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        HomeController controller = fxmlLoader.<HomeController>getController();
        fxmlLoader.setController(controller);
        controller.setAccount(username);
        backpane.getChildren().setAll(root);
    }

    public void setAccount(String username) {
        this.username = username;
    }
}
