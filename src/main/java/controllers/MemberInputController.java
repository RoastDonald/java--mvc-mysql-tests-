/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import models.Fisher;

/**
 *
 * @author a4178
 */
public class MemberInputController {
    private final Fisher fisherModel;
    public MemberInputController(Fisher model){
        this.fisherModel = model;
     
    }
    public boolean isNameValid(String name){
        return !name.trim().isEmpty() && name.trim().length() > 3;
    }
    
    public void createFisher(String name){
        var fisher = new Fisher(name);
        fisher.save();
    }
    
   
    
    
    
    
    
    
}
