/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

public class DBInfo {
     public final static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    public final static String USERNAME="root";
    public final static String PASSWORD="1234";
    public final static String DB_NAME="librarysystem";
    public final static String DB_HOST="localhost";
    public final static String DB_URL="jdbc:mysql://"+DB_HOST;
    public final static String URL="jdbc:mysql://localhost/librarysystem?useSSL=false&serverTimezone=Europe/Helsinki";
    public final static String file="lendedbooks.txt" ;
}
