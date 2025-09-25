/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package server;
import Model.User;
import Threads.UserHandler;
import java.net.*; 
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;



/**
 *
 * @author Admin    
 */
public class SERVER {
   
    // User Online
    public static Map<User, UserHandler> clientOnline;
    
    
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        ServerSocket server = new ServerSocket(Config.Port);
        
        clientOnline = new HashMap<>();
        System.out.println("Server start on port " + Config.Port);
        while (true) {            
            Socket client = server.accept();
           
            UserHandler useHandler = new UserHandler(client);
            clientOnline.put(useHandler.currentUser, useHandler);
            useHandler.start();
        }   
    }
}
