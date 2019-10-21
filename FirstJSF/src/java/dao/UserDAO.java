
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
        try {
            con=Database.getConnection();
            ps=con.prepareStatement(
            "select uname, password form users where uname=? and password=?");
            ps.setString(1, login);
            ps.setString(2, password);
            rs=ps.executeQuery();
            if(rs.next()){
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
        e.printStackTrace();
        return false;
        }finally{
          Database.close(con);
        }
        
    }
}
