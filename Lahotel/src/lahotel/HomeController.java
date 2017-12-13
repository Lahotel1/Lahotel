/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lahotel;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author terkg
 */
public class HomeController implements Initializable {

    // TODO
    @FXML
    private Button reservation;
    
     @FXML
    private AnchorPane backpane;

    @FXML
    private Button history;
    
    @FXML
    private Label name;
    
    String username;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    void history(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("History.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        HistoryController controller = fxmlLoader.<HistoryController>getController();
        fxmlLoader.setController(controller);

         controller.setAccount(username);
         controller.show(username);
        backpane.getChildren().setAll(root);
    }

    @FXML
    void reservation(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Reserve.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        ReserveController controller = fxmlLoader.<ReserveController>getController();
        fxmlLoader.setController(controller);
        controller.setAccount(username);
        backpane.getChildren().setAll(root);
    }
    
    @FXML
    void logout(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        LoginController controller = fxmlLoader.<LoginController>getController();
        fxmlLoader.setController(controller);
        backpane.getChildren().setAll(root);
    }

    
     @FXML
    void Booking(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Booking.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        BookingController controller = fxmlLoader.<BookingController>getController();
        fxmlLoader.setController(controller);
        controller.setAccount(username);
        controller.show(username);
        backpane.getChildren().setAll(root);
    }
    @FXML
     void Showdetail(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("detail.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        ShowdetailController controller = fxmlLoader.<ShowdetailController>getController();
        fxmlLoader.setController(controller);
        controller.setAccount(username);
        backpane.getChildren().setAll(root);
    }
    public void setAccount(String user){
        this.username=user;
        name.setText(user);
    }

}
