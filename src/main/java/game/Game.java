/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import achieveSystem.Achieve;
import java.util.List;
import java.util.Random;
import models.Fisher;
import models.FishingCamp;
/**
 *
 * @author a4178
 */
public class Game {
    static boolean isStarted = false;
    static Achieve system = null;
    private final FishingCamp fishingCampModel;
    
    public Game(FishingCamp fishingCampModel){
        this.fishingCampModel = fishingCampModel;
    }
    
    
    
    public void startGame(){
       List<Fisher> fishers  =      Fisher.getAll();
       startCup(fishers);
       fishingCampModel.skipToNextMonth();
    }
    
    
    private void startCup(List<Fisher> fishers){
        if(!Game.isStarted){
            System.out.println("GAME STARTED !!!!!!!!!!!!!!!!!!");
            Game.system = initAchiveSystem();
            Game.isStarted = true;
        }
        
        Random randomNum = new Random();

        fishers.forEach((fisher)->{
            int maxFishCount  = randomNum.nextInt(30);
            String[] fishProp = {"fishes"};
            String[] catchProp= {"catch"};
            
            int fishCount = 0;
            
            while(fishCount < maxFishCount || fishCount < 0) {
                system.addValue(catchProp,(int)fisher.catchFish());
                system.addValue(fishProp, 1);
                fishCount++;
            }
            recordAchievements(system, fisher);
            System.out.println(fisher);
            system.resetProps();
        });
        
        fishingCampModel.saveWinner(getWinner(fishers));
    }
    
    
    private void recordAchievements(Achieve system,Fisher fisher  ){
        system.checkAchievements().forEach((achievement)->{
           fishingCampModel.saveFisherAchievement(achievement.id,fisher);
        });
    }
    
    
    
    
    
    
    private Fisher getWinner(List<Fisher> fishers){
        Fisher winner = null;
        double prevWieght = 0;
        for (Fisher fisher : fishers){
            double fisherCatch = fisher.getCatch();
            if(fisherCatch > prevWieght){
                prevWieght = fisherCatch;
                winner = fisher;
            }
        }
        return winner;
    }
    
    
   
    
    
    
    
    private Achieve initAchiveSystem(){
        Achieve gameSystem = new Achieve();
        
        
        //issue with achieve save 
        
        //delete parent
        fishingCampModel.clearFisherAch();
        
        //delete childs
        fishingCampModel.clearAchievements();
        fishingCampModel.clearWinners();
        
        gameSystem.defineProperty("fishes", 0,15);
        gameSystem.defineProperty("catch",0,50);
        
        //an array of props on the one achivement
        String[] ach1 = {"fishes"};
        String[] ach2 = {"catch"};
        
        
        String achievementName_1 =  "got more then 15 fishes";
        String achievementName_2 = "catched more then 50kg";
        
        
 
        String id_1 = gameSystem.defineAchievement(achievementName_1, ach1);
        String id_2 = gameSystem.defineAchievement(achievementName_2, ach2);
        
   
        
    
        fishingCampModel.saveAchievement(
               id_1,
               achievementName_1,
               "gets when catch more then 10 fishes "
        );
        
        fishingCampModel.saveAchievement(
                id_2,
                achievementName_2,
               "gets if a player has 50kg"
        );       
        
        return gameSystem;
    }
}
