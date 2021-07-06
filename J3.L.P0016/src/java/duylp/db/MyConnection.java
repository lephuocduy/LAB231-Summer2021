/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duylp.db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Le Phuoc Duy
 */
public class MyConnection {
    
    public MyConnection() {
    }
    
    public static Connection getMyConnection() throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=LPD", "sa", "123456");
//        Connection conn = DriverManager.getConnection("jdbc:sqlserver://lpduy.c7hizn5pbeoq.us-east-2.rds.amazonaws.com:1433;databaseName=LPD", "lephuocduy", "12345678");
        return conn;
    }
    
}
