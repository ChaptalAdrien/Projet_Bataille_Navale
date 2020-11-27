package Model;

import java.util.ArrayList;


public class Grille {
    
    private ArrayList<Case> grille;
    
    public ModelGrille(){
        
        for(int i = 0; i < 15; i++){
            for(int j = 0; j < 15; j++){
                ModelCase c = new ModelCase(i,j);        
                
                grille.add(c);
            }
        }
        
    }
    
    public ArrayList<ModelCase> getGrille(){
        
        return this.grille;
        
    }
    
}
