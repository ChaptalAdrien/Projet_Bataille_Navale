
package Model;

import java.util.ArrayList;


public class Croiseur extends Bateau {
    
        
    private Joueur proprietaire;
    private ArrayList<Case> position;
    private boolean coule;
    
    public Croiseur(Joueur proprietaire, ArrayList<Case> position){
        this.proprietaire = proprietaire;
        this.position = position;
        this.coule = false;
    }
    
//    public ArrayList<Case> tirer(Case c){
        
        //On récupere la grille de l'adversaire
        //Grille gAdversaire = this.proprietaire.getAdversaire().getGrille(); 
        
        
        //Definition des cases touchée par un tir de croiseur : 5 cases autour du point d'impact
 //       ArrayList<Case> caseTouchee;
        
        //on verifie que la case n'est pas au bords du tableau
        //c.auBord();
        
        //for(int i = 0; i < 1; )
        
        
 //   }
    
    
}
