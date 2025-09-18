/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package server;
import java.util.*;
import java.io.*;
import java.net.*; 


/**
 *
 * @author Admin
 */
public class SERVER {
   
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        ServerSocket server = new ServerSocket(Config.Port);
        System.out.println("Server start on port " + Config.Port);
        while (true) {            
            Socket client = server.accept();
            System.out.println("Client connected to server" + client.getInetAddress());
        }
        
    }
    
    
    
}
