/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quandh.util;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author PC_HONGQUAN
 */
public class DBHelper implements Serializable{
      public static Connection makeConnection() throws ClassNotFoundException, SQLException, NamingException {
        //1.Find current Context
          Context context = new InitialContext();
        //2. Find Tomcat's Context
        Context tomcatContext = (Context) context.lookup("java:comp/env");
        javax.sql.DataSource ds = (javax.sql.DataSource)tomcatContext.lookup("HongQuanDS");
        Connection con = ds.getConnection();
        return con;
    }
      
//        public static Connection makeConnection() throws ClassNotFoundException, SQLException {
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        String url = "jdbc:sqlserver://localhost:1433;databaseName=monshop;instanceName=ADMIN";
//        Connection connection = DriverManager.getConnection(url, "sa", "123");
//        return connection;
//    }
       
}
