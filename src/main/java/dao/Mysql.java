/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;


/**
 *
 * @author a4178
 */
public class Mysql extends DaoFactory{
    private static final String JDBCUrl = "jdbc:mysql://localhost:3306/camp?useSSL=false&serverTimezone=UTC";
    private static final String username = "root";   
    private static final String password = "";

   public Mysql(){}
   
   
    @Override
    public Connection openConnection(){
        try{
           
            Connection connection = DriverManager.getConnection(JDBCUrl,username,password);
            return connection;
        }catch(SQLException e){
           System.out.println(e);
        }
        return null;
    }
   
}
