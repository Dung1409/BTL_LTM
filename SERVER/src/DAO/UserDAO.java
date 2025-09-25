 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.User;
import java.sql.*;

/**
 *
 * @author Admin
 */
public class UserDAO extends DAO{
    public String GET_USER = "select * from users";
    public String INSERT_USER = "insert into users (username , password , inGameName) values(? , ?, ?)"; 
    public String GET_USER_BY_ACCOUNT = "select * from users where username = ? and password = ?";
    
    
    public void RegisterUser(User u) throws Exception{
        state = State.SUCCESS;
        try{
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(INSERT_USER);
            stmt.setString(1, u.getUsername());
            stmt.setString(2, u.getPassword());
            stmt.setString(3, u.getInGameName());
            int res = stmt.executeUpdate();
            if(res == 0) state = State.FAIL;
              
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void LoginUser(User u) throws  Exception{
        state = State.SUCCESS;
        try {
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(GET_USER_BY_ACCOUNT);
            stmt.setString(1, u.getUsername());
            stmt.setString(2, u.getPassword());
            
            ResultSet result = stmt.executeQuery();
            
            if(!result.next()){
                state = State.FAIL;
                System.out.println("Username or password no exist");
                return;
            }
            u.setId(result.getInt(1));
            u.setInGameName(result.getString(4));
            
        } catch (Exception e) {
        }
    } 
    
}
