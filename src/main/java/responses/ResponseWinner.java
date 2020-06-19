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
public class ResponseWinner {
    public String name;
    public String date;
    public String displayName;
    
    public ResponseWinner(String name,String date, String displayName){
     this.name = name;
     this.date = date;
     this.displayName =displayName;
    }
    @Override
    public String toString() { 
        return String.format(displayName ); 
    } 
}
