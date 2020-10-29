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

/**
 *
 * @author Huda Osama
 */
public class Admin  extends User{

    public Admin() {
    }
    public Admin(int id, int password,String name,Date birthDate,int Phone,String email,String address) {
        super(id, password, name, birthDate, Phone, email, address);
    }
    

    public static int checklogin(int id, int name) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "select * from librarysystem.admin where id = ? and password = ?";
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

}
