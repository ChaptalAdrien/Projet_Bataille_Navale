package Model;

import java.util.ArrayList;


public class Grille {
    
    private ArrayList<Case> grille;
    
    public Grille(){
        
        for(int i = 0; i < 15; i++){
            for(int j = 0; j < 15; j++){
                Case c = new Case(i,j);        
                
                grille.add(c);
            }
        }
        
    }
    
    public ArrayList<Case> getGrille(){
        
        return this.grille;
        
    }
    
}
