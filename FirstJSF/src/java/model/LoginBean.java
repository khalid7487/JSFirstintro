
package model;

import dao.UserDAO;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean {
     String uname,pass,msg;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public String loginAction() throws SQLException{
        boolean result=UserDAO.login(uname, pass);
        if(result){
            return "home";
        }else{
            setMsg("Login Failed!!");
            setUname("");
            setPass("");
            return "index";
        }
    }
}
