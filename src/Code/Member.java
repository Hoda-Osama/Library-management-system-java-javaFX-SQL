/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

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
public class Member extends User implements MemberShip {

    int Mtype;

    public Member() {
    }

    public Member(int Mtype) {
        this.Mtype = Mtype;
    }

    public Member(int Mtype, int id, int password, String name, Date birthDate, int Phone, String email, String address) {
        super(id, password, name, birthDate, Phone, email, address);
        this.Mtype = Mtype;
    }

    public static void AddMember(Member m) throws Exception {
        Connection conn = null;
        PreparedStatement sp = null;
        //    (code,name,category,author,quantity,publisher,publishDate,location,Borrow)
        String sql = "insert into member values(?,?,?,?,?,?,?,?)";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarysystem", "root", "1234");
            System.out.println("mamner");
            sp = (PreparedStatement) conn.prepareStatement(sql);
            sp.setInt(1, m.getId());
            sp.setInt(2, m.getPassword());
            sp.setString(3, m.getName());
            sp.setDate(4, m.getBirthDate());
            sp.setInt(5, m.getPhone());
            sp.setString(6, m.getEmail());
            sp.setString(7, m.getAddress());
            sp.setInt(8, m.getMtype());
            sp.executeUpdate();

        } catch (Exception e) {
            System.out.println("nooo");
        }
    }

    public void setMtype(int Mtype) {
        this.Mtype = Mtype;
    }

    public int getMtype() {
        return Mtype;
    }

    @Override
    public boolean isSeliver(int id) {
        return false;

    }

    @Override
    public boolean isGold(int id) {
        return false;

    }

    @Override
    public boolean isDaimon(int id) {
        return false;

    }

    @Override
    public void setAddress(String address) {
        super.setAddress(address); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPhone(int Phone) {
        super.setPhone(Phone); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setBirthDate(Date birthDate) {
        super.setBirthDate(birthDate); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setName(String name) {
        super.setName(name); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPassword(int password) {
        super.setPassword(password); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setId(int id) {
        super.setId(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAddress() {
        return super.getAddress(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEmail() {
        return super.getEmail(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getPhone() {
        return super.getPhone(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Date getBirthDate() {
        return super.getBirthDate(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getName() {
        return super.getName(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getPassword() {
        return super.getPassword(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getId() {
        return super.getId(); //To change body of generated methods, choose Tools | Templates.
    }

    public static int checklogin(int id, int name) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "select * from librarysystem.member where id = ? and password = ?";
        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarysystem", "root", "1234");

            ps = (PreparedStatement) conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, name);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.print("found");
                return 0;

            } else {
                return 1;
            }
        } catch (Exception e) {

        }

        return 1;

    }

    public static Boolean searchId(int code) throws Exception {
        Connection conn = null;
        PreparedStatement sp = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarysystem", "root", "1234");
            String sql = "select * from librarysystem.member where id = ?";
            sp = (PreparedStatement) conn.prepareStatement(sql);
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

    public static void EditingMember(Member m, int id) throws Exception {
        Connection conn = null;
        PreparedStatement sp = null;
        ObservableList<ObservableList> data2;
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarysystem", "root", "1234");
        System.out.println("hi");
        data2 = FXCollections.observableArrayList();
        String sql = "update librarysystem.member set id = ? ,password = ? ,name= ? ,birthdate =?,phone=? ,email = ? ,address = ? ,Mtype = ? where id = ?";
        sp = conn.prepareStatement(sql);
        System.out.println("hi");
        sp.setInt(1, m.getId());
        sp.setInt(2, m.getPassword());
        sp.setString(3, m.getName());
        sp.setDate(4, m.getBirthDate());
        sp.setInt(5, m.getPhone());
        sp.setString(6, m.getEmail());
        sp.setString(7, m.getAddress());
        sp.setInt(8, m.getMtype());
        sp.setInt(9, id);
        sp.executeUpdate();
        System.out.println("Goodbye!");
    }

}
