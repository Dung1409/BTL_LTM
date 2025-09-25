/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.*;

/**
 *
 * @author Admin
 */
public class User implements Serializable{
    private int id;
    private String username;
    private  String password;
    private String inGameName;

    public User(int id, String username, String password , String inGameName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.inGameName = inGameName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInGameName() {
        return inGameName;
    }

    public void setInGameName(String inGameName) {
        this.inGameName = inGameName;
    }

    @Override
    public String toString() {
        return id + " " + username + " "+  password + " " + inGameName; 
    }
    
    
    
    
    
    
}
