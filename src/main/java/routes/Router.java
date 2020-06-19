/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package routes;
import java.sql.SQLException;


import controllers.LoggerController;
import controllers.MemberInputController;
import controllers.MenuController;

import models.FishingCamp;
import models.Fisher;
import views.CampLogger;

import views.MemberInput;
import views.Menu;

/**
 *
 * @author a4178
 */
public class Router {
    
    public static void createInputWindow(){    
        Fisher model = new Fisher();
        MemberInputController controller = new MemberInputController(model);
        MemberInput view = new MemberInput(controller);
        view.setVisible(true);
       
    }
    
    public static void createMainWindow() throws SQLException{
        Fisher fisherModel = new Fisher();
        FishingCamp fishingCampModel = new FishingCamp();
        MenuController controller = new MenuController(fisherModel,fishingCampModel);
        Menu view = new Menu(controller);
        view.setVisible(true);
    }
    
    public static void createLogger(){
        FishingCamp fishingCampModel = new FishingCamp();
        LoggerController controller = new LoggerController(fishingCampModel);
        CampLogger view = new CampLogger(controller);
        view.setVisible(true);
    }
}
