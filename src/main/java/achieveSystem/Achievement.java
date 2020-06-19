/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package achieveSystem;

import java.util.UUID;

/**
 *
 * @author a4178
 */
public class Achievement {
    public String name;
    public String[] props;
    public boolean isUnlocked;
    public String id;
    
    
    
    public Achievement(){}
    
    public Achievement(String name,String[] props){
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.props = props;
        this.isUnlocked =false;
    }
    
 
    
   

    @Override
    public String toString() { 
        return String.format(name + " " + isUnlocked );
    } 
}
