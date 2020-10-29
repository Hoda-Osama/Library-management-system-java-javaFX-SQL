/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import Code.Member;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Huda Osama
 */
public class RegisterFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private AnchorPane pane4;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    @FXML
    private boolean HomePage() throws ClassNotFoundException {
        try {
            AnchorPane rootPane = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            pane4.getChildren().setAll(rootPane);

        } catch (Exception e) {
        }
        return true;
    }
    @FXML
     public void UserPage(ActionEvent event) throws IOException
     {
         AnchorPane pane1= FXMLLoader.load(getClass().getResource("UserFXML.fxml"));
         pane4.getChildren().setAll(pane1);
     }
    @FXML
     public void MemPage(ActionEvent event) throws IOException
     {
         AnchorPane pane6= FXMLLoader.load(getClass().getResource("MemberFXML.fxml"));
         pane4.getChildren().setAll(pane6);
     } 
      @FXML
    private TextField rname;
    @FXML
    private DatePicker rdate;
    @FXML
    private TextField radd;
    @FXML
    private TextField rid;
     @FXML
    private TextField rpass;
      @FXML
    private TextField rphone;
        @FXML
    private TextField remail;
          @FXML
    private TextField rM;
    @FXML
    public void addmember() throws Exception {
        System.out.println("hi");
        Member m = new Member();
        m.setId(Integer.parseInt(rid.getText()));
        m.setPassword(Integer.parseInt(rpass.getText()));
        m.setName(rname.getText());
         System.out.println("hi");
        m.setBirthDate(Date.valueOf(rdate.getValue()));
        m.setPhone(Integer.parseInt(rphone.getText()));
        m.setEmail(remail.getText());
        m.setAddress(radd.getText());
        m.setMtype(Integer.parseInt(rM.getText()));
        System.out.println(m.getId());
        Member.AddMember(m);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText(" Member added Sucssefully ");
        alert.showAndWait();
        // clear data
        rname.setText("");
        rpass.setText("");
        rid.setText("");
       radd.setText("");
       rdate.setValue(null);
        rphone.setText("");
       remail.setText("");
       rM.setText("");

    }
    
}
