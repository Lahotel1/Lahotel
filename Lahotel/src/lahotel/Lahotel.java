/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lahotel;

import Class.*;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author terkg
 */
public class Lahotel extends Application {

    static DataService _dataService = new DataService();

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        primaryStage.setTitle("LOGIN");
        primaryStage.setScene(new Scene(root, 1280 , 720));
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        for (int i = 2018; i < 2019; i++) {
//           
//            for (int j = 1; j < 3; j++) {
//                if (j == 1 || j == 3 || j == 5 || j == 7 || j == 8 | j == 10 || j == 12) {
//                    for (int k = 1; k < 32; k++) {
//                        createroom(k, j, i);
//                    }
//                } else if (j == 2) {
//                    for (int k = 1; k < 29; k++) {
//                        createroom(k, j, i);
//                    }
//                } else {
//                    for (int k = 1; k < 31; k++) {
//                        createroom(k, j, i);
//                    }
//                }
//            }
//        }
    
        launch(args);

    }

    public static void createroom(int day, int month, int year) {
        for (int i = 101; i < 141; i++) {
            Room temproom = new SingleRoom(String.valueOf(i), String.valueOf(day), String.valueOf(month), String.valueOf(year));
            _dataService.createRoom(temproom);
        }
        for (int i = 201; i < 231; i++) {
            Room temproom = new DuoRoom(String.valueOf(i), String.valueOf(day), String.valueOf(month), String.valueOf(year));
            _dataService.createRoom(temproom);
        }
        for (int i = 301; i < 311; i++) {
            Room temproom = new FamilyRoom(String.valueOf(i), String.valueOf(day), String.valueOf(month), String.valueOf(year));
            _dataService.createRoom(temproom);
        }
        for (int i = 401; i < 411; i++) {
            Room temproom = new GroupRoom(String.valueOf(i), String.valueOf(day), String.valueOf(month), String.valueOf(year));
            _dataService.createRoom(temproom);
        }
    }
}
