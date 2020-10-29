/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import Code.Admin;
import Code.Book;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Huda Osama
 */
public class UserFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @FXML
    private AnchorPane pane1;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML 
    private ListView booklistsearch;
     @FXML
    private TextField sname;
    @FXML
    private TextField scategory;
    @FXML
    private TextField sauthor;
    @FXML
    private TextField spublisher;
    @FXML
    private TextField sid;
    @FXML
    private void SearchBookName(ActionEvent event) throws Exception {
        String name;
        name = sname.getText();
       booklistsearch.getItems().add("Book Code" + " | " + "Book Name" + " | " + "Author" + " | " + "Publisher" + " | " + "Publishing Date" + " | " + "Category" + " | " + "Location");
        Book b =new Book();
         b = Book.search(name);
        System.out.println(b.getName());
         if (b.getName() == null) {
   
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Not Found");
             alert.setHeaderText(null);
             alert.setContentText("Please Enter valid name");
             alert.showAndWait();
         }
         else {
        
            booklistsearch.getItems().add(b.getCode() + " | " + b.getName() + " | " + b.getAuthor() + " | " + b.getPublisher() + " | " + b.getPublishDate() + " | " + b.getCategory() + " | " + b.getLocation());
        
    }
    }
     @FXML
    private void SearchBookId(ActionEvent event) throws Exception {
        int id;
         id = Integer.parseInt(sid.getText());
         booklistsearch.getItems().add("Book Code" + " | " + "Book Name" + " | " + "Author" + " | " + "Publisher" + " | " + "Publishing Date" + " | " + "Category" + " | " + "Location");
         Book b = new Book();
         b = Book.search(id);
         System.out.println(b.getCode());

         if (b.getCode() == 0) {
   
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
             alert.setTitle("Not Found");
             alert.setHeaderText(null);
             alert.setContentText("Please Enter valid Id");
             alert.showAndWait();
         }
         else {
        
            booklistsearch.getItems().add(b.getCode() + " | " + b.getName() + " | " + b.getAuthor() + " | " + b.getPublisher() + " | " + b.getPublishDate() + " | " + b.getCategory() + " | " + b.getLocation());
        
    }
    }
    @FXML
    private void SearchBookAuthor(ActionEvent event) throws Exception {
        String author;
        author = sauthor.getText();
        booklistsearch.getItems().add("Book Code" + " | " + "Book Name" + " | " + "Author" + " | " + "Publisher" + " | " + "Publishing Date" + " | " + "Category" + " | " + "Location");
        ObservableList<ObservableList> data;
        data = Book.searchautor(author);
        System.out.println(data.get(0).get(0));
      
        for (int i = 0; i < data.size(); i++) {
           booklistsearch.getItems().add(data.get(i).get(0) + " | " + data.get(i).get(1) + " | " + data.get(i).get(3) + " | " + data.get(i).get(5) + " | " + data.get(i).get(6) + " | " + data.get(i).get(2) + " | " + data.get(i).get(7));
        }
        
    }

    @FXML
    private void SearchBookPublisher(ActionEvent event) throws Exception {
        String Publisher;
        Publisher = spublisher.getText();
       booklistsearch.getItems().add("Book Code" + " | " + "Book Name" + " | " + "Author" + " | " + "Publisher" + " | " + "Publishing Date" + " | " + "Category" + " | " + "Location");
        ObservableList<ObservableList> data;
        data = Book.searchPublisher(Publisher);
        System.out.println(data);
      
        for (int i = 0; i < data.size(); i++) {
            booklistsearch.getItems().add(data.get(i).get(0) + " | " + data.get(i).get(1) + " | " + data.get(i).get(3) + " | " + data.get(i).get(5) + " | " + data.get(i).get(6) + " | " + data.get(i).get(2) + " | " + data.get(i).get(7));
        }
        
    }
  

    @FXML
    private void SearchBookategory(ActionEvent event) throws Exception {
        String category;
        category = scategory.getText();
        booklistsearch.getItems().add("Book Code" + " | " + "Book Name" + " | " + "Author" + " | " + "Publisher" + " | " + "Publishing Date" + " | " + "Category" + " | " + "Location");
        ObservableList<ObservableList> data;
        data = Book.searchcategory(category);
        System.out.println(data);
       
        for (int i = 0; i < data.size(); i++) {
           booklistsearch.getItems().add(data.get(i).get(0) + " | " + data.get(i).get(1) + " | " + data.get(i).get(3) + " | " + data.get(i).get(5) + " | " + data.get(i).get(6) + " | " + data.get(i).get(2) + " | " + data.get(i).get(7));
        
    }
    }
    @FXML
    private boolean HomePage() throws ClassNotFoundException {
        try {
            AnchorPane rootPane = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            pane1.getChildren().setAll(rootPane);

        } catch (Exception e) {
        }
        return true;
    }

    @FXML
    public boolean RegPage(ActionEvent event) throws IOException {
        try {
            AnchorPane pane4 = FXMLLoader.load(getClass().getResource("RegisterFXML.fxml"));
            pane1.getChildren().setAll(pane4);
        } catch (Exception e) {
        }
        return true;
    }

    @FXML
    public boolean LogPage(ActionEvent event) throws IOException {
        try {
            AnchorPane pane5 = FXMLLoader.load(getClass().getResource("LoginFXML.fxml"));
            pane1.getChildren().setAll(pane5);
        } catch (Exception e) {
        }
        return true;
    }

   @FXML 
    private ListView booklistView;
     @FXML
    private void viewBook(ActionEvent event) throws Exception {
        booklistView.getItems().add("Book Code" + " | " + "Book Name" + " | " + "Author" + " | " + "Publisher" + " | " + "Publishing Date" + " | " + "Category" + " | " + "Location");
        ObservableList<ObservableList> data;
        data = Book.ViewBooks();
        if (data.equals(null)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Please Enter valid Id");
            alert.showAndWait();
        } else {
            for (int i = 0; i < data.size(); i++) {
               booklistView.getItems().add(data.get(i).get(0) + " | " + data.get(i).get(1) + " | " + data.get(i).get(3) + " | " + data.get(i).get(5) + " | " + data.get(i).get(6) + " | " + data.get(i).get(2) + " | " + data.get(i).get(7));
            }
        }
        System.out.println(data);
    }
}
