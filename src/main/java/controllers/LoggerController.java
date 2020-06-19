/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.Date;
import java.util.List;
import models.FishingCamp;
import responses.ResponseFisherAchievements;
import responses.ResponseWinner;

/**
 *
 * @author a4178
 */
public class LoggerController {
    private final FishingCamp fishingCampModel;
    
    public LoggerController(FishingCamp fishingCampModel){
        this.fishingCampModel = fishingCampModel;
    }
    
    
    public String getCurrentDate(){
        return fishingCampModel.getCurrentDate();
    }
    
    public  ResponseWinner getWinner(Date date){
        return fishingCampModel.getWinner(date);
    }
    
    public List<ResponseFisherAchievements> getAllAchievements(Date date){
        return fishingCampModel.getAllAchievements(date);
    }
   
    
    public Date getCurrentCalendar(){
        return fishingCampModel.getCurrentCalendar();
    }
    
    public String getOpeningDate(){
        return fishingCampModel.getOpeningDate();
    }
    
    public Date getOpeningCalendar(){
        return fishingCampModel.getOpeningCalendar();
    }

   


    
    
    
}
