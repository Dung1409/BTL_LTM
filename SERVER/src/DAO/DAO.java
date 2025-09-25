/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import  java.sql.*;
/**
 *
 * @author Admin
 */
public class DAO{
    protected  String DB_URL = "jdbc:mysql://localhost:3306/ltm?zeroDateTimeBehavior=CONVERT_TO_NULL";
    protected  String USERNAME = "root";
    protected  String PASSWORD = "12345";
    public State state;
    
    public Connection getConnection() throws Exception{
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL,USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    
    public enum State {
        SUCCESS,
        FAIL
    }
    
}
