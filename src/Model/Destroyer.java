package Model;

import java.util.ArrayList;

public class Destroyer extends Bateau {
    

    private boolean fusee;
  
    
    public Destroyer(String type){
        
        super(type);
        this.taille = 3;
        this.fusee = true;
        this.coule = false;
    }
    
    public ArrayList<Case> tirer(Case c){
        
        if(fusee){
            //this.proprietaire.getAdversaire().getGrille().fuseeEclairante(); //On applique l'effet de la fusee éclairante au premier tir du destroyer sur la grille de l'adversaire;
            this.fusee = false;
        }
        
        return super.tirer(c);
    }
}
