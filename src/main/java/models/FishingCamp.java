/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;


import responses.ResponseWinner;
import java.text.SimpleDateFormat;
import dao.FishingCampDao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import responses.ResponseFisherAchievements;
/**
 *
 * @author a4178
 */


public class FishingCamp {
   private static final String name ="Just club";
   private static Calendar openingDate = getCalendar(1,10,2001);
   private static Calendar closingDate = getCalendar(1,10,2010);
   private static Calendar currentDate = getCalendar(1,10,2001);
   
   private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
   private FishingCampDao campDao = new FishingCampDao();
   
    
   
   public static Calendar getCalendar(int day, int month, int year) {
    Calendar date = Calendar.getInstance();
    
    date.set(Calendar.YEAR, year);
    date.set(Calendar.MONTH, month);
    date.set(Calendar.DAY_OF_MONTH, day);

    return date;
}
   
   
   /**
    * For test only
    * 
    */
   public String getDummyString(String str1, String str2){
       return str1+str2;
   }
   
   public int getDummySum(int i, int j){
       return i + j;
   }
           
           
           
           
   
   public FishingCamp(){}
   
   
   public List<ResponseFisherAchievements> getAllAchievements(Date date){
       return campDao.selectFisherAchievements(date);
   }
   
   public Date getCurrentCalendar(){
       return FishingCamp.currentDate.getTime();
   }
   
   public String getOpeningDate(){
       var temp = FishingCamp.openingDate;
       temp.add(Calendar.MONTH, -1);
       return dateFormat.format(temp.getTime());
   }
   
   public String getCurrentDate(){ 
      var temp = FishingCamp.currentDate;
       temp.add(Calendar.MONTH, -1);
       return dateFormat.format(temp.getTime());
   }
   
   
   
   
   public void skipToNextMonth(){
       FishingCamp.currentDate.add(Calendar.MONTH, 1);
   }
   
  
   public ResponseWinner getWinner(Date date){
       return campDao.selectWinner(date);
   }
   
   
   
   
   public Date getOpeningCalendar(){
       return FishingCamp.openingDate.getTime();
   }
   
   public  void saveWinner(Fisher winner){
       String formatedDate = dateFormat.format(FishingCamp.currentDate.getTime());
       campDao.insertWinner(name, formatedDate, winner);
   }
   
   
   
   
   public  void saveAchievement(String achivement_id,String name,String description){ 
       campDao.insertAchievement(achivement_id, name, description);
   }
   

   
   
   public  void saveFisherAchievement(String achievement_id, Fisher fisher){
       String formatedDate = dateFormat.format(FishingCamp.currentDate.getTime());
       campDao.insertFisherAchievement(achievement_id, formatedDate, fisher);
        
   }
   
   
   
   
   public void clearAchievements(){
       campDao.dropAchievements();
   }
   
   public void clearFisherAch(){
       campDao.dropFisherAchievements();
   }
   
   public void clearWinners(){
       campDao.dropWinners();
   }

 

}
