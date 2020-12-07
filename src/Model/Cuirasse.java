package Model;
import java.util.ArrayList;

public class Cuirasse extends Bateau {
    
    
    public Cuirasse(Joueur proprietaire, ArrayList<Case> position){
        this.proprietaire = proprietaire;
        this.position = position;
        this.coule = false;
    }
    
    
}
