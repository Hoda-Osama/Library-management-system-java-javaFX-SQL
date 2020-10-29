/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import Code.Admin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Huda Osama
 */
public class AdminFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     * 
     */
     @FXML
    private AnchorPane pane2;
     @FXML
     private TextField Adid;
     @FXML
     private TextField Adpass;
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    @FXML
     private void AdPage(ActionEvent event) throws IOException
     {
         try {
             int id=Integer.parseInt(Adid.getText());
             int pass=Integer.parseInt(Adpass.getText());
             int x= Admin.checklogin(id,pass);
             if(x==0)
             {
             AnchorPane p6= FXMLLoader.load(getClass().getResource("ACFXML.fxml"));
             pane2.getChildren().setAll(p6);
             }
             else
             {
                
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Please Enter valid Id");
            alert.showAndWait();
             }
             
         } catch (Exception ex) {
             Logger.getLogger(AdminFXMLController.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
     @FXML
    private boolean HomePage() throws ClassNotFoundException {
        
        try {
            AnchorPane rootPane = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            pane2.getChildren().setAll(rootPane);

        } catch (Exception e) {
        }
        return true;
    }
  
    
}
