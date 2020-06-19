/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import game.Game;
import java.util.List;
import models.Fisher;
import models.FishingCamp;
/**
 *
 * @author a4178
 */
public class MenuController {
    private final Fisher fisherModel;
    private final FishingCamp fishingCampModel;
    
    public MenuController(Fisher fisherModel,FishingCamp fishingCampModel) {
        this.fisherModel = fisherModel;
        this.fishingCampModel = fishingCampModel;
    }
    
    public boolean isValidUsername(String username){
       return username.trim().length() > 3;
    }
    
    public List<Fisher> getAllFishers(){
            return Fisher.getAll();
    }
    
    public void  startGame(){
       Game game = new Game(this.fishingCampModel);
       game.startGame();
    }
     
    public void deleteFisher(String username){
        fisherModel.deleteOne(username);
    }
    
     
}
