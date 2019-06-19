package com.vulnble;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class FetchRecords {

    public static void main(String args[]){

        FetchRecords fetch = new FetchRecords();
        fetch.fetchRecords(1,"admin",9.99f);

    }

    public void fetchRecords(int userId, String userName,float user_avg){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/abc","xx","xxxxx");
            //here sonoo is database name, root is username and password
            Statement stmt=con.createStatement();
//            ResultSet rs=stmt.executeQuery("select * from KT_UserMaster where user_id="+userId +" and user_name="+userName+" and user_avg="+user_avg+"\"");
				PreparedStatement pstmt_eqyqw = con.prepareStatement( " Select * from KT_UserMaster  where user_id = ?  and user_name = ?  and user_avg = ?  ");	
				pstmt_eqyqw.setInt(1,userId); pstmt_eqyqw.setString(2,userName); pstmt_eqyqw.setFloat(3,user_avg);	
				            ResultSet rs = pstmt_eqyqw.executeQuery();
 
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getFloat(3));
            con.close();
        }catch(Exception e){ e.printStackTrace();}

    }

}
