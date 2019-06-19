package com.vulnble;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginProcess {


    public static void main(String args[]){

        LoginProcess loginPro = new LoginProcess();
        loginPro.loginToApplication(1);

    }

    public void loginToApplication(int userId){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/abc","xxx","xxx");
            //here sonoo is database name, root is username and password
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from KT_UserMaster where user_id="+userId);
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            con.close();
        }catch(Exception e){ e.printStackTrace();}

    }

}
