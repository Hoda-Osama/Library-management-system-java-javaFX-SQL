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

public class Book {

    public int code = 0;
    public String name = null;
    public String category = null;
    public String author = null;
    public int quantity = 0;
    public String publisher = null;
    public Date publishDate = null;
    public String location = null;
    public boolean Borrow = false;

    public void setCode(int code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setBorrow(boolean Borrow) {
        this.Borrow = Borrow;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getAuthor() {
        return author;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getPublisher() {
        return publisher;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public String getLocation() {
        return location;
    }

    public boolean isBorrow() {
        return Borrow;
    }
public static ObservableList ViewBooks() throws Exception {
        ObservableList<ObservableList> data;
        Connection conn = null;
        PreparedStatement sp = null;
          //STEP 4: Execute a query
         Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarysystem", "root", "1234");
             String sql = "select * from librarysystem.books "; 
            sp =(PreparedStatement) conn.prepareStatement(sql);
                       
    
        System.out.println("Selecting All Books");
        ResultSet rs = sp.executeQuery();
        data = FXCollections.observableArrayList();
        while (rs.next()) {
            ObservableList row = FXCollections.observableArrayList();

            for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                row.add(rs.getString(i));

            }

            data.add(row);

        }
        System.out.println("Goodbye!");

        return data;
    }

    public static void AddBook(Book b) throws Exception {
        Connection conn = null;
        PreparedStatement sp = null;
        //    (code,name,category,author,quantity,publisher,publishDate,location,Borrow)
        String sql = "insert into books values(?,?,?,?,?,?,?,?,?)";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarysystem", "root", "1234");
            sp = conn.prepareStatement(sql);
            sp.setInt(1, b.getCode());
            sp.setString(2, b.getName());
            sp.setString(3, b.getCategory());
            sp.setString(4, b.getAuthor());
            sp.setInt(5, b.getQuantity());
            sp.setString(8, b.getLocation());
            sp.setString(6, b.getPublisher());
            sp.setDate(7, b.getPublishDate());
            sp.setBoolean(9, b.isBorrow());
            sp.executeUpdate();

        } catch (Exception e) {
            System.out.println("nooo");
        }
    }

    public static Book search(String name) throws Exception {
        Connection conn = null;
        PreparedStatement sp = null;
        Book b = new Book();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarysystem", "root", "1234");
             String sql = "select * from librarysystem.books where name = ?"; 
            sp =(PreparedStatement) conn.prepareStatement(sql);
                       sp.setString(1, name);
           
            ResultSet rs = sp.executeQuery();
            System.out.println("Selecting All Books");
            if (rs.next()) {
                b.setCode(rs.getInt(1));
                b.setName(rs.getString(2));
                System.out.println(rs.getString(2));
                b.setCategory(rs.getString(3));
                b.setAuthor(rs.getString(4));
                b.setQuantity(rs.getInt(5));
                b.setPublisher(rs.getString(6));
                b.setPublishDate(rs.getDate(7));
                b.setLocation(rs.getString(8));
                b.setBorrow(rs.getBoolean(9));
                System.out.println("Selecting");
            }
        } catch (Exception e) {
            System.out.println("not");
        }

        System.out.println("Goodbye!");
        return b;
    }
    public static Book search(int id) throws Exception {
        Connection conn = null;
        PreparedStatement sp = null;
        Book b = new Book();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarysystem", "root", "1234");
             String sql = "select * from librarysystem.books where code = ?"; 
            sp =(PreparedStatement) conn.prepareStatement(sql);
                       sp.setInt(1, id);
           
            ResultSet rs = sp.executeQuery();
            System.out.println("Selecting All Books");
            if (rs.next()) {
                b.setCode(rs.getInt(1));
                b.setName(rs.getString(2));
                System.out.println(rs.getString(2));
                b.setCategory(rs.getString(3));
                b.setAuthor(rs.getString(4));
                b.setQuantity(rs.getInt(5));
                b.setPublisher(rs.getString(6));
                b.setPublishDate(rs.getDate(7));
                b.setLocation(rs.getString(8));
                b.setBorrow(rs.getBoolean(9));
                System.out.println("Selecting");
            }
        } catch (Exception e) {
            System.out.println("not");
        }

        System.out.println("Goodbye!");
        return b;
    }
    public static ObservableList searchautor(String author) throws Exception {
        Connection conn = null;
        PreparedStatement sp = null;
        ObservableList<ObservableList> data2;
         Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarysystem", "root", "1234");
             String sql = "select * from librarysystem.books where author = ?"; 
            sp =(PreparedStatement) conn.prepareStatement(sql);
             sp.setString(1, author);
        ResultSet rs = sp.executeQuery();
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
     public static ObservableList searchPublisher(String publisher) throws Exception {
        Connection conn = null;
        PreparedStatement sp = null;
        ObservableList<ObservableList> data2;
         Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarysystem", "root", "1234");
             String sql = "select * from librarysystem.books where publisher = ?"; 
            sp =(PreparedStatement) conn.prepareStatement(sql);
             sp.setString(1, publisher);
        ResultSet rs = sp.executeQuery();
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
      public static ObservableList searchcategory(String category) throws Exception {
        Connection conn = null;
        PreparedStatement sp = null;
        ObservableList<ObservableList> data2;
         Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarysystem", "root", "1234");
             String sql = "select * from librarysystem.books where category = ?"; 
            sp =(PreparedStatement) conn.prepareStatement(sql);
             sp.setString(1, category);
        ResultSet rs = sp.executeQuery();
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
       public static Boolean searchId(int code) throws Exception {
        Connection conn = null;
        PreparedStatement sp = null;   
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarysystem", "root", "1234");
             String sql = "select * from librarysystem.books where code = ?"; 
            sp =(PreparedStatement) conn.prepareStatement(sql);
                       sp.setInt(1, code);
           
            ResultSet rs = sp.executeQuery();
            System.out.println("Selecting All Books");
            if (rs.next()) {
                System.out.println("Selecting");
               return true;
                
            }
        } catch (Exception e) {
            System.out.println("not");
        }

        System.out.println("Goodbye!");
        return false;
    }
       public static void EditingBook(Book b, int bookcode) throws Exception {
        Connection conn = null;
        PreparedStatement sp = null;
        ObservableList<ObservableList> data2;
         Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarysystem", "root", "1234");
        System.out.println("hi");
        data2 = FXCollections.observableArrayList();
        String sql = "update librarysystem.books set name = ? ,category = ? ,author = ? ,quntity =?,publisher=? ,publishDate = ? ,location = ? ,Borrow = ? where code = ?";
        sp = conn.prepareStatement(sql);
        System.out.println("hi");
        sp.setString(1, b.getName());
        sp.setString(2, b.getCategory());
        sp.setString(3, b.getAuthor());
        sp.setInt(4, b.getQuantity());
         sp.setString(5, b.getPublisher());
        sp.setDate(6, b.getPublishDate());
         sp.setString(7, b.getLocation());
         sp.setBoolean(8,b.isBorrow());
        sp.setInt(9, bookcode);
        sp.executeUpdate(); 
        System.out.println("Goodbye!");
    }
       
       public static void DeleteingBook(int bookcode) throws Exception {
         Connection conn = null;
        PreparedStatement sp = null;
        ObservableList<ObservableList> data2;
         Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarysystem", "root", "1234");
       
        String sql = "delete from librarysystem.books where code = ?";
        sp = conn.prepareStatement(sql);
        sp.setInt(1, bookcode);
        sp.executeUpdate();
        System.out.println("Goodbye!");
    }

}


