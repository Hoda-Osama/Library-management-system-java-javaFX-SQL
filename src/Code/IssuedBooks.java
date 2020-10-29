/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

import static Code.DBInfo.DB_URL;
import static Code.DBInfo.JDBC_DRIVER;
import static Code.DBInfo.PASSWORD;
import static Code.DBInfo.USERNAME;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Huda Osama
 */
public class IssuedBooks extends Book {
     public String BorrowerName = null;
    public String BorrowerPhone = null;
    public Date BorrowingDate  = null;
    public Date LendingDate = null;

    public String getBorrowerName() {
        return BorrowerName;
    }

    public void setBorrowerName(String BorrowerName) {
        this.BorrowerName = BorrowerName;
    }

    public String getBorrowerPhone() {
        return BorrowerPhone;
    }

    public void setBorrowerPhone(String BorrowerPhone) {
        this.BorrowerPhone = BorrowerPhone;
    }

    public Date getBorrowingDate() {
        return BorrowingDate;
    }

    public void setBorrowingDate(Date BorrowingDate) {
        this.BorrowingDate = BorrowingDate;
    }

    public Date getLendingDate() {
        return LendingDate;
    }

    public void setLendingDate(Date LendingDate) {
        this.LendingDate = LendingDate;
    }

    @Override
    public String getAuthor() {
        return super.getAuthor(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setAuthor(String author) {
        super.setAuthor(author); //To change body of generated methods, choose Tools | Templates.
    }

  

    @Override
    public void setBorrow(boolean Borrow) {
        super.setBorrow(Borrow); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCode() {
        return super.getCode(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCode(int code) {
        super.setCode(code); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getLocation() {
        return super.getLocation(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setLocation(String location) {
        super.setLocation(location); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getName() {
        return super.getName(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setName(String name) {
        super.setName(name); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Date getPublishDate() {
        return super.getPublishDate(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPublishDate(Date publishDate) {
        super.setPublishDate(publishDate); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPublisher() {
        return super.getPublisher(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPublisher(String publisher) {
        super.setPublisher(publisher); //To change body of generated methods, choose Tools | Templates.
    }
  public static void BorrowNewBook(IssuedBooks b) throws Exception {
        Connection conn = null;
        PreparedStatement sp, sp2 = null;
        ObservableList<ObservableList> data2;
         Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarysystem", "root", "1234");
         System.out.println("Selecting All Books");
        String sql = "INSERT INTO issued VALUES(?,?,?,?,?)";
        sp = conn.prepareStatement(sql);
        sp.setInt(1, b.getCode());
        sp.setString(2, b.getBorrowerName());
        sp.setString(3, b.getBorrowerPhone());
        sp.setDate(4, b.getBorrowingDate());
        sp.setDate(5, b.getLendingDate());
        sp.executeUpdate();
        String sq2 = "UPDATE librarysystem.Book SET Borrow = true WHERE code = ? ";
        sp2 = conn.prepareStatement(sq2);
        sp2.setInt(1, b.getCode());
        sp2.executeUpdate();
        System.out.println("Goodbye!");
    }
         public static void returnBook(int bookcode) throws Exception {
        Connection conn = null;
        PreparedStatement sp, sp2 = null;
      
         Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarysystem", "root", "1234");
         IssuedBooks b = new IssuedBooks();
         b=SearchIssued(bookcode);
        System.out.println("Selecting All Books");
        String sql = "delete from librarysystem.issued where code = ?";
        sp = conn.prepareStatement(sql);
        sp.setInt(1, bookcode);
        sp.executeUpdate();
        System.out.println(b.getCode());
        System.out.println("Goodbye!");
        sp.close();
        String sq2 = "update librarysystem.Book set Borrow = false where code = "+ bookcode;
        sp2 = conn.prepareStatement(sq2);
        sp2.setInt(1, b.getCode());
        sp2.executeUpdate();
        System.out.println("Goodbye!");
        sp2.close();
    }
  public static IssuedBooks SearchIssued(int bookcode) throws Exception {
        IssuedBooks b = new IssuedBooks();
        Connection conn = null;
        PreparedStatement ps;
         Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarysystem", "root", "1234");
        
        System.out.println("Connecting to database...");
        String sql = "select * from librarysystem.issued where code = " + bookcode;
        ps = conn.prepareStatement(sql);
        
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
             System.out.println(rs.getString(3));
            b.setCode(rs.getInt(1));
            b.setBorrowerName(rs.getString(2));
            b.setBorrowerPhone(rs.getString(3));
            b.setBorrowingDate(rs.getDate(4));
            b.setLendingDate(rs.getDate(5));
        }

        return b;
    }
  public static ObservableList ViewBorroweredBooks() throws Exception {
        ObservableList< ObservableList> data2;
        Connection conn = null;
        PreparedStatement ps;
         Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarysystem", "root", "1234");
        
        System.out.println("Connecting to database...");
        String sql = "select * from librarysystem.issued " ;
        ps = conn.prepareStatement(sql);
        
        ResultSet rs = ps.executeQuery();
        System.out.println("issued");
        data2 = FXCollections.observableArrayList();
         while (rs.next()) {
            ObservableList row = FXCollections.observableArrayList();

            for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                row.add(rs.getString(i));

            }

            data2.add(row);

        }
       
        System.out.println("Goodbye!");
        return data2;

    } 
  
    
}
