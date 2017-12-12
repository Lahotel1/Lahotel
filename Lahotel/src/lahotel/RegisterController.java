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
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author terkg
 */
public class RegisterController implements Initializable {

      @FXML
    private PasswordField password;
 
       @FXML
    private Label alertlabel;
       
    @FXML
    private AnchorPane backpane;

    @FXML
    private PasswordField confirmpassword;

    @FXML
    private TextField email;

    @FXML
    private TextField username;

     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    void back(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        LoginController controller = fxmlLoader.<LoginController>getController();
        fxmlLoader.setController(controller);
        backpane.getChildren().setAll(root);
    }

    @FXML
    void register(ActionEvent event) throws IOException {
        if(!username.getText().equals("")&&!password.getText().equals("")&&!confirmpassword.getText().equals("")&&!email.getText().equals(""))
        {        
            if(password.getText().equals(confirmpassword.getText())){
               alertlabel.setText(" "); 
                success();
            }
            else
                alertlabel.setText("password not match");
                
        }       
        else
                alertlabel.setText("please put information");
          
    }
    public void success() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
        Parent root = (Parent) fxmlLoader.load();
         LoginController controller = fxmlLoader.<LoginController>getController();
        fxmlLoader.setController(controller);
        backpane.getChildren().setAll(root);
    }
}
