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
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author mormix
 */
public class ShowdetailController implements Initializable {
    
     String username;
     
    @FXML
    private AnchorPane backpane;
      @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }
     void Back(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        HomeController controller = fxmlLoader.<HomeController>getController();
        fxmlLoader.setController(controller);
        controller.setAccount(username);
        backpane.getChildren().setAll(root);
    }
     public void setAccount(String username){
        this.username=username;
    }
}
