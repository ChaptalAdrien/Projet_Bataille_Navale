
package Model;

import java.util.ArrayList;


public class SousMarin extends Bateau {
    
    
    private Joueur proprietaire;
    private ArrayList<Case> position;
    
    
    public SousMarin(Joueur proprietaire, ArrayList<Case> position){
        this.proprietaire = proprietaire;
        this.position = position;
        
    }
    
    
}
