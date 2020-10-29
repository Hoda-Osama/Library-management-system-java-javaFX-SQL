/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Huda Osama
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button userBt;
    @FXML
    private Button adminBt;
    @FXML
    private AnchorPane rootPane;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
     public void loadUser(ActionEvent event) throws IOException
     {
         AnchorPane pane1= FXMLLoader.load(getClass().getResource("UserFXML.fxml"));
         rootPane.getChildren().setAll(pane1);
     }
     @FXML
     public void loadAdmin(ActionEvent event) throws IOException
     {
         AnchorPane pane2= FXMLLoader.load(getClass().getResource("AdminFXML.fxml"));
         rootPane.getChildren().setAll(pane2);
     }
    
    
}
