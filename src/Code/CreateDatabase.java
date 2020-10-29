/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import static Code.DBInfo.*;
import java.sql.Date;
import java.sql.PreparedStatement;

public class CreateDatabase {
    public static void createDatabaseTable() throws Exception {
        Connection conn = null;
        Statement stmt = null;
        Statement stmt1 = null;
        PreparedStatement stmt2 = null;
        PreparedStatement sp = null;
        Class.forName(JDBC_DRIVER);
        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        System.out.println("Creating database...");

        
       /*stmt = conn.createStatement();
        String sql = "CREATE DATABASE librarysystem";
        stmt.executeUpdate(sql);
        System.out.println("Database created successfully...");
       
       
       /* stmt2 = conn.createStatement();
        String sq3 = "create table IF NOT EXISTS librarysystem.Admin(\n" +
                      "id int(20) not null,\n" +
                        "password int(20) not null,\n" +
                      "name varchar(40) not null,\n" +
                      "birthDate date not null,\n" +
                      "Phone int(20) not null,\n" +
                     "email varchar(40) not null,\n" +
                      "address varchar(40) not null,\n" +
                "primary key (id)\n" +
                       ");";
   
        stmt2.executeUpdate(sq3);
        System.out.println("Admin table created successfully...");
        String sq4 = " insert into librarysystem.Admin (id,password,name,birthDate,Phone,email,address) values(?,?,?,?,?,?,?)";
        sp = (PreparedStatement)conn.prepareStatement(sq4);
         sp.setInt(1,1);
        sp.setString(2, "123");
        sp.setString(3, "hoda");
        sp.setDate(4, new Date(1,5,1990));
        sp.setInt(5,1235648);
        sp.setString(6, "xxx.com");
        sp.setString(7, "xxx");
        sp.executeUpdate();



        // create Book table
       /* System.out.println("Creating Book table...");
        stmt2 = conn.createStatement();
        String sq3 = "create table IF NOT EXISTS librarysystem.Borrow(\n" +
                      "Bookcode int(20) not null,\n" +
                      "BorrowerName varchar(40) not null,\n" +
                      "BorrowrPhone varchar(40) not null,\n" +
                      "BorrowingDate date not null,\n" +
                      "LendingDate date not null,\n" +
                      "primary key (Bookcode),\n" +
                      "foreign key (Bookcode) references librarysystem.Book(code)\n"+
                      ");";
        stmt2.executeUpdate(sq3);
        System.out.println("Borrow table created successfully...");
        System.out.println("Goodbye!");*/
       
    }
  
}//end CreateDatabase

