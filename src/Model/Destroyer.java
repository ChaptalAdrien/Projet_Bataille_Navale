package Model;

import java.util.ArrayList;

public class Destroyer extends Bateau {
    
    private Joueur proprietaire;
    private ArrayList<Case> position;
    private boolean fusee;
    private boolean coule;
    
    public Destroyer(Joueur proprietaire, ArrayList<Case> position){
        this.proprietaire = proprietaire;
        this.position = position;
        this.fusee = true;
        this.coule = false;
    }
    
    public ArrayList<Case> tirer(Case c){
        
        if(fusee){
            this.proprietaire.getAdversaire().getGrille().fuseeEclairante(); //On applique l'effet de la fusee éclairante au premier tir du destroyer sur la grille de l'adversaire;
            this.fusee = false;
        }
        
        return super.tirer(c);
    }
}
