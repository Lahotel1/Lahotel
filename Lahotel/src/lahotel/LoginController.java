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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    @FXML
    void Login(ActionEvent event) {
            
    }

    @FXML
    void Register(ActionEvent event) throws IOException {
          FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Register.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        RegisterController controller = fxmlLoader.<RegisterController>getController();
        fxmlLoader.setController(controller);
        backpane.getChildren().setAll(root);
    }
    public void success(){
        
    }
}
