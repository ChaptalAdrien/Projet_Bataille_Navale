package Model;
import java.util.ArrayList;

public class Cuirasse extends Bateau {
    
    
    public Cuirasse(String type){
        super(type);
        this.taille = 7;
        this.coule = false;
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
        if((x < g.getTailleX() - 1) && (y < g.getTailleY() - 1)){
            caseTouchee.add(g.getCase(x + 1, y + 1));
        }
        
        if( (x > 0) && (y > 0)){
            caseTouchee.add(g.getCase(x + -1, y - 1));
        }
        
        if((x < g.getTailleX() - 1) && (y > 0)){
            caseTouchee.add(g.getCase(x + 1, y - 1));
        }
        if((x > 0) && (y < g.getTailleY() - 1)){
            caseTouchee.add(g.getCase(x - 1, y + 1));
        }
        
        return caseTouchee;
    }
    
}
