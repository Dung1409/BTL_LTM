/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Threads;



import DAO.UserDAO;
import Model.User;
import Protocol.Request;
import Protocol.Response;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.Contants;

/**
 *
 * @author Admin
 */
public class UserHandler extends Thread{
   
    private final Socket socket;
    public User currentUser;
    
    BufferedReader in;
    PrintWriter out;
    Gson gson;
    
    public UserHandler(Socket socket ) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            gson = new Gson();
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());
            // GET REQUEST
            String reqJson = in.readLine();
            Request req = gson.fromJson(reqJson, Request.class);
            
            switch (req.getStatus()) {
                case Contants.LOGIN_STATUS -> Login(req);
                case Contants.REGISTER_STATUS -> Register(req);
                case Contants.LOGOUT_STATUS -> Logout();
                default -> System.out.println("Unknown request status: " + req.getStatus());
            }

        } catch (IOException ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(UserHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void Login(Request req) throws Exception{
        
        String data = req.getData().toString();
        User u = gson.fromJson(data, User.class);
        
        UserDAO uDAO = new UserDAO();
        uDAO.LoginUser(u);
        
        String resResult = "Login Fail";
        String LOGIN_STATE = uDAO.state.toString();
        
        if(LOGIN_STATE.equals("SUCCESS")){
            currentUser = u;
            resResult = gson.toJson(u);
        }
        
        Response res = new Response(req.getStatus() + "_" + LOGIN_STATE, resResult);
        String resJson = gson.toJson(res);
        
        out.println(resJson);
        out.flush();   
    }
   
   public void Register(Request req){
       
   }
   
   public void Logout(){
       
   }
}
