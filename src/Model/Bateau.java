package Model;

import java.util.ArrayList;

public abstract class Bateau {
    
    private Joueur proprietaire;
    private ArrayList<Case> Position;
    
    public abstract ArrayList<Case> tirer(Case c);
    

}
