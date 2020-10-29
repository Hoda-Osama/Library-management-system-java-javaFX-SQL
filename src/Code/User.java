/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

import java.sql.Date;

/**
 *
 * @author Huda Osama
 */
public  class User {
    public int id = 0 ;
     public int password = 0 ;
    public String name = null;
    public Date birthDate = null;
     public int Phone = 0 ;
     public String email= null;
     public String address = null;

    public User() {
    }

    public User(int id, int password,String name,Date birthDate,int Phone,String email,String address) {
        this.id=id;
        this.Phone=Phone;
        this.address=address;
        this.birthDate=birthDate;
        this.email=email;
        this.password=password;
        this.name=name;
        
    }
     

    public int getId() {
        return id;
    }

    public int getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public int getPhone() {
        return Phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setPhone(int Phone) {
        this.Phone = Phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }
     
     
   
    
    
    
    
}
