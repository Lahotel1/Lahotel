/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lahotel;

import Class.*;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author terkg
 */
public class LoginController implements Initializable {

    @FXML
    private TextField inputuser;

    @FXML
    private AnchorPane backpane;

    @FXML
    private PasswordField inputpassword;
    
    @FXML
    private Label label;
    
     @FXML
    private VBox vbox;
    
    DataService _dataService = new DataService();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
            label.setText(" ");
    }

    @FXML
    void Login(ActionEvent event) throws IOException {
    
        List<Account> account =_dataService.getAllAccount();
        for (Account account1 : account) {
            if(account1.getUsername().equals(inputuser.getText())&&account1.getPassword().equals(inputpassword.getText()))
            {
                success();
            }
            else
            {
                    if(inputuser.getText().equals("")&&inputpassword.getText().equals(""))
                {
                    label.setText("put information");
                }
                   else
                label.setText("incorrect");
            }
               
        }
    }

    @FXML
    void Register(ActionEvent event) throws IOException {  
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Register.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        RegisterController controller = fxmlLoader.<RegisterController>getController();
        fxmlLoader.setController(controller);
        backpane.getChildren().setAll(root);
    }

    public void success() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        HomeController controller = fxmlLoader.<HomeController>getController();
        fxmlLoader.setController(controller);
         controller.setAccount(inputuser.getText());
        backpane.getChildren().setAll(root);
    }
}
