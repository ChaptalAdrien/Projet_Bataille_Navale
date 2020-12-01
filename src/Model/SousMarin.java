
package Model;

import java.util.ArrayList;


public class SousMarin extends Bateau {
    
    
    private Joueur proprietaire;
    private ArrayList<Case> position;
    private boolean coule;
    
    public SousMarin(Joueur proprietaire, ArrayList<Case> position){
        this.proprietaire = proprietaire;
        this.position = position;
        this.coule = false;
    }
    
    
}
