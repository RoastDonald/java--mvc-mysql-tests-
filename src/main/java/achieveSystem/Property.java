/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package achieveSystem;

/**
 *
 * @author a4178
 */
public class Property {
    
    public String name;
    public int value;
    public int activationValue;
    public int initValue;
    
    public Property(String name,int initValue,int activationValue){
        this.name = name;
        this.initValue = initValue;
        this.activationValue = activationValue;
    }
    
    public boolean checkIsActive(){
       return value >= activationValue;
    }
    
    
}
