/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import Code.Book;

import Code.IssuedBooks;
import Code.Member;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Huda Osama
 */
public class MemberFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @FXML
    private AnchorPane pane6;
    
   @FXML
    private boolean HomePage() throws ClassNotFoundException {
        try {
            AnchorPane rootPane = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            pane6.getChildren().setAll(rootPane);

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
    @FXML
    private void viewIssuedBooks(ActionEvent event) throws Exception {
        booklistView.getItems().add("Book Code" + " | " + "Book Name");
        ObservableList<ObservableList> data1;
        data1 = IssuedBooks.ViewBorroweredBooks();
        for (int i = 0; i < data1.size(); i++) {
            System.out.println(data1.get(0).get(0));
           booklistView.getItems().add(data1.get(i).get(0) + " | " + data1.get(i).get(1));

        }

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
    private DatePicker idate;
    @FXML
    private DatePicker idate2;
    @FXML
    private TextField iid;
    @FXML
    private TextField iname;
    @FXML
    private TextField iphone;
     @FXML
    private void BorrowBook(ActionEvent event) throws Exception {
        IssuedBooks b = new IssuedBooks();
        b.setCode(Integer.parseInt(iid.getText()));
        b.setBorrowerName(iname.getText());
        b.setBorrowerPhone(iphone.getText());
        b.setBorrowingDate(Date.valueOf(idate.getValue()));
        b.setLendingDate(Date.valueOf(idate2.getValue()));
        IssuedBooks.BorrowNewBook(b);
        System.out.println(b.getCode());
        // craeting alert
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText(" Borrowing Book Sucssefully ");
        alert.showAndWait();
    }
     private DatePicker rdate;
    @FXML
    private TextField rid;
    @FXML
    private TextField rname;
    @FXML
    private void ReturnIssuedBooks(ActionEvent event) throws Exception {
        int code;
        code = Integer.parseInt(rid.getText());
        IssuedBooks.returnBook(code);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Returned sucessfully");
        alert.showAndWait();

    }
    @FXML
    private void SearchIssuedBooks(ActionEvent event) throws Exception {
        int code;
        code = Integer.parseInt(rid.getText());
        IssuedBooks b = new IssuedBooks();
        b = IssuedBooks.SearchIssued(code);
        if (b.equals(null)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Please Enter valid Id");
            alert.showAndWait();
        }

    }
   
      @FXML
    private TextField ename;
    @FXML
    private DatePicker edate;
    @FXML
    private TextField eadd;
    @FXML
    private TextField eid;
     @FXML
    private TextField epass;
      @FXML
    private TextField ephone;
        @FXML
    private TextField eemail;
          @FXML
    private TextField eM;
    @FXML
    private void SearchId(ActionEvent event) throws Exception {
        int code;
        code = Integer.parseInt(eid.getText());
        Boolean x;
        x = Member.searchId(code);
       if (x==false) {
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Confirmation Dialog");
            alert1.setHeaderText(null);
            alert1.setContentText("Please Enter valid Id");
            alert1.showAndWait();
        }

    }
     @FXML
    private void edit(ActionEvent event) throws Exception {
        System.out.println("fhdskgk");
        Member m = new Member();
        m.setId(Integer.parseInt(rid.getText()));
        m.setPassword(Integer.parseInt(epass.getText()));
        m.setName(ename.getText());
         System.out.println("hi");
        m.setBirthDate(Date.valueOf(edate.getValue()));
        m.setPhone(Integer.parseInt(ephone.getText()));
        m.setEmail(eemail.getText());
        m.setAddress(eadd.getText());
        m.setMtype(Integer.parseInt(eM.getText()));
        System.out.println(m.getId());
        Member.AddMember(m);
          System.out.println(m.getName());
        Member.EditingMember(m, Integer.parseInt(eid.getText()));
        // clear data
       ename.setText("");
        epass.setText("");
        eid.setText("");
       eadd.setText("");
       edate.setValue(null);
        ephone.setText("");
       eemail.setText("");
       eM.setText("");
      

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    
    
}
