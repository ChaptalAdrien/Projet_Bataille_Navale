package Model;

import java.util.ArrayList;

public class Destroyer extends Bateau {
    
    private Joueur proprietaire;
    private ArrayList<Case> position;
    private boolean fusee;
    
    public Destroyer(Joueur proprietaire, ArrayList<Case> position){
        this.proprietaire = proprietaire;
        this.position = position;
        this.fusee = true;
    }
    
}
