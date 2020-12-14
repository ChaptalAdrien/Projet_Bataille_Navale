package Controller;

import View.VueMenu;
import Model.Partie;

public class ControllerMenu {
    
    private VueMenu vueMenu;
    
    public ControllerMenu(VueMenu vm){
        this.vueMenu = vm;
    }
    
    
    public void choixMenuConsole(int c) throws InterruptedException{
        if(c == 1){
            
            ControllerPartie cp = new ControllerPartie(false);
            cp.creerPartie();
        }
        else if (c == 2){
            throw new UnsupportedOperationException("Not supported yet.");
        } 
        
        else if(c == 3){
            ControllerPartie cp = new ControllerPartie(true);
            cp.creerPartie();
        }
        
        else if (c == 4){
            System.exit(1);
        }
        else{
            throw new IllegalArgumentException("Number not Valid");
        }
        
    }
    
}
