/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package achieveSystem;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

/**
 *
 * @author a4178
 */
public class Achieve {
    private Hashtable<String, Property> props;
    private Hashtable<String, Achievement> achievements;
    
    public Achieve(){
         this.props = new Hashtable<>();
         this.achievements = new Hashtable<>();
         
    }
    
    public void defineProperty(String name,int initValue, int value){
        this.props.put(name, new Property(name,initValue,value));
    }
    
    /**
     * Creates a new achievement and returns id of it
     * @param name just name
     * @param props white boxes of triggers
     * @return String just id
     */
    public String defineAchievement(String name,String[] props){
        Achievement ach = new Achievement(name,props);
        this.achievements.put(name,ach);
        
        return ach.id;
        
    }
    
    public int  getValue(String propName){
        return this.props.get(propName).value;
    }
    
    public void setValue(String propName, int value){
       this.props.get(propName).value = value;
    }
    
    public void addValue(String[] props,int value){
        for (String propName : props) {
            setValue(propName,getValue(propName)+value);
        }
    }
    
    
    public void resetProps(){
        Set<String> propKeys = this.props.keySet();
        Set<String> achievementKeys = this.achievements.keySet();
        
        
         //Reset properties
        propKeys.forEach((key) -> {
            int initValue = this.props.get(key).initValue;
            setValue(key,initValue);
        });
        
        //Reset achievements
        achievementKeys.forEach((key)->
                this.achievements.get(key).isUnlocked = false);
         
    }
    
    public List<Achievement> checkAchievements(){
        List<Achievement> unlockedAchivements = new ArrayList<>();
        Set<String> keys = this.achievements.keySet();
        
        for(String key : keys ){
            Achievement current = achievements.get(key);
            
            if(!current.isUnlocked){
                int activeProps = 0;
                
                for (String prop1 : current.props) {
                    Property prop = this.props.get(prop1);
                    if(prop.checkIsActive()){
                        activeProps++;
                    }
                }
             if(activeProps == current.props.length){
                 current.isUnlocked = true;
                 unlockedAchivements.add(current);
             }
            }
            
        }
        return unlockedAchivements;
        
        
    }
    
    
}
