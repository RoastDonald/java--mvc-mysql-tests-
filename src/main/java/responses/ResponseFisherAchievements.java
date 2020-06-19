/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responses;

/**
 *
 * @author a4178
 */
public class ResponseFisherAchievements {
    public String date;
    public String name;
    public String displayName;
    public ResponseFisherAchievements(
     String date,
     String name,
     String displayName){
        this.date = date;
        this.displayName = displayName;
        this.name = name;   
    }
    
     @Override
    public String toString() { 
        return String.format( name + "  |  " + displayName); 
    } 
}
