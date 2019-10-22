
package dao;

import db.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public static boolean login(String login, String password)
            throws SQLException{
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        System.out.println(login+password);
        try {
            con=Database.getConnection();
            ps=con.prepareStatement(
            "select user, password from user where user=? and password=? ");
            ps.setString(1, login);
            ps.setString(2, password);
            rs=ps.executeQuery();
            if(rs.next()){
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error login"+e.getMessage());
        return false;
        }finally{
          Database.close(con);
        }
        
    }
}
