/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import Code.Admin;
import Code.Member;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Huda Osama
 */
public class LoginFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
   @FXML
    private AnchorPane pane5;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
     @FXML
    private TextField Mid;
      @FXML
    private TextField Mpass;
    @FXML
     public void UserPage(ActionEvent event) throws IOException
     {
         AnchorPane pane1= FXMLLoader.load(getClass().getResource("UserFXML.fxml"));
         pane5.getChildren().setAll(pane1);
     } 
      @FXML
     public void MemPage(ActionEvent event) throws IOException
     {
        
         try {
             int id=Integer.parseInt(Mid.getText());
             int pass=Integer.parseInt(Mpass.getText());
             int x= Member.checklogin(id,pass);
             if(x==0)
             {
              AnchorPane pane6= FXMLLoader.load(getClass().getResource("MemberFXML.fxml"));
         pane5.getChildren().setAll(pane6);
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
            pane5.getChildren().setAll(rootPane);

        } catch (Exception e) {
        }
        return true;
    }
    
    
   
   
    
}
