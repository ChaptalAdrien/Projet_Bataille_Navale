package Controller;

import View.VueMenu;
import Model.Partie;

public class ControllerMenu {
    
    private VueMenu vueMenu;
    
    public ControllerMenu(VueMenu vm){
        this.vueMenu = vm;
    }
    
    
    public void choixMenuConsole(int c){
        if(c == 1){
            
            ControllerPartie cp = new ControllerPartie();
            cp.creerPartie();
        }
        else if (c == 2){
            throw new UnsupportedOperationException("Not supported yet.");
        } 
        
        else if (c == 3){
            System.exit(1);
        }
        else{
            throw new IllegalArgumentException("Number not Valid");
        }
        
    }
    
}
