/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import models.Fisher;


/**
 *
 * @author a4178
 */
public class FisherDao {
    
    
    private static final String
    ALL = "SELECT * FROM fishers";
    
    private static final String
    INSERT = "INSERT INTO fishers(fisher_id,displayName) VALUES(?,?)";
    
    private static final String
    DELETE = "";
  
    
    public void insert(Fisher fisher) {
            try(
                Connection con = DaoFactory.getDatabase().openConnection();
                PreparedStatement sql = con.prepareStatement(INSERT);
            ){
            String displayName = fisher.getName();
            String id = fisher.getID();
            
            sql.setString(1,id);
            sql.setString(2,displayName);
            
                
            int status = sql.executeUpdate();
            System.out.print(status);
            }catch(Exception ex){
                System.out.println(ex);
            }
    }
    
    

    public List<Fisher> selectAllFishers(){
        
            try(
                Connection con = DaoFactory.getDatabase().openConnection();
                PreparedStatement sql = con.prepareStatement(ALL);
            ){
            ResultSet result  = sql.executeQuery();
            List<Fisher> fihers = FisherMapper.getFisherList(result);
            return fihers;
            }catch(Exception ex){
                System.out.println(ex);
                return null;
            }
            
    }

    private static class FisherMapper {

        static List<Fisher> getFisherList(ResultSet result) throws SQLException{
           List<Fisher> fishers = new ArrayList<>();
           while(result.next()){
               Fisher fisher = new Fisher();
               fisher.setName(result.getString("displayName"));
               fisher.setId(result.getString("fisher_id"));
               
               fishers.add(fisher);
           }
           return fishers;
       }
    }

   
}


