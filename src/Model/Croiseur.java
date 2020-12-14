
package Model;

import java.util.ArrayList;


public class Croiseur extends Bateau {
    
    
    public Croiseur(String type){
        super(type);
        this.coule = false;
        this.taille = 5;
        
    }
    
   public ArrayList<Case> tirer(Case c, Grille g){
        
        
        int x = c.getX();
        int y = c.getY();
        //Definition des cases touchée par un tir de croiseur : 5 cases autour du point d'impact
        ArrayList<Case> caseTouchee = new ArrayList<Case>();

        caseTouchee.add(c);
        
        if(x < g.getTailleX() - 1){
            caseTouchee.add(g.getCase(x+1, y));
        }
        if(x > 0){ 
            caseTouchee.add(g.getCase(x-1, y));
        }
        if(y < g.getTailleY() - 1){        
            caseTouchee.add(g.getCase(x, y+1));
        }
        if(y > 0){
            caseTouchee.add(g.getCase(x, y-1));
        }
           
        return caseTouchee;
    }
    
}
