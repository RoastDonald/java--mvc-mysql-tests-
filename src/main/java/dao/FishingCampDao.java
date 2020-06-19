/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import achieveSystem.Achievement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import models.Fisher;
import responses.ResponseFisherAchievements;
import responses.ResponseWinner;

/**
 *
 * @author Andrei Vasilenko
 */
public class FishingCampDao {
    private static final String
    INSERT_WINNER = "INSERT INTO camp(name,date,winner_id)values(?,?,?)";
   
    private static final String
    INSERT_ACHIEVEMENT = "INSERT INTO achievements"+
            "(achievement_id,name,description)" +
            "values(?,?,?)";
    
    private static final String
    INSERT_FISHER_ACHIEVEMENT = "INSERT INTO fisher_achievements"+
            "(achievement_id,fisher_id,date)"+
            "values(?,?,?)";
    
    private static final String
    DELETE_ACHIEVEMENTS = "delete from achievements";
    
    private static final String
    DELETE_FISHER_ACHIEVEMENTS = "delete from fisher_achievements";
    
    private static final String
    DELETE_WINNERS = "delete from camp";
    
    private static final String
    SELECT_WINNER = " select c.name, c.date, f.displayName from camp as c " +
                    " inner join fishers as f " +
                    " on c.winner_id=f.fisher_id and YEAR(c.date) = ? and MONTH(c.date) = ? ";
    
    private static final String
    SELECT_FISHER_ACHIEVEMENTS = " select fa.date, a.name, f.displayName from fisher_achievements as fa " +
                                 " inner join fishers as f on fa.fisher_id=f.fisher_id " +
                                 " inner join achievements as a on a.achievement_id=fa.achievement_id and " +
                                 " YEAR(fa.date) = ? and " +
                                 " MONTH(fa.date) = ? ";
    
    
    public ResponseWinner selectWinner(Date date){
        try(
                Connection con = DaoFactory.getDatabase().openConnection();
                PreparedStatement sql = con.prepareStatement(SELECT_WINNER);
            ){
           
           java.sql.Date sqlDate =new java.sql.Date(date.getTime());
           Calendar cal = Calendar.getInstance();
           cal.setTime(date);
           
           //converting issue
           int month = cal.get(Calendar.MONTH)+1;
           int year = cal.get(Calendar.YEAR);
           
           sql.setInt(1,year);
           sql.setInt(2,month);
         
           ResultSet result = sql.executeQuery();
           if(result.next()){
               
                String name = result.getString("name");
                String dateWinnig = result.getString("date");
                String displayName = result.getString("displayName");
                ResponseWinner response = new ResponseWinner(
                        name,
                        dateWinnig,
                        displayName
                );

                return response;
           }else{
               return null;
           }
           
           
        
           
            }catch(Exception ex){
                System.out.println(ex);
                return null;
            }
    }
    
    
    public  List<ResponseFisherAchievements> selectFisherAchievements(Date date){
        try(
                Connection con = DaoFactory.getDatabase().openConnection();
                PreparedStatement sql = con.prepareStatement(SELECT_FISHER_ACHIEVEMENTS);
            ){
           
           java.sql.Date sqlDate =new java.sql.Date(date.getTime());
           Calendar cal = Calendar.getInstance();
           cal.setTime(date);
           
           //converting issue
           int month = cal.get(Calendar.MONTH)+1;
           int year = cal.get(Calendar.YEAR);
           
           sql.setInt(1,year);
           sql.setInt(2,month);
         
           ResultSet result = sql.executeQuery();
           List<ResponseFisherAchievements> ahcs = 
                   FisherAchievementsMapper.getAcievementsList(result);
        
           return ahcs;
           
            }catch(Exception ex){
                System.out.println(ex);
                return null;
            }
    }
    
    
    
    
    public void insertWinner(String camp,String date,Fisher winner){
         try(
                Connection con = DaoFactory.getDatabase().openConnection();
                PreparedStatement sql = con.prepareStatement(INSERT_WINNER);
            ){
            
            String id = winner.getID();
            
            Date temp =new SimpleDateFormat("yyyy-MM-dd").parse(date); 
         
            java.sql.Date sqlDate =new java.sql.Date(temp.getTime());
            
            
            sql.setString(1,camp);
            sql.setDate(2,sqlDate);
            sql.setString(3,id);
            
            int status = sql.executeUpdate();
            System.out.print(status);
            }catch(Exception ex){
                System.out.println(ex);
            }
    }
    
    
    
    
    
     public void insertAchievement(String id,String achievement_id, String description){
         try(
                Connection con = DaoFactory.getDatabase().openConnection();
                PreparedStatement sql = con.prepareStatement(INSERT_ACHIEVEMENT);
            ){
            
            sql.setString(1,id);
            sql.setString(2,achievement_id);
            sql.setString(3,description);
            
            int status = sql.executeUpdate();
            System.out.print(status);
            }catch(Exception ex){
                System.out.println(ex);
            }
    }
     
     
     
      public void insertFisherAchievement(String achievement_id,String date,Fisher fisher){
         try(
                Connection con = DaoFactory.getDatabase().openConnection();
                PreparedStatement sql = con.prepareStatement(INSERT_FISHER_ACHIEVEMENT);
            ){
            
            String id = fisher.getName();
            
            Date temp =new SimpleDateFormat("yyyy-MM-dd").parse(date);
            java.sql.Date sqlDate =new java.sql.Date(temp.getTime());
            
            
            sql.setString(1,achievement_id);
            sql.setString(2,fisher.getID());
            sql.setDate(3,sqlDate);
            
            
            
            int status = sql.executeUpdate();
            System.out.print(status);
            }catch(Exception ex){
                System.out.println(ex);
            }
    }
      
      
    public void dropAchievements(){
         try(
                Connection con = DaoFactory.getDatabase().openConnection();
                PreparedStatement sql = con.prepareStatement(DELETE_ACHIEVEMENTS);
            ){
            
            int status = sql.executeUpdate();
            System.out.println(status);
            }catch(Exception ex){
                System.out.println(ex);
            }
    }
    
    public void dropFisherAchievements(){
         try(
                Connection con = DaoFactory.getDatabase().openConnection();
                PreparedStatement sql = con.prepareStatement(DELETE_FISHER_ACHIEVEMENTS);
            ){
            
            int status = sql.executeUpdate();
            System.out.println(status);
            }catch(Exception ex){
                System.out.println(ex);
            }
    }
    
    public void dropWinners(){
         try(
                Connection con = DaoFactory.getDatabase().openConnection();
                PreparedStatement sql = con.prepareStatement(DELETE_WINNERS);
            ){
            
            int status = sql.executeUpdate();
            System.out.println(status);
            }catch(Exception ex){
                System.out.println(ex);
            }
    }
    
    
     private static class FisherAchievementsMapper {

        static List<ResponseFisherAchievements> getAcievementsList(ResultSet result) throws SQLException{
           List<ResponseFisherAchievements> achs = new ArrayList<>();
           while(result.next()){
               ResponseFisherAchievements ach = new ResponseFisherAchievements(
               result.getString("date"),
               result.getString("displayName"),  
               result.getString("name")
               );
              

               achs.add(ach);
           }
           return achs;
       }
    }
   
}
