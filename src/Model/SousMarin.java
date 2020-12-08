
package Model;

import java.util.ArrayList;


public class SousMarin extends Bateau {
     
    public SousMarin(Joueur proprietaire, ArrayList<Case> position){

        this.position = position;
        this.coule = false;
    }
    
    
}
