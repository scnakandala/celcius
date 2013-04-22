package logic;

import dataaccess.UsersDataAccess;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsersLogic {

    public static boolean login(String username,String password){
        try {
            String dbPass = UsersDataAccess.getInstance().getPassword(username);
            if(dbPass.equals(password)){
                return true;
            }
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(UsersLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
